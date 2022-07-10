package com.sigabem.api.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigabem.api.dto.input.ConsultaFreteInput;
import com.sigabem.api.dto.output.ConsultaFreteOutput;
import com.sigabem.api.mapper.ConsultaFreteMapper;
import com.sigabem.domain.service.ConsultarFreteService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/consultafrete")
public class ConsultaFreteController {


    private final ConsultarFreteService service;
    private final ConsultaFreteMapper mapper;

    @PostMapping
    public ResponseEntity<ConsultaFreteOutput> consultarFrete(@RequestBody @Valid 
    ConsultaFreteInput consultaFreteInput) {
        
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(mapper.toOutput(service.consultarFrete(mapper.toEntity(consultaFreteInput))));
    }
    
}
