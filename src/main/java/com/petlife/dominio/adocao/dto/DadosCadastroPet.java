package com.petlife.dominio.adocao.dto;

import com.petlife.dominio.adocao.entity.Pet;
import com.petlife.dominio.adocao.enumeration.Especie;
import com.petlife.dominio.adocao.enumeration.Porte;
import com.petlife.dominio.adocao.enumeration.Status;
import com.petlife.dominio.autenticacao.entity.Usuario;
import com.petlife.dominio.endereco.Endereco;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPet(

        @NotEmpty
        String nome,

        @NotNull
        Especie especie,

        @NotNull
        Porte porte,

        @NotNull
        Status status,

        @NotEmpty
        String raca,

        String cartaoVacinacao,

        @NotNull
        @Min(1)
        Integer idade,

        Endereco endereco,

        @NotNull
        Usuario doador
) {
    public DadosCadastroPet(Pet pet) {
        this(pet.getNome(), pet.getEspecie(), pet.getPorte(), pet.getStatus(),
                pet.getRaca(), pet.getCartaoVacinacao(), pet.getIdade(),
                pet.getEndereco(), pet.getDoador());
    }
}
