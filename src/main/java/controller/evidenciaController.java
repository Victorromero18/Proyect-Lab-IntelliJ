package com.daniel.proyectlabintellij.controller;

import com.daniel.proyectolabinyellij.model.Evidencia;
import com.daniel.proyectolabinyellij.repository.EvidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/evidencias") // Ruta base del controlador
public class EvidenciaController {

    @Autowired
    private EvidenciaRepository evidenciaRepository; // Acceso a la BD

    // ===========================================================
    // GET -> Obtener TODAS las evidencias
    // ===========================================================
    // Endpoint: GET http://localhost:8080/api/evidencias
    @GetMapping
    public List<Evidencia> getAllEvidencias() {
        return evidenciaRepository.findAll(); // Devuelve lista completa
    }


    // ===========================================================
    // GET -> Obtener evidencia POR ID
    // ===========================================================
    // Endpoint: GET http://localhost:8080/api/evidencias/{id}
    //
    // {id} es una variable que Spring recibe como @PathVariable
    @GetMapping("/{id}")
    public Optional<Evidencia> getEvidenciaById(@PathVariable int id) {

        // findById() devuelve Optional<Evidencia>
        return evidenciaRepository.findById(id);
    }


    // ===========================================================
    // POST -> Crear una nueva evidencia
    // ===========================================================
    // Endpoint: POST http://localhost:8080/api/evidencias
    //
    // El cuerpo del POST debe ser un JSON y se mapea a Evidencia con @RequestBody
    @PostMapping
    public Evidencia createEvidencia(@RequestBody Evidencia evidencia) {

        // Guarda la evidencia en la base de datos
        return evidenciaRepository.save(evidencia);
    }


    // ===========================================================
    // PUT -> Actualizar evidencia COMPLETA
    // ===========================================================
    // Endpoint: PUT http://localhost:8080/api/evidencias/{id}
    //
    // Se envía un JSON y se reemplaza la información anterior
    @PutMapping("/{id}")
    public Evidencia updateEvidencia(
            @PathVariable int id,          // ID a actualizar
            @RequestBody Evidencia evidenciaNueva   // Datos nuevos del cuerpo del request
    ) {
        // Verificamos si el ID existe
        Evidencia evidenciaActual = evidenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evidencia no encontrada: " + id));

        // Actualizamos valores
        evidenciaActual.setIdReporte(evidenciaNueva.getIdReporte());
        evidenciaActual.setUrlArchivo(evidenciaNueva.getUrlArchivo());
        evidenciaActual.setDescripcion(evidenciaNueva.getDescripcion());
        evidenciaActual.setFechaCarga(evidenciaNueva.getFechaCarga());

        // Guardamos los cambios
        return evidenciaRepository.save(evidenciaActual);
    }


    // ===========================================================
    // DELETE -> Eliminar evidencia POR ID
    // ===========================================================
    // Endpoint: DELETE http://localhost:8080/api/evidencias/{id}
    @DeleteMapping("/{id}")
    public String deleteEvidencia(@PathVariable int id) {

        // Verificar si existe antes de borrar
        if (!evidenciaRepository.existsById(id)) {
            return "La evidencia con ID " + id + " no existe";
        }

        // Ejecutar eliminación
        evidenciaRepository.deleteById(id);

        return "Evidencia eliminada correctamente. ID: " + id;
    }
}
