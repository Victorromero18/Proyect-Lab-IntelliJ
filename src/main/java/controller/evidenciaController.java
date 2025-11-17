package com.tuempresa.tuapp.controller;

import com.tuempresa.tuapp.model.Evidencia;
import com.tuempresa.tuapp.repository.EvidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evidencias")
public class EvidenciaController {

    @Autowired
    private EvidenciaRepository evidenciaRepository;

    // GET -> Obtener todas las evidencias
    @GetMapping
    public List<Evidencia> getAllEvidencias() {
        return evidenciaRepository.findAll();
    }

    // POST -> Crear una nueva evidencia
    @PostMapping
    public Evidencia createEvidencia(@RequestBody Evidencia evidencia) {
        return evidenciaRepository.save(evidencia);
    }
}