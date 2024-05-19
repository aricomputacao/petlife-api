package com.petlife.dominio.adocao.entity;

import com.petlife.dominio.adocao.dto.DadosCadastroPet;
import com.petlife.dominio.adocao.enumeration.Especie;
import com.petlife.dominio.adocao.enumeration.Porte;
import com.petlife.dominio.adocao.enumeration.Status;
import com.petlife.dominio.autenticacao.entity.Usuario;
import com.petlife.dominio.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Table(name = "pet")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Long id;

    @NotEmpty
    @Column(name = "pet_nome", nullable = false)
    private String nome;

    @NotNull
    @Column(name = "pet_especie", nullable = false)
    @Enumerated(EnumType.STRING)
    private Especie especie;

    @NotNull
    @Column(name = "pet_porte", nullable = false)
    @Enumerated(EnumType.STRING)
    private Porte porte;

    @NotNull
    @Column(name = "pet_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotEmpty
    @Column(name = "pet_raca", nullable = false)
    private String raca;

    @Column(name = "pet_cartao_vacinacao", unique = true)
    private String cartaoVacinacao;

    @NotNull
    @Min(1)
    @Column(name = "pet_idade", nullable = false)
    private Integer idade;

    @Valid
    @Embedded
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "usr_doador_id", referencedColumnName = "usr_id", nullable = false, updatable = false,
            foreignKey = @ForeignKey(name = "fk_usuario_doador"))
    private Usuario doador;

    @ManyToOne
    @JoinColumn(name = "usr_adotante_id", referencedColumnName = "usr_id",
            foreignKey = @ForeignKey(name = "fk_usuario_adotante"))
    private Usuario adotante;

    public Pet(DadosCadastroPet dadosCadastroPet) {
        this.nome = dadosCadastroPet.nome();
        this.especie = dadosCadastroPet.especie();
        this.porte = dadosCadastroPet.porte();
        this.status = dadosCadastroPet.status();
        this.raca = dadosCadastroPet.raca();
        this.cartaoVacinacao = dadosCadastroPet.cartaoVacinacao();
        this.idade = dadosCadastroPet.idade();
        this.endereco = dadosCadastroPet.endereco();
    }


}
