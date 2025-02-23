package com.telecom3.gestion_etudiants.DTO;

import com.telecom3.gestion_etudiants.Models.Matiere;
import com.telecom3.gestion_etudiants.Models.Note;
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
public class NoteDTO {

    private Long id;

    @NotNull(message = "l'id etudiant est obligatoire")
    private Long etudiantId;

    @NotNull(message= "L'ID de la classe est obligatoire")
    private Long matiereId;

    @NotNull(message= "La note obtenue est obligatoire")
    private Double noteObtenue;

    //creation des mappers static

    //  Mapper DTORequest

    //  Mapper DTOResponse
    public static NoteDTO noteToNoteDTO(Note note){
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setId(note.getId());
        noteDTO.setEtudiantId(note.getEtudiant().getId());
        noteDTO.setMatiereId(note.getMatiere().getId());
        noteDTO.setNoteObtenue(note.getNoteObtenue());
        return noteDTO;
    }


    //  Mapper List<Note> to ListNoteDTO

    public static List<NoteDTO> listNoteToListNoteDTO(List<Note> listNote) {
        List<NoteDTO> listNoteDTO = new ArrayList<>();
        for (Note note : listNote) {
            listNoteDTO.add(noteToNoteDTO(note));
        }
        return listNoteDTO;
    }
}
