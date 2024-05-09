package com.deisesales.enderecocep.controllers;

import com.deisesales.enderecocep.entities.CepEntity;
import com.deisesales.enderecocep.services.CepService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/pesquisar")
public class CepController {

    @Autowired
    private CepService service;

    @GetMapping("/{cep}")
    public ResponseEntity<CepEntity> buscar(@PathVariable @Valid String cep) {
        var resposta = service.buscarCep(cep);

        if (resposta == null || resposta.getCep() == null || resposta.getCep().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // ResponseEntity.status(HttpStatus.FOUND).body(resposta)
        return ResponseEntity.status(HttpStatus.FOUND).body(resposta);
    }

}
