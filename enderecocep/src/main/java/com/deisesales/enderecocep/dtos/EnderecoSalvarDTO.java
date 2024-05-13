package com.deisesales.enderecocep.dtos;

import com.deisesales.enderecocep.entities.CepEntity;
import jakarta.validation.Valid;

public record EnderecoSalvarDTO(Integer numero, @Valid CepEntity api) {
}
