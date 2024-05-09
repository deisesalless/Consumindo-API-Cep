package com.deisesales.enderecocep.services;

import com.deisesales.enderecocep.dtos.ClienteAtualizarDTO;
import com.deisesales.enderecocep.dtos.ClienteSalvarDTO;
import com.deisesales.enderecocep.entities.ClienteEntity;
import com.deisesales.enderecocep.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public ClienteEntity salvar(ClienteSalvarDTO data) {
        var cliente = new ClienteEntity(data.nomeCompleto(), data.cpf(), data.email());
        return repository.save(cliente);
    }

    public List<ClienteEntity> listarTodos() {
        return repository.findAll();
    }

    public Optional<ClienteEntity> buscarPorID(Integer id) {
        return repository.findById(id);
    }

    public ClienteEntity atualizarPorID(Integer id, ClienteAtualizarDTO dados) {
        Optional<ClienteEntity> cliente = repository.findById(id);

        var nome = dados.nomeCompleto().isEmpty() ? cliente.get().getNomeCompleto() : dados.nomeCompleto();
        var cpf = dados.cpf().isEmpty() ? cliente.get().getCpf() : dados.cpf();
        var email = dados.email().isEmpty() ? cliente.get().getEmail() : dados.email();

        cliente.get().setNomeCompleto(nome);
        cliente.get().setCpf(cpf);
        cliente.get().setEmail(email);

        return repository.save(cliente.get());
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
