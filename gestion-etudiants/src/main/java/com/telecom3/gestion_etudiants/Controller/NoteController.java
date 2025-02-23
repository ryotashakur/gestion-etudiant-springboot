package com.telecom3.gestion_etudiants.Controller;

import com.telecom3.gestion_etudiants.DTO.NoteDTO;
import com.telecom3.gestion_etudiants.Services.NoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping
    public ResponseEntity<List<NoteDTO>> listNote() {
        List<NoteDTO> noteDTOS= NoteDTO.listNoteToListNoteDTO(noteService.getALl());
        return ResponseEntity.ok(noteDTOS);
    }
    @GetMapping("{id}")
    public ResponseEntity<NoteDTO> getNote(@Valid @PathVariable Long id) {
        NoteDTO noteDTO= NoteDTO.noteToNoteDTO(noteService.getById(id));
        return ResponseEntity.ok(noteDTO);
    }
    @GetMapping("/rattrapage/{classeId}")
    public ResponseEntity<List<NoteDTO>> getEtudiantsEnRattrapage(@Valid @PathVariable Long classeId) {
        return ResponseEntity.ok(noteService.getEtudiantsEnRattrapage(classeId));
    }

    @PostMapping
    public ResponseEntity<NoteDTO> createNote(@Valid @RequestBody NoteDTO noteDTO) {
        NoteDTO noteDTO1=NoteDTO.noteToNoteDTO(noteService.create(noteDTO));
        return ResponseEntity.ok(noteDTO1);
    }
    @PutMapping("{id}")
    public ResponseEntity<NoteDTO> updateNote(@Valid @RequestBody NoteDTO noteDTO, @PathVariable Long id) {
        NoteDTO noteDTO2= NoteDTO.noteToNoteDTO(noteService.update(noteDTO,id));
        return ResponseEntity.ok(noteDTO2);
    }
    @DeleteMapping
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id){
        noteService.deletebyId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
