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

    // 1. GET: Obtener todas las evidencias
    // Endpoint: GET /api/evidencias
    // Retorna: 200 OK
    @GetMapping
    public List<Evidencia> getAllEvidencias() {
        return evidenciaRepository.findAll();
    }

    // 2. GET: Obtener una evidencia por ID
    // Endpoint: GET /api/evidencias/{id}
    // Retorna: 200 OK si existe, 404 NOT FOUND si no existe
    @GetMapping("/{id}")
    public ResponseEntity<Evidencia> getEvidenciaById(@PathVariable Long id) {
        return evidenciaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. POST: Crear una nueva evidencia
    // Endpoint: POST /api/evidencias
    // Retorna: 201 CREATED
    @PostMapping
    public ResponseEntity<Evidencia> createEvidencia(@RequestBody Evidencia evidencia) {
        Evidencia nuevaEvidencia = evidenciaRepository.save(evidencia);
        // Usa HttpStatus.CREATED (código 201) que es el estándar para la creación exitosa.
        return new ResponseEntity<>(nuevaEvidencia, HttpStatus.CREATED); 
    }

    // 4. PUT: Actualizar una evidencia existente
    // Endpoint: PUT /api/evidencias/{id}
    // Retorna: 200 OK si se actualiza, 404 NOT FOUND si no existe
    @PutMapping("/{id}")
    public ResponseEntity<Evidencia> updateEvidencia(@PathVariable Long id, @RequestBody Evidencia evidenciaDetails) {
        return evidenciaRepository.findById(id)
                .map(evidenciaExistente -> {
                    // **IMPORTANTE**: Necesitas actualizar los campos de la evidenciaExistente con los datos de evidenciaDetails.
                    // (Ejemplo: debes asegurarte que la clase Evidencia tenga setters)
                    // Para simplificar, asumiremos que Evidencia tiene un constructor o setters para todos sus campos.
                    
                    // Asumiendo que Evidencia tiene un campo 'descripcion', 'nombre', etc.
                    // evidenciaExistente.setNombre(evidenciaDetails.getNombre());
                    // evidenciaExistencia.setDescripcion(evidenciaDetails.getDescripcion());
                    // ... (Aquí mapearías todos los campos que pueden cambiar)

                    // Para que este ejemplo compile y sea funcional, hacemos un save simple,
                    // pero en la vida real, ¡debes asignar los campos!
                    evidenciaDetails.setId(id); // Aseguramos que el ID correcto se use para la actualización
                    Evidencia updatedEvidencia = evidenciaRepository.save(evidenciaDetails);
                    
                    return ResponseEntity.ok(updatedEvidencia); 
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. DELETE: Eliminar una evidencia por ID
    // Endpoint: DELETE /api/evidencias/{id}
    // Retorna: 204 NO CONTENT si se elimina, 404 NOT FOUND si no existe
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvidencia(@PathVariable Long id) {
        return evidenciaRepository.findById(id)
                .map(evidencia -> {
                    evidenciaRepository.delete(evidencia);
                    // Retorna 204 No Content, que es el estándar para una eliminación exitosa sin cuerpo de respuesta.
                    return ResponseEntity.noContent().build(); 
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
