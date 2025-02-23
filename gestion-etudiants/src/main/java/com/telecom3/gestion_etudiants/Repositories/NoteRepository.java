package com.telecom3.gestion_etudiants.Repositories;

import com.telecom3.gestion_etudiants.Models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note,Long> {
    List<Note> findByMatiereClasseIdAndNoteObtenueLessThan(Long classeId, Double seuil);
    List<Note> findByEtudiantId(Long etudiantId);

}
