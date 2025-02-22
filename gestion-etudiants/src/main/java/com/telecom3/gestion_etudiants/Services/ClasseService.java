package com.telecom3.gestion_etudiants.Services;

import com.telecom3.gestion_etudiants.DTO.ClasseDTO;
import com.telecom3.gestion_etudiants.DTO.FiliereDTO;
import com.telecom3.gestion_etudiants.Models.Classe;
import com.telecom3.gestion_etudiants.Models.Filiere;
import com.telecom3.gestion_etudiants.Repositories.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseService {
    @Autowired
    private ClasseRepository classeRepository;

    //METHODE CRUD //

    //create
    public Classe create(ClasseDTO classeDTO) {
        Classe classe= ClasseDTO.classeDTOtoClasse(classeDTO);
        return  this.classeRepository.save(classe);

    }
    //read

    //recuperer tous les classes
    public List<Classe> getAll() {

        return this.classeRepository.findAll();

    }
    //recuperer par ID
    public Classe findById(Long id) {
        return this.classeRepository.findById(id).orElse(null);
    }

    //recuperer classe par filiere

    public Classe findbyFiliere(Filiere filiere) {
        return this.classeRepository.findById(filiere.getId()).orElse(null);
    }

    //recuperer classe par niveau
    

    //update classe
    public Classe update(ClasseDTO classeDTO) {
        if (this.findById(classeDTO.getId()) == null) {
            throw new RuntimeException("id doit pas etre nul");
        }
        Classe classe = this.findById(classeDTO.getId());
        if (classe != null) {
            classe.setNom(classeDTO.getNom());
            classe.setNiveau(classeDTO.getNiveau());
            classe.setFiliere(classeDTO.getFiliere());
            return this.classeRepository.save(classe);
        }
        throw new RuntimeException("classe introuvable");
    }

}
