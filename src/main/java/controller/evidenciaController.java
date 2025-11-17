package com.daniel.proyectlabintellij.controller;

import com.daniel.proyectlabintellij.model.Evidencia;
import com.daniel.proyectlabintellij.repository.EvidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evidencias") // Ruta base del controlador
public class EvidenciaController {

    @Autowired
    private EvidenciaRepository evidenciaRepository;

    // ===========================================================
    // PUT -> Actualizar evidencia COMPLETA
    // ===========================================================
    
    //
    // Se recibe un JSON y se reemplazan los datos del registro existente.
    @PutMapping("/{id}")
    public Evidencia updateEvidencia(
            @PathVariable int id,                // ID de la evidencia a actualizar
            @RequestBody Evidencia datosNuevos   // Datos enviados desde el cliente
    ) {
        // Buscar evidencia por ID
        Evidencia evidenciaActual = evidenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evidencia no encontrada con ID: " + id));

        // Actualizar campos
        evidenciaActual.setIdReporte(datosNuevos.getIdReporte());
        evidenciaActual.setUrlArchivo(datosNuevos.getUrlArchivo());
        evidenciaActual.setDescripcion(datosNuevos.getDescripcion());
        evidenciaActual.setFechaCarga(datosNuevos.getFechaCarga());

        // Guardar los cambios en la BD
        return evidenciaRepository.save(evidenciaActual);
    }
}
