package com.sigabem.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class ConsultaFrete {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeDestinatario;

    private String cepOrigem;

    private String cepDestino;

    private OffsetDateTime dataConsulta;

    private OffsetDateTime dataPrevistaEntrega;

    private Double peso;

    private Double vlTotalFrete;


    public void calcularValorTotalFrete(double desconto, double precoporkg) {

        this.vlTotalFrete=this.peso*precoporkg*desconto;
    }

    public void calcularDataDeEntrega(long diasParaEntregar){

        this.dataPrevistaEntrega=this.dataConsulta.plusDays(diasParaEntregar);

    }

}
