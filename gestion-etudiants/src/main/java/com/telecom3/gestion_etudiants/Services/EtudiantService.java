package com.telecom3.gestion_etudiants.Services;


import com.telecom3.gestion_etudiants.DTO.EtudiantDTO;
import com.telecom3.gestion_etudiants.Models.Classe;
import com.telecom3.gestion_etudiants.Models.Etudiant;
import com.telecom3.gestion_etudiants.Models.Note;
import com.telecom3.gestion_etudiants.Repositories.EtudiantRepository;
import com.telecom3.gestion_etudiants.Repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private ClasseService classeService;
    @Autowired
    private NoteRepository noteRepository;

    //METHODE CRUD
    //create
    public Etudiant create(EtudiantDTO etudiantDTO) {
        Classe classe = classeService.findById(etudiantDTO.getIdClass());
        Etudiant etudiant = EtudiantDTO.etudiantDTOToEtudiant(etudiantDTO);
        etudiant.setClasse(classe);
        etudiant.se
        return etudiantRepository.save(etudiant);

    }

    //read all
    public List<Etudiant> getAll() {
        return etudiantRepository.findAll();
    }

    //read byid
    public Etudiant getById(long id) {

        Optional<Etudiant> etudiant = etudiantRepository.findById(id);
        if (etudiant.isPresent()) {
            return etudiant.get();
        }
        throw new RuntimeException("l'etudiant n'existe pas");

    }

    //update
    public Etudiant update(EtudiantDTO etudiantDTO, Long id) {
        Etudiant etudiant = getById(id);
        Classe classe = classeService.findById(etudiantDTO.getIdClass());
        etudiant.setClasse(classe);
        String nom = etudiantDTO.getNom();
        String prenom = etudiantDTO.getPrenom();
        LocalDate dateNaiss = etudiantDTO.getDateNaissance();
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setDateNaissance(dateNaiss);

        return etudiantRepository.save(etudiant);

    }

    //delete

    public void deletebyId(long id) {
        Etudiant etudiant = getById(id);
        etudiantRepository.delete(etudiant);
    }
    /// /////////////calcul moyenne et verification de passage de l'étudiant

//  Calcul de la moyenne générale d'un étudiant
    public Double calculerMoyenne(Long etudiantId) {
        List<Note> notes = noteRepository.findByEtudiantId(etudiantId);

        if (notes.isEmpty()) {
            throw new RuntimeException("Aucune note trouvée pour cet étudiant.");
        }

        double somme = notes.stream().mapToDouble(Note::getNoteObtenue).sum();
        return somme / notes.size();
    }

    //étudiant est admis ou ajourné///////
    public String verifier(Long etudiantId) {
        double moyenne = calculerMoyenne(etudiantId);
        return moyenne >= 10 ? "ADMIS" : "AJOURNÉ";
    }




}
