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

import static org.springframework.http.HttpStatus.FOUND;

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

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoEntity> buscarPorID(@PathVariable Integer id) {
        var endereco = service.buscarPorID(id);

        return endereco.map(enderecoEntity ->
                ResponseEntity.status(FOUND).body(enderecoEntity)).orElseGet(() ->
                ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoEntity> atualizarPorID(@PathVariable Integer id, @RequestBody EnderecoSalvarDTO dados) {
        var endereco = service.buscarPorID(id);

        if (endereco.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(FOUND).body(service.atualizarPorID(id, dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Integer id) {
        var endereco = service.buscarPorID(id);

        if (endereco.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
