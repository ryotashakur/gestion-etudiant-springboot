package com.telecom3.gestion_etudiants.DTO;

import com.telecom3.gestion_etudiants.Models.Classe;
import com.telecom3.gestion_etudiants.Models.Filiere;
import jakarta.validation.constraints.NotBlank;
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

public class FiliereDTO {

    private Long id;
    @NotBlank(message = "le nom doit être obligatoire")
    private String nom;
    private List <ClasseDTO>  classes =new ArrayList<>();

    //methode mapper filieredto-->filiere(d
   public static Filiere filiereDTOtoFiliere(FiliereDTO filiereDTO) {
        Filiere filiere = new Filiere();
        filiere.setId(filiereDTO.getId());
        filiere.setNom(filiereDTO.getNom());
        return filiere;
    }

    //methode mapper filiere-->filieredto(dtoResponse)
    public static FiliereDTO filieretoFiliereDTO(Filiere filiere) {
        FiliereDTO filiereDTO = new FiliereDTO();

        filiereDTO.setId(filiere.getId());
        filiereDTO.setNom(filiere.getNom());
        List<Classe> classes= filiere.getClasses();
       List<ClasseDTO> classesDTO= ClasseDTO.listClassetolistClasseDTO(classes);
        filiereDTO.setClasses(classesDTO);
        return filiereDTO;
    }

    public static List<FiliereDTO> listFilieretolistFiliereDTO(List<Filiere> listFiliere) {

       List<FiliereDTO> listFiliereDTO = new ArrayList<FiliereDTO>();
       for (Filiere filiere : listFiliere) {
           listFiliereDTO.add(filieretoFiliereDTO(filiere));
       }
        return listFiliereDTO;
    }


}
