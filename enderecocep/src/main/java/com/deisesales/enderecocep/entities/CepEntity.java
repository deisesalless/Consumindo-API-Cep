package com.deisesales.enderecocep.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CepEntity {

    @Pattern(regexp = "\\d{5}-\\d{3}")
    private String cep;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String complemento;

    @NotBlank
    private String bairro;

    @NotBlank
    private String localidade;

    @NotBlank
    private String uf;

}
