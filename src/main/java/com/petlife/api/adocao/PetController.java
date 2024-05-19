package com.petlife.api.adocao;

import com.petlife.api.adocao.filtro.PetFiltro;
import com.petlife.dominio.adocao.dto.DadosCadastroPet;
import com.petlife.dominio.adocao.dto.DadosConsultaPet;
import com.petlife.dominio.adocao.entity.Pet;
import com.petlife.dominio.adocao.repository.PetRepository;
import com.petlife.dominio.adocao.service.PetService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/pets")
public class PetController {

    private PetRepository petRepository;
    private PetService petService;

    @GetMapping()
    public Page<DadosConsultaPet> pesquisar(PetFiltro petFiltro, Pageable pageable) {
        return petRepository.filtrar(petFiltro, pageable);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DadosCadastroPet> criar(@Valid @RequestBody DadosCadastroPet dados,
                                                  UriComponentsBuilder uriComponentsBuilder) {
        Pet petSalvo = petRepository.save(new Pet(dados));
        var uri = uriComponentsBuilder.path("/api/v1/pets/{id}").buildAndExpand(petSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosCadastroPet(petSalvo));
    }

    @PutMapping("/{idPet}/adotar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizarAdocao(@PathVariable Long idPet,@RequestParam(required = true) Long idAdotante) {
        petService.finalizarAdocao(idPet,idAdotante);

    }
}
