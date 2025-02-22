package com.telecom3.gestion_etudiants.DTO;

import jakarta.persistence.Id;

import java.time.LocalDate;

public class EtudiantDTO {
    @Id
    private Long id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private Long idClass;

}
