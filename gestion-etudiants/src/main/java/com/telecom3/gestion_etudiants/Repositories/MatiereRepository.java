package com.telecom3.gestion_etudiants.Repositories;

import com.telecom3.gestion_etudiants.Models.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatiereRepository extends JpaRepository<Matiere, Long> {

    List<Matiere> findByClasseId(Long classeId);
    boolean existsByNomMatiereAndClasseId(String nomMatiere, Long classeId);
}
