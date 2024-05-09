package com.deisesales.enderecocep.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_endereco")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer numero;

    @Embedded
    private CepEntity api;

    public EnderecoEntity(Integer numero, CepEntity api) {
        this.numero = numero;
        this.api = new CepEntity(api.getCep(), api.getLogradouro(), api.getComplemento(), api.getBairro(), api.getLocalidade(), api.getUf());
    }
}
