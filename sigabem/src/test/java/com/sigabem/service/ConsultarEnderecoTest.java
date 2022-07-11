package com.sigabem.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sigabem.domain.service.ConsultarEndereco;

@ExtendWith(SpringExtension.class)
public class ConsultarEnderecoTest {

    @InjectMocks
    private ConsultarEndereco consultarEndereco;

    @Test
    void test_BuscarEnderecoPeloCep_Valid() {

        Assertions.assertThat(this.consultarEndereco.buscarEnderecoPeloCep("30160010").getDdd())
        .isEqualTo("31");

    }

}
