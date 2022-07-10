package com.sigabem.api.dto.output;


import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ConsultaFreteOutput {

    private String cepOrigem;
    private String cepDestino;
    private OffsetDateTime dataPrevistaEntrega;
    private Double vlTotalFrete;
}
