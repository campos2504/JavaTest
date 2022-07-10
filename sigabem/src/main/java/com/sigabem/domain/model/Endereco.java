package com.sigabem.domain.model;

import lombok.Data;

@Data
public class Endereco {
    String cep;
    String logradouro;
    String complemento;
    String bairro;
    String localidade;
    String uf;
    String ibge;
    String gia; 
    String ddd; 
    String siafi; 
    
}
