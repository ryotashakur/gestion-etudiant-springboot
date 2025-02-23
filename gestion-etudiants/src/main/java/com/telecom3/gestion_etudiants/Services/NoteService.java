package com.telecom3.gestion_etudiants.Services;

import com.telecom3.gestion_etudiants.DTO.NoteDTO;
import com.telecom3.gestion_etudiants.Models.Etudiant;
import com.telecom3.gestion_etudiants.Models.Matiere;
import com.telecom3.gestion_etudiants.Models.Note;
import com.telecom3.gestion_etudiants.Repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private MatiereService matiereService;
    @Autowired
    private EtudiantService etudiantService;

    //METHODE CRUD

    //create

    public Note create(NoteDTO noteDTO) {
        Matiere matiere = matiereService.getMatiereById(noteDTO.getMatiereId());
        Note note = new Note();
        note.setEtudiant(etudiantService.getById(noteDTO.getEtudiantId()));
        note.setMatiere(matiere);
        if (noteDTO.getNoteObtenue() < 0) {
            throw new RuntimeException("la note doit etre positive");
        }
        note.setNoteObtenue(noteDTO.getNoteObtenue());
        return noteRepository.save(note);
    }

    //read

    public List<Note> getALl() {
        return noteRepository.findAll();
    }

    //readbyId

    public Note getById(Long id) {
        Optional<Note> note = noteRepository.findById(id);
        if (note.isPresent()) {
            return note.get();
        }
        throw new RuntimeException("la note n'existe pas");

    }

    //update

    public Note update (NoteDTO noteDTO,Long id){
        Note note =getById(id);
        Etudiant etudiant=etudiantService.getById(id);
        Matiere matiere=matiereService.getMatiereById(id);
        note.setMatiere(matiere);
        note.setEtudiant(etudiant);
        return noteRepository.save(note);
    }

    public void deletebyId(long id) {
        Note note= getById(id);
        noteRepository.delete(note);
    }

    //recuperer etudiant rattrapage
    public List<NoteDTO> getEtudiantsEnRattrapage(Long classeId) {
        List<Note> notesRattrapage = noteRepository.findByMatiereClasseIdAndValeurLessThan(classeId, 10.0);
        return NoteDTO.listNoteToListNoteDTO(notesRattrapage);
    }
}