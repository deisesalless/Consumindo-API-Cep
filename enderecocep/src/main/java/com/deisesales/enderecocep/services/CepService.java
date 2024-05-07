package com.deisesales.enderecocep.services;

import com.deisesales.enderecocep.entities.CepEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {

    public CepEntity buscarCep (String cep){
        String url = "http://viacep.com.br/ws/".concat(cep).concat("/json/");

        // é usado para fazer chamadas HTTP para a API externa
        var restTemplate = new RestTemplate();

        // Faz uma requisição GET para a URL especificada e mapeia a resposta para o tipo de objeto CepDTO
        // Retorna o corpo da resposta, que contém os detalhes do CEP conforme definido na classe CepDTO
        return restTemplate.getForEntity(url, CepEntity.class).getBody();

    }
}
