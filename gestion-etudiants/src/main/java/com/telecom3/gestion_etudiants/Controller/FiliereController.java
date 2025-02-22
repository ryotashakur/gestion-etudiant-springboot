package com.telecom3.gestion_etudiants.Controller;


import com.telecom3.gestion_etudiants.DTO.FiliereDTO;
import com.telecom3.gestion_etudiants.Models.Filiere;
import com.telecom3.gestion_etudiants.Services.FiliereService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filiere")
public class FiliereController {

    @Autowired
    private FiliereService filiereService;

    @GetMapping
    public ResponseEntity<List<FiliereDTO>> getFiliere(){
       List<Filiere> listFiliere= filiereService.getAll();
       List<FiliereDTO> listFiliereDTO= FiliereDTO.listFilieretolistFiliereDTO(listFiliere);
       return ResponseEntity.ok(listFiliereDTO);

    }

    @PostMapping
    public ResponseEntity<FiliereDTO> create(@Valid @RequestBody FiliereDTO filiereDTO){
        Filiere filiere =filiereService.create(filiereDTO);
        FiliereDTO filiereDTO1= FiliereDTO.filieretoFiliereDTO(filiere);
        return new ResponseEntity<>(filiereDTO1, HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<FiliereDTO>  update( @Valid @RequestBody FiliereDTO filiereDTO){

        Filiere filiere =filiereService.update(filiereDTO);
        FiliereDTO filiereDTO1= FiliereDTO.filieretoFiliereDTO(filiere);
        return ResponseEntity.ok(filiereDTO1);
    }

    @GetMapping("{id}")
    public ResponseEntity<FiliereDTO> getFiliereById(@Valid @PathVariable Long id){

       Filiere filiere = filiereService.findById(id);
       FiliereDTO filiereDTO= FiliereDTO.filieretoFiliereDTO(filiere);
        return ResponseEntity.ok(filiereDTO);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id){
        this.filiereService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
