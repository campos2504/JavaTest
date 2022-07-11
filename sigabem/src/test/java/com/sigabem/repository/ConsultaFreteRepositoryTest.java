package com.sigabem.repository;

import java.time.OffsetDateTime;

import org.assertj.core.api.Assertions;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sigabem.domain.model.ConsultaFrete;
import com.sigabem.domain.repository.ConsultaFreteRepository;

@DataJpaTest
@DisplayName("Testes para o repositorio de ConsultaFrete")
public class ConsultaFreteRepositoryTest {

    @Autowired
    private ConsultaFreteRepository repository;

    @Test
    @DisplayName("Save persist ConsultaFrete quando é bem sucedido' ")
    void save_PersistConsultaFrete_whenSuccessfull() {

        ConsultaFrete consultaFreteToBeSaved = create();
        ConsultaFrete consultaFreteSaved = this.repository.save(consultaFreteToBeSaved);
        Assertions.assertThat(consultaFreteSaved).isNotNull();
        Assertions.assertThat(consultaFreteSaved.getId()).isNotNull();
        Assertions.assertThat(consultaFreteSaved.getNomeDestinatario())
                .isEqualTo(consultaFreteToBeSaved.getNomeDestinatario());
        Assertions.assertThat(consultaFreteSaved.getCepOrigem())
                .isEqualTo(consultaFreteToBeSaved.getCepOrigem());
        Assertions.assertThat(consultaFreteSaved.getCepDestino())
                .isEqualTo(consultaFreteToBeSaved.getCepDestino());
        Assertions.assertThat(consultaFreteSaved.getDataConsulta())
                .isEqualTo(consultaFreteToBeSaved.getDataConsulta());
        Assertions.assertThat(consultaFreteSaved.getDataPrevistaEntrega())
                .isEqualTo(consultaFreteToBeSaved.getDataPrevistaEntrega());
        Assertions.assertThat(consultaFreteSaved.getPeso())
                .isEqualTo(consultaFreteToBeSaved.getPeso());
        Assertions.assertThat(consultaFreteSaved.getVlTotalFrete())
                .isEqualTo(consultaFreteToBeSaved.getVlTotalFrete());
    }

    @Test
    @DisplayName("Save joga uma Exception quando não valido ")
    void save_ThrowsException_whenNotValid() {
        ConsultaFrete consultaFreteToBeSaved = new ConsultaFrete();
        Assertions.assertThatThrownBy(() -> this.repository.save(consultaFreteToBeSaved))
                .hasCauseInstanceOf(ConstraintViolationException.class);

    }

    private ConsultaFrete create() {
        return ConsultaFrete.builder()
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