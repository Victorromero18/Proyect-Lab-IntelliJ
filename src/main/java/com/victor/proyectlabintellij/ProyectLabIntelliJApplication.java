package com.victor.proyectlabintellij;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan; // <-- IMPORTA ESTO

@EntityScan(basePackages = "com.victor.proyectlabintellij.model")
@SpringBootApplication
public class ProyectLabIntelliJApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectLabIntelliJApplication.class, args);
    }
}