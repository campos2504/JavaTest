package com.sigabem.controller;


import java.time.OffsetDateTime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sigabem.api.controller.ConsultaFreteController;
import com.sigabem.api.dto.input.ConsultaFreteInput;
import com.sigabem.api.mapper.ConsultaFreteMapper;
import com.sigabem.domain.model.ConsultaFrete;
import com.sigabem.domain.service.ConsultarFreteService;


@ExtendWith(SpringExtension.class)
public class ConsultaFreteControllerTest {

    @InjectMocks
    private ConsultaFreteController controller;

    @Mock
    private ConsultaFreteMapper mapper;

    @Mock
    private ConsultarFreteService serviceMock;



    @BeforeEach
    void setUp() {
        BDDMockito.when(serviceMock.consultarFrete(ArgumentMatchers.any()))
                .thenReturn(create());
        BDDMockito.when(mapper.toOutput(ArgumentMatchers.any()))
        .thenCallRealMethod();
    }

    @Test
    void testConsultarFrete() {
        
        ConsultaFreteInput consultaFreteInput = 
        new ConsultaFreteInput("Joao Carlos", "30160010", "320810420", 2.0);
       
        Assertions.assertThat(controller.consultarFrete(consultaFreteInput).getBody().getCepOrigem())
        .isEqualTo("30160010");
        Assertions.assertThat(controller.consultarFrete(consultaFreteInput).getBody().getCepDestino())
        .isEqualTo("320810420");
        Assertions.assertThat(controller.consultarFrete(consultaFreteInput).getBody().getVlTotalFrete())
        .isEqualTo(1.0);

    }

    private ConsultaFrete create() {
        return ConsultaFrete.builder()
                .id(1L)
                .nomeDestinatario("Joao Carlos")
                .cepOrigem("30160010")
                .cepDestino("320810420")
                .dataConsulta(OffsetDateTime.now())
                .dataPrevistaEntrega(OffsetDateTime.now().plusDays(1))
                .peso(2.0)
                .vlTotalFrete(1.0)
                .build();
    }
}
