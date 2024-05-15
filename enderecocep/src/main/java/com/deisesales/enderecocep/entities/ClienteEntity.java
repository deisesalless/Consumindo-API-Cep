package com.deisesales.enderecocep.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nomeCompleto;

    @CPF
    @Pattern(regexp = "[0-9]{11}")
    @Column(name = "CPF", unique = true, nullable = false)
    private String cpf;

    @Email
    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "cliente")
    private List<EnderecoEntity> listaEndereco = new ArrayList<>();

    public ClienteEntity(String nomeCompleto, String cpf, String email) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.email = email;
    }
}
