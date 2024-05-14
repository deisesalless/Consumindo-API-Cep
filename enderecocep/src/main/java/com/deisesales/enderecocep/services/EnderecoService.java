package com.deisesales.enderecocep.services;

import com.deisesales.enderecocep.dtos.EnderecoSalvarDTO;
import com.deisesales.enderecocep.entities.CepEntity;
import com.deisesales.enderecocep.entities.EnderecoEntity;
import com.deisesales.enderecocep.repositories.EnderecoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<EnderecoEntity> buscarPorID(Integer id) {
        return repository.findById(id);
    }

    public EnderecoEntity atualizarPorID(Integer id, EnderecoSalvarDTO dados) {
        Optional<EnderecoEntity> endereco = repository.findById(id);

        var numero = dados.numero() != null ? dados.numero() : endereco.get().getNumero();
        var cep = endereco.get().getApi().getCep();
        var logradouro = endereco.get().getApi().getLogradouro();
        var complemento = dados.api().getComplemento() != null ? dados.api().getComplemento() : endereco.get().getApi().getComplemento();
        var bairro = endereco.get().getApi().getBairro();
        var localidade = endereco.get().getApi().getLocalidade();
        var uf = endereco.get().getApi().getUf();
        var enderecoAtualizado = new EnderecoEntity(id, numero, new CepEntity(cep, logradouro, complemento, bairro, localidade, uf));

        return repository.save(enderecoAtualizado);
    }

    public void delete (Integer id) {
        repository.deleteById(id);
    }

}
