package com.sigabem.api.mapper;

import org.springframework.stereotype.Component;

import com.sigabem.api.dto.input.ConsultaFreteInput;
import com.sigabem.api.dto.output.ConsultaFreteOutput;
import com.sigabem.domain.model.ConsultaFrete;



@Component
public class ConsultaFreteMapper {

    public ConsultaFreteOutput toOutput(ConsultaFrete consultaFrete) {

        return ConsultaFreteOutput.builder()
        .cepDestino(consultaFrete.getCepDestino())
        .cepOrigem(consultaFrete.getCepOrigem())
        .dataPrevistaEntrega(consultaFrete.getDataPrevistaEntrega())
        .vlTotalFrete(consultaFrete.getVlTotalFrete())
        .build();
    }
    public ConsultaFrete toEntity(ConsultaFreteInput consultaFreteInput) {

        ConsultaFrete consultaFrete = new ConsultaFrete();
        consultaFrete.setCepDestino(consultaFreteInput.getCepDestino());
        consultaFrete.setCepOrigem(consultaFreteInput.getCepOrigem());
        consultaFrete.setNomeDestinatario(consultaFreteInput.getNomeDestinatario());
        consultaFrete.setPeso(consultaFreteInput.getPeso());
        return consultaFrete;
    }
    
}
