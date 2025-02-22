package com.telecom3.gestion_etudiants.DTO;

import com.telecom3.gestion_etudiants.Models.Classe;
import com.telecom3.gestion_etudiants.Models.Filiere;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClasseDTO {

    private Long id;

    @NotBlank(message = "le nom est obligatoire")
    private String nom;

    @NotNull(message = "le niveau ne doit pas etre nul")
    private int niveau;

    @NotBlank(message = "l'id filiere est obligatoire")
    private Filiere filiere;

    //Nous crééons nos deux méthodes classeDTOrequest/response

    //mapper DTORequest

    public static Classe classeDTOtoClasse(ClasseDTO classeDTO) {
        Classe classe = new Classe();
        classe.setId(classeDTO.getId());
        classe.setNom(classeDTO.getNom());
        classe.setNiveau(classeDTO.getNiveau());
        classe.setFiliere(classeDTO.getFiliere());
        return classe;
    }
    //mapper DTOResponse
    public static ClasseDTO classetoClasseDTO(Classe classe) {
        ClasseDTO classeDTO = new ClasseDTO();
        classeDTO.setId(classe.getId());
        classeDTO.setNom(classe.getNom());
        classeDTO.setNiveau(classe.getNiveau());
        classeDTO.setFiliere(classe.getFiliere());
        return classeDTO;
    }

    //mapper for listclasse to listclassDTO

    public static List<ClasseDTO> listClassetolistClasseDTO(List<Classe> listClasse) {

        List<ClasseDTO> listClasseDTO = new ArrayList<ClasseDTO>();
        for (Classe classe : listClasse) {
            listClasseDTO.add(classetoClasseDTO(classe));
        }

        return listClasseDTO;
    }
}


