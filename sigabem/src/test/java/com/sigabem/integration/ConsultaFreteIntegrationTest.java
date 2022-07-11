package com.sigabem.integration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sigabem.api.dto.input.ConsultaFreteInput;
import com.sigabem.api.dto.output.ConsultaFreteOutput;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
public class ConsultaFreteIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void consultaFrete_retornaValido(){
        ConsultaFreteInput consultaFreteInput = 
        new ConsultaFreteInput("Joao Carlos", "30160010", "31255690", 2.0);
       ResponseEntity<ConsultaFreteOutput> responseEntity = testRestTemplate
        .postForEntity("/consultafrete", consultaFreteInput, ConsultaFreteOutput.class);

        Assertions.assertThat(responseEntity).isNotNull();
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Assertions.assertThat(responseEntity.getBody()).isNotNull().isInstanceOf(ConsultaFreteOutput.class);
    }

    @Test
    void consultaFrete_retornaNaoValido(){
        ConsultaFreteInput consultaFreteInput = 
        new ConsultaFreteInput("Joao Carlos", "3333333", "31255690", 2.0);
       ResponseEntity<ConsultaFreteOutput> responseEntity = testRestTemplate
        .postForEntity("/consultafrete", consultaFreteInput, ConsultaFreteOutput.class);

        Assertions.assertThat(responseEntity).isNotNull();
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
 
    }

}
