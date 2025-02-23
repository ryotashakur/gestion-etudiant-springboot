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
    @Autowired
    private FiliereService filiereService;

    //METHODE CRUD //

    //create
    public Classe create(ClasseDTO classeDTO) {
        Filiere filiere = filiereService.findById(classeDTO.getIdFiliere());

        Classe classe= ClasseDTO.classeDTOtoClasse(classeDTO);
       boolean ifClassNameExist= classeRepository.existsByNomAndFiliere(classeDTO.getNom(), filiere);
        if(ifClassNameExist){
            throw new RuntimeException("une classe du même nom existe déja dans le filiere :" + filiere.getNom());
        }
        filiere.getClasses().add(classe);
        classe.setFiliere(filiere);
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
    public Classe findbyNiveau(int niveau) {
        Classe classe = classeRepository.findClasseByNiveau(niveau);
        if (classe == null) {
            throw new RuntimeException("Classe introuvable");
        }
        return classe;


    }

    //update classe
    public Classe update(ClasseDTO classeDTO) {

        if (this.findById(classeDTO.getId()) == null) {
            throw new RuntimeException("id doit pas etre nul");
        }
        Filiere filiere = filiereService.findById(classeDTO.getIdFiliere());
        Classe classe = this.findById(classeDTO.getId());

        if (classe != null) {
            if(!classe.getNom().equals(classeDTO.getNom())){
                boolean ifClassNameExist= classeRepository.existsByNomAndFiliere(classeDTO.getNom(), filiere);

                if(ifClassNameExist){
                    throw new RuntimeException("une classe du même nom existe déja dans le filiere :" + filiere.getNom());
                }
            }

            classe.setNom(classeDTO.getNom());
            classe.setNiveau(classeDTO.getNiveau());
            classe.setFiliere(filiere);
            return this.classeRepository.save(classe);
        }
        throw new RuntimeException("classe introuvable");
    }
    //delete classe

    public void delete(Long id) {
        Classe classe= this.findById(id);

        if(classe== null) {
            throw new RuntimeException("Classe introuvable");

        }
        this.classeRepository.delete(classe);

    }




}
