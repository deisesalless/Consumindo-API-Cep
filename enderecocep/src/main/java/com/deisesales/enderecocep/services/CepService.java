package com.deisesales.enderecocep.services;

import com.deisesales.enderecocep.entities.CepEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {

    public CepEntity buscarCep (String cep){
        String url = "http://viacep.com.br/ws/".concat(cep).concat("/json/");

        /*
        Rest Template responsável pela chamada HTTP para a API externa
        faz um request GET com a URL, mapeia a resposta para o tipo de classe CepEntity
        Retorna o json, que contém o corpo do CEP conforme definido na classe CepEntity
        */
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(url, CepEntity.class).getBody();
    }
}
