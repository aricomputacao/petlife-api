package com.petlife.dominio.endereco;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @NotEmpty
    @Column(name = "end_logradouro",nullable = false)
    private String logradouro;

    @Column(name = "end_numero")
    private Integer numero;

    @Column(name = "end_complemento")
    private String complemento;

    @NotEmpty
    @Column(name = "end_bairro",nullable = false)
    private String bairro;

    @NotEmpty
    @Column(name = "end_cidade",nullable = false)
    private String cidade;

    @NotEmpty
    @Column(name = "end_estado",nullable = false)
    private String estado;

    @Column(name = "end_cep")
    private String cep;

}
