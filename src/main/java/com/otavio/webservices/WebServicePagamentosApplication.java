package com.otavio.webservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Ponto de entrada da aplicacao Spring Boot
@SpringBootApplication
public class WebServicePagamentosApplication {

    public static void main(String[] args) {
        // Sobe o contexto web e expõe os endpoints REST
        SpringApplication.run(WebServicePagamentosApplication.class, args);
    }
}
