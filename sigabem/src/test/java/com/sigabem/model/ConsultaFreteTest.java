package com.sigabem.model;

import java.time.OffsetDateTime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sigabem.domain.model.ConsultaFrete;



public class ConsultaFreteTest {
    

    @Test
    void testCalcularDataDeEntrega() {

        ConsultaFrete consultaFrete = create();

        consultaFrete.calcularDataDeEntrega(1L);
        Assertions.assertThat(consultaFrete.getDataPrevistaEntrega())
        .isEqualTo(consultaFrete.getDataConsulta().plusDays(1L));

        consultaFrete.calcularDataDeEntrega(3L);
        Assertions.assertThat(consultaFrete.getDataPrevistaEntrega())
        .isEqualTo(consultaFrete.getDataConsulta().plusDays(3L));

    }

    @Test
    void testCalcularValorTotalFrete() {
        ConsultaFrete consultaFrete = create();

        consultaFrete.calcularValorTotalFrete(0.5, 1);
        Assertions.assertThat(consultaFrete.getVlTotalFrete())
        .isEqualTo(1);

        consultaFrete.calcularValorTotalFrete(1.0, 1);
        Assertions.assertThat(consultaFrete.getVlTotalFrete())
        .isEqualTo(2);

        consultaFrete.calcularValorTotalFrete(1.0, 2);
        Assertions.assertThat(consultaFrete.getVlTotalFrete())
        .isEqualTo(4.0);

    }

    private ConsultaFrete create(){
        return ConsultaFrete.builder()
        .dataConsulta(OffsetDateTime.now())
        .peso(2.0)
        .build();
    }
}
