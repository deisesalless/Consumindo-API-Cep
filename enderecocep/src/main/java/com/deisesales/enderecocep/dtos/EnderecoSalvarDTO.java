package com.deisesales.enderecocep.dtos;

import com.deisesales.enderecocep.entities.CepEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record EnderecoSalvarDTO(@NotNull Integer numero, @Valid CepEntity api) {
}
