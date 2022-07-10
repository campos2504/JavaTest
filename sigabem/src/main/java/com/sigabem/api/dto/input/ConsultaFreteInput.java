package com.sigabem.api.dto.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ConsultaFreteInput {

    @NotBlank
    private String nomeDestinatario;
    @NotBlank
    @Pattern(regexp = "^[0-9]+$")
    @Size(min = 8, max = 8)
    private String cepOrigem;
    @NotBlank
    @Pattern(regexp = "^[0-9]+$")
    @Size(min = 8, max = 8)
    private String cepDestino;
    @NonNull
    @Positive
    private Double peso;

}
