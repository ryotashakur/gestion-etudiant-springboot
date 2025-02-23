package com.telecom3.gestion_etudiants.Controller;

import com.telecom3.gestion_etudiants.DTO.EtudiantDTO;
import com.telecom3.gestion_etudiants.Models.Etudiant;
import com.telecom3.gestion_etudiants.Services.EtudiantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @GetMapping
    public ResponseEntity<List<EtudiantDTO>> getAll (){
        List<EtudiantDTO> etudiantDTOS= EtudiantDTO.listEtudiantToListEtudiantDTO(etudiantService.getAll());
        return ResponseEntity.ok(etudiantDTOS);
    }

    @GetMapping("{id}")
    public ResponseEntity<EtudiantDTO> getById(@Valid @PathVariable Long id){
        EtudiantDTO etudiant= EtudiantDTO.etudiantToEtudiantDTO(etudiantService.getById(id));
        return ResponseEntity.ok(etudiant);

    }

    @PutMapping("{id}")
    public ResponseEntity<EtudiantDTO> update (@RequestBody EtudiantDTO etudiantDTO, @Valid @PathVariable Long id){
        EtudiantDTO etudiantDTO1= EtudiantDTO.etudiantToEtudiantDTO(etudiantService.update(etudiantDTO,id));
        return ResponseEntity.ok(etudiantDTO1);

    }

    @PostMapping
    public ResponseEntity<EtudiantDTO> create (@RequestBody EtudiantDTO etudiantDTO){
        EtudiantDTO etudiantDTO2= EtudiantDTO.etudiantToEtudiantDTO(etudiantService.create(etudiantDTO));
        return ResponseEntity.ok(etudiantDTO2);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id){
        etudiantService.deletebyId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
