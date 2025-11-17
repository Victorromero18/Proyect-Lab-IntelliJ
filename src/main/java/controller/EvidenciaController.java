package com.victor.proyectlabintellij.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Indica que esta clase es una entidad JPA y se mapeará a una tabla en la base de datos.
@Entity
public class Evidencia {

    // Define el campo 'id' como la clave primaria de la tabla.
    @Id
    // Configura la generación automática del valor del ID (autoincremento).
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // Campos de la entidad que se mapearán a columnas.
    private String nombre;
    private String descripcion;
    private String urlArchivo;

    // Constructor vacío (necesario para JPA para crear instancias de la entidad).
    public Evidencia() {
    }

    // Constructor completo para crear una instancia con todos los atributos.
    public Evidencia(String nombre, String descripcion, String urlArchivo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlArchivo = urlArchivo;
    }

    // --- Getters (Métodos de acceso para obtener los valores) ---
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrlArchivo() {
        return urlArchivo;
    }

    // --- Setters (Métodos de mutación para modificar los valores) ---
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUrlArchivo(String urlArchivo) {
        this.urlArchivo = urlArchivo;
    }
}
