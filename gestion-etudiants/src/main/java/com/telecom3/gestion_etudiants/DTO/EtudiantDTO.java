package com.telecom3.gestion_etudiants.DTO;

import com.telecom3.gestion_etudiants.Models.Etudiant;
import com.telecom3.gestion_etudiants.Models.Matiere;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EtudiantDTO {

    @NotBlank(message = "Le nom est obligatoire")
    private String nom;
    @NotBlank(message = "Le nom est obligatoire")
    private String prenom;
    @NotNull(message = "la date est obligatoire")
    private LocalDate dateNaissance;
    @NotNull(message = "l'idclass est obligatoire")
    private Long idClass;

    // Mapper DTO
    public static Etudiant etudiantDTOToEtudiant(EtudiantDTO etudiantDTO) {

        Etudiant etudiant = new Etudiant();
        etudiant.setNom(etudiantDTO.getNom());
        etudiant.setPrenom(etudiantDTO.getPrenom());
        etudiant.setDateNaissance(etudiantDTO.getDateNaissance());
        return etudiant;
    }

    //Mapper Entité Etudiant -> DTO
    public static EtudiantDTO etudiantToEtudiantDTO(Etudiant etudiant) {
        EtudiantDTO etudiantDTO = new EtudiantDTO();
        etudiantDTO.setNom(etudiant.getNom());
        etudiantDTO.setPrenom(etudiant.getPrenom());
        etudiantDTO.setDateNaissance(etudiant.getDateNaissance());
        etudiantDTO.setIdClass(etudiant.getClasse().getId());
        return etudiantDTO;

    }

    //Mapper Liste<Etudiant> -> Liste<EtudiantDTO>
    public static List<EtudiantDTO> listEtudiantToListEtudiantDTO(List<Etudiant> etudiants) {
        List<EtudiantDTO> listEtudiant = new ArrayList<>();
        for (Etudiant etudiant : etudiants ) {
            listEtudiant.add(etudiantToEtudiantDTO(etudiant));
        }
        return listEtudiant;
    }

}
