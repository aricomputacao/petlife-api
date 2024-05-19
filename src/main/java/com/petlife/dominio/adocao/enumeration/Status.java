package com.petlife.dominio.adocao.enumeration;

import lombok.Getter;

public enum Status {
    ADOTADO("Adotado"),
    DISPONIVEL("Disponível"),;

    @Getter
    private String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

}
