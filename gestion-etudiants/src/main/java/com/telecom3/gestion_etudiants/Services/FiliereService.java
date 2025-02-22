package com.telecom3.gestion_etudiants.Services;

import com.telecom3.gestion_etudiants.DTO.FiliereDTO;
import com.telecom3.gestion_etudiants.Models.Filiere;
import com.telecom3.gestion_etudiants.Repositories.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FiliereService  {
    @Autowired
    private  FiliereRepository filiereRepository;
    // j'implemente les méthodes crud

    //createFiliere

    public Filiere create(FiliereDTO filiereDTO) {
        if(filiereRepository.findByNom(filiereDTO.getNom())==null){
            throw new RuntimeException("Le nom de filier n'existe pas");
        }
        Filiere filiere= FiliereDTO.filiereDTOtoFiliere(filiereDTO);
        return this.filiereRepository.save(filiere);

    }

    //recuperer tous les filieres
    public List <Filiere> getAll() {

        return this.filiereRepository.findAll();

    }
    //recuperer filiere par id
    public Filiere findById(Long id) {
        return this.filiereRepository.findById(id).orElse(null);
    }

    //modifier filiere
    public Filiere update(FiliereDTO filiereDTO) {
        if(filiereDTO.getNom()==null){
            throw new RuntimeException("Le nom de filier n'existe pas");
        }

        if(filiereDTO.getId()==null){
            throw new RuntimeException("id doit pas etre nul");
        }
      Filiere filiere= this.findById(filiereDTO.getId());
        if(filiere!= null) {
            filiere.setNom(filiereDTO.getNom());
            return this.filiereRepository.save(filiere);
        }
        throw new RuntimeException("Filiere introuvable");

    }
    //delete filiere

    public void delete(Long id) {
        Filiere filiere= this.findById(id);

        if(filiere== null) {
            throw new RuntimeException("Filiere introuvable");

        }
        this.filiereRepository.delete(filiere);


    }



}
