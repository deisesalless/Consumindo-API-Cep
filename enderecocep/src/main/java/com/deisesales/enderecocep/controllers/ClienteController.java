package com.deisesales.enderecocep.controllers;

import com.deisesales.enderecocep.dtos.ClienteAtualizarDTO;
import com.deisesales.enderecocep.dtos.ClienteSalvarDTO;
import com.deisesales.enderecocep.entities.ClienteEntity;
import com.deisesales.enderecocep.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteEntity> salvar(@RequestBody @Valid ClienteSalvarDTO data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(data));
    }

    @GetMapping
    public ResponseEntity<List<ClienteEntity>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> buscarPorID(@PathVariable Integer id) {
        var cliente = service.buscarPorID(id);

        return cliente.map(clienteEntity ->
                ResponseEntity.status(HttpStatus.FOUND).body(clienteEntity)).orElseGet(() ->
                ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteEntity> atualizarPorID(@PathVariable Integer id, @RequestBody ClienteAtualizarDTO dados) {
        var cliente = service.buscarPorID(id);
        if (cliente.isEmpty()) ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.status(HttpStatus.OK).body(service.atualizarPorID(id, dados));
    }
}
