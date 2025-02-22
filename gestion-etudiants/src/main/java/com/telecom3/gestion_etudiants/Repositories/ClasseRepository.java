package com.telecom3.gestion_etudiants.Repositories;

import com.telecom3.gestion_etudiants.Models.Classe;
import com.telecom3.gestion_etudiants.Models.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasseRepository extends JpaRepository<Classe,Long> {
    Classe findClasseByNiveau(int niveau);

    boolean existsByNomAndFiliere(String nom, Filiere filiere);
}

