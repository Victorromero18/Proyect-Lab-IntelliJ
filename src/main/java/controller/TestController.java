package com.victor.proyectlabintellij.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hola")
    public String hola() {
        return "Hola mundo";
    }

    @GetMapping("/adios")
    public String adios() {
        return "Adiós mundo";
    }

    @GetMapping("/integrante/victor")
    public String integranteVictor() {
        return "Victor Romero";
    }

    @GetMapping("/integrante/daniel")
    public String integranteDaniel() {
        return "Daniel Monroy Marcelo";
    }

    @GetMapping("/integrante/alan")
    public String integranteAlan() {
        return "Cristian Alan Tapia.";
    }
}