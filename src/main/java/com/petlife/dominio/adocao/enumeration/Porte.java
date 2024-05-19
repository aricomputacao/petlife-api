package com.petlife.dominio.adocao.enumeration;

import lombok.Getter;

public enum Porte {
    PEQUENO("Pequeno"),
    MEDIO("Médio"),
    GRANDE("Grande");

    @Getter
    private final String descricao;

    Porte(String descricao) {
        this.descricao = descricao;
    }
}
