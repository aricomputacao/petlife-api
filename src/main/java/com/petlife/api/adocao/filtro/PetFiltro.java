package com.petlife.api.adocao.filtro;

import com.petlife.dominio.adocao.enumeration.Especie;
import com.petlife.dominio.adocao.enumeration.Porte;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetFiltro {
    private Especie especie;
    private String raca;
    private Porte porte;
    private Integer idade;
}
