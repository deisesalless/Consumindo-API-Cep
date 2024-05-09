package com.deisesales.enderecocep.controllers;

import com.deisesales.enderecocep.dtos.EnderecoSalvarDTO;
import com.deisesales.enderecocep.entities.EnderecoEntity;
import com.deisesales.enderecocep.services.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @PostMapping
    public ResponseEntity<EnderecoEntity> salvar(@RequestBody @Valid EnderecoSalvarDTO data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(data));
    }

    @GetMapping
    public ResponseEntity<List<EnderecoEntity>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodos());
    }

}
