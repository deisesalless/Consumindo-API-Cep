package com.deisesales.enderecocep.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "cliente_ID")
    private ClienteEntity cliente;

    public EnderecoEntity(Integer id, Integer numero, CepEntity api) {
        this.id = id;
        this.numero = numero;
        this.api = new CepEntity(api.getCep(), api.getLogradouro(), api.getComplemento(), api.getBairro(), api.getLocalidade(), api.getUf());
    }

    public EnderecoEntity(Integer numero, CepEntity api) {
        this.numero = numero;
        this.api = new CepEntity(api.getCep(), api.getLogradouro(), api.getComplemento(), api.getBairro(), api.getLocalidade(), api.getUf());
    }
}
