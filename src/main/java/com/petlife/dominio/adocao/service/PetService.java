package com.petlife.dominio.adocao.service;

import com.petlife.dominio.adocao.entity.Pet;
import com.petlife.dominio.adocao.enumeration.Status;
import com.petlife.dominio.adocao.repository.PetRepository;
import com.petlife.dominio.autenticacao.entity.Usuario;
import com.petlife.dominio.autenticacao.repository.UsuarioRepository;
import com.petlife.infra.exception.RegraDeNegocioException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PetService {

    private PetRepository petRepository;
    private UsuarioRepository usuarioRepository;

    public void finalizarAdocao(Long idPet, Long idAdotante) {

        Pet pet = petRepository.findById(idPet).orElseThrow(() -> new RegraDeNegocioException("Pet não encontrado" +
                " id " + idPet));

        Usuario adotante = usuarioRepository.findById(idAdotante)
                .orElseThrow(() -> new RegraDeNegocioException("Não existe adotante com o id " + idAdotante));

        pet.setAdotante(adotante);
        pet.setStatus(Status.ADOTADO);
        petRepository.save(pet);
    }
}
