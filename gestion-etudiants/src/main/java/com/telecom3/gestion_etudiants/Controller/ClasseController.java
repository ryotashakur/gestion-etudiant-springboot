package com.telecom3.gestion_etudiants.Controller;

import com.telecom3.gestion_etudiants.DTO.ClasseDTO;
import com.telecom3.gestion_etudiants.Models.Classe;
import com.telecom3.gestion_etudiants.Services.ClasseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classe")
public class ClasseController {
    @Autowired
    private ClasseService classeService;

    @GetMapping
    public ResponseEntity<List<ClasseDTO>> getAllClasse(){
        List<Classe> listClasse= classeService.getAll();
        List<ClasseDTO> listClasseDTO= ClasseDTO.listClassetolistClasseDTO(listClasse);
        return ResponseEntity.ok(listClasseDTO);

    }

    @PostMapping
    public ResponseEntity<ClasseDTO> create(@Valid @RequestBody ClasseDTO classeDTO){
        Classe classe=classeService.create(classeDTO);
        ClasseDTO classeDTO1= ClasseDTO.classetoClasseDTO(classe);
        return new ResponseEntity<>(classeDTO1, HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<ClasseDTO>  update( @Valid @RequestBody ClasseDTO classeDTO){

       Classe classe = classeService.update(classeDTO);
        ClasseDTO classeDTO1= ClasseDTO.classetoClasseDTO(classe);
        return ResponseEntity.ok(classeDTO1);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClasseDTO> getClasseById(@Valid @PathVariable Long id){

        Classe classe = classeService.findById(id);
        ClasseDTO classeDTO= ClasseDTO.classetoClasseDTO(classe);
        return ResponseEntity.ok(classeDTO);

    }
    @GetMapping("{niveau}")
    public ResponseEntity<ClasseDTO> getClasseByNiveau(@Valid @PathVariable int niveau){

        Classe classe = classeService.findbyNiveau(niveau);
        ClasseDTO classeDTO= ClasseDTO.classetoClasseDTO(classe);
        return ResponseEntity.ok(classeDTO);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id){
        this.classeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
