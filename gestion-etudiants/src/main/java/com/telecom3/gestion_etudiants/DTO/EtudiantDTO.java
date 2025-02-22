package com.telecom3.gestion_etudiants.DTO;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class EtudiantDTO {
    @Id
    @NotNull
    private Long id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private Long idClass;

}
