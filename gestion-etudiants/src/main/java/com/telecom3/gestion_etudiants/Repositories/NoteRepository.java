package com.telecom3.gestion_etudiants.Repositories;

import com.telecom3.gestion_etudiants.Models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note,Long> {

}
