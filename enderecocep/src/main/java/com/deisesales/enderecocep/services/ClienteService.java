package com.deisesales.enderecocep.services;

import com.deisesales.enderecocep.dtos.ClienteSalvarDTO;
import com.deisesales.enderecocep.entities.ClienteEntity;
import com.deisesales.enderecocep.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public ClienteEntity salvar(ClienteSalvarDTO data) {
        var cliente = new ClienteEntity(data.nomeCompleto(), data.cpf(), data.email());
        return repository.save(cliente);
    }
}
