package com.sigabem.mapper;

import java.time.OffsetDateTime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sigabem.api.dto.input.ConsultaFreteInput;
import com.sigabem.api.mapper.ConsultaFreteMapper;
import com.sigabem.domain.model.ConsultaFrete;

public class ConsultaFreteMapperTest {

    private ConsultaFreteMapper consultaFreteMapper;

    @BeforeEach
    void setUp() {
        this.consultaFreteMapper = new ConsultaFreteMapper();
    }

    @Test
    void testToEntity() {
        
        ConsultaFreteInput consultaFreteInput =
        ConsultaFreteInput.builder()
        .nomeDestinatario("Joao")
        .cepDestino("30160010")
        .cepOrigem("320810420")
        .peso(1.0)
        .build();

       Assertions.assertThat(consultaFreteMapper.toEntity(consultaFreteInput).getCepOrigem())
       .isEqualTo("320810420");
        Assertions.assertThat(consultaFreteMapper.toEntity(consultaFreteInput).getCepDestino())
        .isEqualTo("30160010");
        Assertions.assertThat(consultaFreteMapper.toEntity(consultaFreteInput).getPeso())
        .isEqualTo(1);
        Assertions.assertThat(consultaFreteMapper.toEntity(consultaFreteInput).getNomeDestinatario())
        .isEqualTo("Joao");
        


    }

    @Test
    void testToOutput() {

        ConsultaFrete consultaFrete = ConsultaFrete.builder()
        .nomeDestinatario("Joao Carlos")
        .cepOrigem("30160010")
        .cepDestino("320810420")
        .dataConsulta(OffsetDateTime.now())
        .peso(2.0)
        .vlTotalFrete(1.0)
        .build();
        consultaFrete.calcularDataDeEntrega(1L);

        Assertions.assertThat(consultaFreteMapper.toOutput(consultaFrete).getCepDestino())
       .isEqualTo("320810420");
       Assertions.assertThat(consultaFreteMapper.toOutput(consultaFrete).getCepOrigem())
       .isEqualTo("30160010");
       Assertions.assertThat(consultaFreteMapper.toOutput(consultaFrete).getDataPrevistaEntrega())
       .isEqualTo(consultaFrete.getDataConsulta().plusDays(1L));
       Assertions.assertThat(consultaFreteMapper.toOutput(consultaFrete).getVlTotalFrete())
       .isEqualTo(1);


    }

}
