package com.sigabem.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import com.sigabem.domain.model.ConsultaFrete;
import com.sigabem.domain.model.Endereco;
import com.sigabem.domain.repository.ConsultaFreteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConsultarFreteService {

    private final static double PRECO_POR_KG = 1.00;

    private final ConsultarEndereco consultarEndereco;
    private final ConsultaFreteRepository repository;

    public ConsultaFrete consultarFrete(ConsultaFrete consultaFrete) {

        consultaFrete.setDataConsulta(OffsetDateTime.now());
        calcularFrete(consultaFrete);

        return repository.save(consultaFrete);
    }

    private void calcularFrete(ConsultaFrete consultaFrete) {
        String tipo = classificarFrete(consultaFrete);
        double descontoDoFrete;
        int diasParaEntregar;
        System.out.println(tipo);

        switch (tipo) {
            case "LOCAL":
                descontoDoFrete = 0.5;
                diasParaEntregar = 1;

                break;
            case "ESTADUAL":
                descontoDoFrete = 0.75;
                diasParaEntregar = 3;

                break;
            default:
                descontoDoFrete = 1;
                diasParaEntregar = 10;

                break;

        }
        consultaFrete.calcularValorTotalFrete(descontoDoFrete, PRECO_POR_KG);
        consultaFrete.calcularDataDeEntrega(diasParaEntregar);

    }

    private String classificarFrete(ConsultaFrete consultaFrete) {
        Endereco origem = consultarEndereco.buscarEnderecoPeloCep(consultaFrete.getCepOrigem());
        Endereco destino = consultarEndereco.buscarEnderecoPeloCep(consultaFrete.getCepDestino());

        if (origem.getDdd().equals(destino.getDdd())) {
            return "LOCAL";
        }
        if (origem.getUf().equals(destino.getUf())) {
            return "ESTADUAL";
        }
        return "INTERESTADUAL";
    }

}
