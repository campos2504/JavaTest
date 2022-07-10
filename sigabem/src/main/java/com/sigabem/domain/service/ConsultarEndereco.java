package com.sigabem.domain.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sigabem.domain.exception.NegocioException;
import com.sigabem.domain.model.Endereco;

@Component
public class ConsultarEndereco {

    private final static String URL = "https://viacep.com.br/ws/";
    private final static String FORMATO = "/json/";

    public Endereco buscarEnderecoPeloCep(String cep) {

        String url = URL + cep + FORMATO;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Endereco> response = restTemplate
                .getForEntity(url, Endereco.class);

        if (response.getBody().getCep() == null) {
            throw new NegocioException("O CEP de numero " + cep + " não é valido");
        }
        return response.getBody();
    }

}
