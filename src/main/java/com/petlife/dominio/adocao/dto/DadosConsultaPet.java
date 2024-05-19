package com.petlife.dominio.adocao.dto;

import com.petlife.dominio.adocao.entity.Pet;
import com.petlife.dominio.adocao.enumeration.Especie;
import com.petlife.dominio.adocao.enumeration.Porte;
import com.petlife.dominio.adocao.enumeration.Status;
import com.petlife.dominio.autenticacao.entity.Usuario;
import com.petlife.dominio.endereco.Endereco;

public record DadosConsultaPet(Especie especie, Porte porte, Status status, String raca, String cartao, Integer idade,
                               Endereco endereco, Usuario doador) {

    public DadosConsultaPet(Pet pet) {
        this(pet.getEspecie(), pet.getPorte(), pet.getStatus(), pet.getRaca(), pet.getCartaoVacinacao(), pet.getIdade(), pet.getEndereco(), pet.getDoador());
    }
}
