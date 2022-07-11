package com.sigabem.domain;

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

import com.sigabem.domain.model.ConsultaFrete;
import com.sigabem.domain.model.Endereco;
import com.sigabem.domain.repository.ConsultaFreteRepository;
import com.sigabem.domain.service.ConsultarEndereco;
import com.sigabem.domain.service.ConsultarFreteService;

@ExtendWith(SpringExtension.class)
public class ConsultarFreteServiceTest {


    @InjectMocks
    private ConsultarFreteService service;

    @Mock
    private ConsultaFreteRepository repositoryMock;

    @Mock
    private ConsultarEndereco consultarEndereco;

    @BeforeEach
    void setUp(){
        BDDMockito.when(repositoryMock.save(ArgumentMatchers.any()))
        .thenReturn(create());
        BDDMockito.when(consultarEndereco.buscarEnderecoPeloCep(ArgumentMatchers.any()))
        .thenReturn(Endereco.builder().ddd("31").build());

    }


    @Test
    void testConsultarFrete() {

        Assertions.assertThat(service.consultarFrete(createInput()).getId()).
        isNotNull();


    }

    private ConsultaFrete createInput() {
        return ConsultaFrete.builder()
                .nomeDestinatario("Joao Carlos")
                .cepOrigem("30160010")
                .cepDestino("320810420")
                .dataConsulta(OffsetDateTime.now())
                .peso(2.0)
                .build();
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
