package com.deisesales.enderecocep.controllers;

import com.deisesales.enderecocep.dtos.EnderecoSalvarDTO;
import com.deisesales.enderecocep.entities.EnderecoEntity;
import com.deisesales.enderecocep.services.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @PostMapping
    public ResponseEntity<EnderecoEntity> salvar(@RequestBody @Valid EnderecoSalvarDTO data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(data));
    }

    @GetMapping("/{cep}")
    public ResponseEntity<EnderecoEntity> buscarCep(@PathVariable @Valid String cep) {

        String url = "http://viacep.com.br/ws/" + cep + "/json/";
        var restTemplate = new RestTemplate();
        var resposta = restTemplate.getForEntity(url, EnderecoEntity.class);
        var dados = resposta.getBody();
        EnderecoEntity endereco = new EnderecoEntity();
        endereco.setCep(dados.getCep());
        endereco.setLogradouro(dados.getLogradouro());
        endereco.setComplemento(dados.getComplemento());
        endereco.setBairro(dados.getBairro());
        endereco.setLocalidade(dados.getLocalidade());
        endereco.setUf(dados.getUf());

        return ResponseEntity.ok().body(endereco);
    }
}
