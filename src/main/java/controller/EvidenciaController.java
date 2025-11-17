package com.victor.proyectlabintellij.controller;

import com.victor.proyectlabintellij.model.Evidencia;
import com.victor.proyectlabintellij.repository.EvidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // GET -> Obtener una evidencia por ID
    @GetMapping("/{id}")
    public ResponseEntity<Evidencia> getEvidenciaById(@PathVariable Long id) {
        return evidenciaRepository.findById(id)
                .map(ResponseEntity::ok) // Si se encuentra, devuelve 200 OK con la evidencia
                .orElse(ResponseEntity.notFound().build()); // Si no se encuentra, devuelve 404 Not Found
    }

    // POST -> Crear una nueva evidencia (MEJORADO: Devuelve 201 Created)
    @PostMapping
    public ResponseEntity<Evidencia> createEvidencia(@RequestBody Evidencia evidencia) {
        Evidencia nuevaEvidencia = evidenciaRepository.save(evidencia);
        // Retorna 201 CREATED
        return new ResponseEntity<>(nuevaEvidencia, HttpStatus.CREATED); 
    }

    // PUT -> Actualizar una evidencia existente
    @PutMapping("/{id}")
    public ResponseEntity<Evidencia> updateEvidencia(@PathVariable Long id, @RequestBody Evidencia evidenciaDetails) {
        return evidenciaRepository.findById(id)
                .map(evidencia -> {
                    // Actualiza los campos (ejemplo: asume que 'evidencia' tiene setters)
                    // evidencia.setCampo1(evidenciaDetails.getCampo1()); 
                    // evidencia.setCampo2(evidenciaDetails.getCampo2());
                    
                    // Como no sé los campos de Evidencia, solo guardo los detalles sobre el ID encontrado.
                    // En un caso real, deberías mapear los campos específicos.
                    evidenciaDetails.setId(id); // Asegura que el ID sea el de la ruta
                    Evidencia updatedEvidencia = evidenciaRepository.save(evidenciaDetails);
                    return ResponseEntity.ok(updatedEvidencia); // Devuelve 200 OK con el objeto actualizado
                })
                .orElse(ResponseEntity.notFound().build()); // Si no se encuentra, devuelve 404 Not Found
    }

    // DELETE -> Eliminar una evidencia por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvidencia(@PathVariable Long id) {
        return evidenciaRepository.findById(id)
                .map(evidencia -> {
                    evidenciaRepository.delete(evidencia);
                    return ResponseEntity.noContent().build(); // Devuelve 204 No Content
                })
                .orElse(ResponseEntity.notFound().build()); // Si no se encuentra, devuelve 404 Not Found
    }
}
