package com.deisesales.enderecocep.services;

import com.deisesales.enderecocep.dtos.EnderecoSalvarDTO;
import com.deisesales.enderecocep.entities.EnderecoEntity;
import com.deisesales.enderecocep.repositories.EnderecoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public EnderecoEntity salvar(@Valid EnderecoSalvarDTO data) {
        var endereco = new EnderecoEntity(data.numero(), data.api());
        return repository.save(endereco);
    }

    public List<EnderecoEntity> listarTodos() {
        return repository.findAll();
    }

}
