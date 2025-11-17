package com.victor.proyectlabintellij.controller;

import com.victor.proyectlabintellij.model.Evidencia;
import com.victor.proyectlabintellij.repository.EvidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evidencias")
public class EvidenciaController {

    @Autowired
    private EvidenciaRepository evidenciaRepository;

    // GET -> Obtener todas las evidencias (Método de Daniel)
    @GetMapping
    public List<Evidencia> getAllEvidencias() {
        return evidenciaRepository.findAll();
    }

    // POST -> Crear una nueva evidencia (Método de Daniel)
    @PostMapping
    public Evidencia createEvidencia(@RequestBody Evidencia evidencia) {
        return evidenciaRepository.save(evidencia);
    }
}