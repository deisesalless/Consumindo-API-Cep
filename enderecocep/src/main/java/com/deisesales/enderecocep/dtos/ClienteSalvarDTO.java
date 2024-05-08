package com.deisesales.enderecocep.dtos;

import jakarta.validation.Valid;

public record ClienteSalvarDTO(String nomeCompleto, String cpf, String email) {
}
