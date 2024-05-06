package com.deisesales.enderecocep.dtos;

public record EnderecoSalvarDTO(String cep, String logradouro, String complemento, String bairro, String localidade, String uf) {
}
