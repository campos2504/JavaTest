package com.sigabem.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultaFrete {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeDestinatario;

    @Column(nullable = false)
    private String cepOrigem;

    @Column(nullable = false)
    private String cepDestino;

    @Column(nullable = false)
    private OffsetDateTime dataConsulta;

    @Column(nullable = false)
    private OffsetDateTime dataPrevistaEntrega;

    @Column(nullable = false)
    private Double peso;

    @Column(nullable = false)
    private Double vlTotalFrete;


    public void calcularValorTotalFrete(double desconto, double precoporkg) {

        this.vlTotalFrete=this.peso*precoporkg*desconto;
    }

    public void calcularDataDeEntrega(long diasParaEntregar){

        this.dataPrevistaEntrega=this.dataConsulta.plusDays(diasParaEntregar);

    }

}
