package com.sigabem.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Consultar frete by Pedro Miranda")
                .description("Implementar para empresa de transporte de cargas SigaBem o endpoint para o cálculo do preço do frete "))
                .externalDocs(new ExternalDocumentation()
                .description("GitHub campos2504")
                .url("https://github.com/campos2504/JavaTest"));
    }
    
}
