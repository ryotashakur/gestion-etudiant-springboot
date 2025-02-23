package com.telecom3.gestion_etudiants.Repositories;

import com.telecom3.gestion_etudiants.Models.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {

}
