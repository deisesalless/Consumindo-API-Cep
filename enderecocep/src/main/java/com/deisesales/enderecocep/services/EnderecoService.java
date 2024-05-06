package com.deisesales.enderecocep.services;

import com.deisesales.enderecocep.dtos.EnderecoSalvarDTO;
import com.deisesales.enderecocep.entities.EnderecoEntity;
import com.deisesales.enderecocep.repositories.EnderecoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public EnderecoEntity salvar(@Valid EnderecoSalvarDTO data) {
        var endereco = new EnderecoEntity(data.cep(), data.logradouro(), data.complemento(), data.bairro(), data.localidade(), data.uf());
        return repository.save(endereco);
    }

}
