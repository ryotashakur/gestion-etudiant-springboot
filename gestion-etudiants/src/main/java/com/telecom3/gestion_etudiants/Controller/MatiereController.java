package com.telecom3.gestion_etudiants.Controller;

import com.telecom3.gestion_etudiants.DTO.MatiereDTO;
import com.telecom3.gestion_etudiants.Models.Matiere;
import com.telecom3.gestion_etudiants.Services.MatiereService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matieres")
@RequiredArgsConstructor
public class MatiereController {

    private final MatiereService matiereService;

    @PostMapping
    public ResponseEntity<MatiereDTO> ajouterMatiere(@RequestBody MatiereDTO matiereDTO) {
        MatiereDTO savedMatiere = MatiereDTO.matiereToMatiereDTO(matiereService.create(matiereDTO));
        return ResponseEntity.ok(savedMatiere);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matiere> getById(@PathVariable Long id) {
        Matiere matiere = matiereService.getMatiereById(id);
        return ResponseEntity.ok(matiere);
    }

    @GetMapping
    public ResponseEntity<List<MatiereDTO>> getAll() {
        List<MatiereDTO> matieresDTO = MatiereDTO.listMatiereToListMatiereDTO(matiereService.getAll());
        return ResponseEntity.ok(matieresDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<MatiereDTO> update(@PathVariable Long id, @RequestBody MatiereDTO matiereDTO) {
        MatiereDTO updatedMatiere = matiereService.update(id, matiereDTO);
        return ResponseEntity.ok(updatedMatiere);
    }


    @GetMapping("/classe/{classeId}")
    public ResponseEntity<List<MatiereDTO>> getMatieresByClasse(@PathVariable Long classeId) {
        List <Matiere> matieres= matiereService.getMatieresByClasse(classeId);
        List<MatiereDTO> matieresDTO= MatiereDTO.listMatiereToListMatiereDTO(matieres);
        return ResponseEntity.ok(matieresDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        matiereService.deleteMatiere(id);
        return new ResponseEntity<>(HttpStatus.OK);


    }
}
