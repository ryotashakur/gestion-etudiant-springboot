package com.telecom3.gestion_etudiants.DTO;


import com.telecom3.gestion_etudiants.Models.Classe;
import com.telecom3.gestion_etudiants.Models.Matiere;
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
public class MatiereDTO {

    private Long id;

    @NotBlank(message = "la matière est obligatoire")
    private String nomMatiere;

    @NotNull(message= "L'ID de la classe est obligatoire")
    private Long classeId;

    //creation des mappers static

    //  Mapper DTORequest
    public static Matiere matiereDTOtoMatiere(MatiereDTO matiereDTO) {
        Matiere matiere = new Matiere();
        matiere.setId(matiereDTO.getId());
        matiere.setNomMatiere(matiereDTO.getNomMatiere());
        return matiere;
    }

    //  Mapper DTOResponse
    public static MatiereDTO matiereToMatiereDTO(Matiere matiere) {
        MatiereDTO matiereDTO = new MatiereDTO();
        matiereDTO.setId(matiere.getId());
        matiereDTO.setNomMatiere(matiere.getNomMatiere());
        matiereDTO.setClasseId(matiere.getClasse().getId());
        return matiereDTO;
    }

    //  Mapper List<Matiere> to ListMatiereDTO

    public static List<MatiereDTO> listMatiereToListMatiereDTO(List<Matiere> listMatiere) {
        List<MatiereDTO> listMatiereDTO = new ArrayList<>();
        for (Matiere matiere : listMatiere) {
            listMatiereDTO.add(matiereToMatiereDTO(matiere));
        }
        return listMatiereDTO;
    }
}
