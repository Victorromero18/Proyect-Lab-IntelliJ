package com.victor.proyectlabintellij.repository;

import com.victor.proyectlabintellij.model.Evidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvidenciaRepository extends JpaRepository<Evidencia, Integer> {

}