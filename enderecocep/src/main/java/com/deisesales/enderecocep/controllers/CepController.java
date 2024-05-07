package com.deisesales.enderecocep.controllers;

import com.deisesales.enderecocep.entities.CepEntity;
import com.deisesales.enderecocep.services.CepService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/buscarcep")
public class CepController {

    @Autowired
    private CepService service;

    @GetMapping("/{cep}")
    public CepEntity buscar(@PathVariable @Valid String cep) {
        String url = "http://viacep.com.br/ws/".concat(cep).concat("/json/");
        var restTemplate = new RestTemplate();
        var endereco = restTemplate.getForEntity(url, CepEntity.class);
        return endereco.getBody();
    }

}
