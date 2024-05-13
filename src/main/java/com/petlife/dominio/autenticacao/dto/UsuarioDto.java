package com.petlife.dominio.autenticacao.dto;

import com.petlife.dominio.autenticacao.entity.Usuario;
import com.petlife.dominio.endereco.Endereco;

public record UsuarioDto(
        String cpf,
        String nome,
        String email,
        Endereco endereco) {

    public UsuarioDto(Usuario usuario) {
        this(usuario.getCpf(), usuario.getNome(), usuario.getEmail(), usuario.getEndereco());
    }
}
