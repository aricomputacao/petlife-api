package com.petlife.api.autenticacao;

import com.petlife.dominio.autenticacao.dto.UsuarioDto;
import com.petlife.dominio.autenticacao.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    @GetMapping
    public Page<UsuarioDto> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return usuarioRepository.findAll(paginacao).map(UsuarioDto::new);
    }
}
