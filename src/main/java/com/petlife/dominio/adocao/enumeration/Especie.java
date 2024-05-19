package com.petlife.dominio.adocao.enumeration;

import lombok.Getter;

public enum Especie {
    CACHORRO("Cachorro"),
    GATO("Gato");

    @Getter
    private final String descricao;

    Especie(String descricao) {
        this.descricao = descricao;
    }
}
