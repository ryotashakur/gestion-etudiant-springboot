package com.telecom3.gestion_etudiants.Services;

import com.telecom3.gestion_etudiants.DTO.MatiereDTO;
import com.telecom3.gestion_etudiants.Models.Classe;
import com.telecom3.gestion_etudiants.Models.Matiere;
import com.telecom3.gestion_etudiants.Repositories.ClasseRepository;
import com.telecom3.gestion_etudiants.Repositories.MatiereRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereService {
    @Autowired
    private MatiereRepository matiereRepository;
    @Autowired
    private ClasseRepository classeRepository;


    //  METHODE CRUD
    // create
    public Matiere create(MatiereDTO matiereDTO) {

        Classe classe = classeRepository.findById(matiereDTO.getClasseId())
                .orElseThrow(() -> new RuntimeException("Classe introuvable avec l'ID : " + matiereDTO.getClasseId()));

        boolean ifMatiereExists = matiereRepository.existsByNomMatiereAndClasseId(matiereDTO.getNomMatiere(), matiereDTO.getClasseId());
        if (ifMatiereExists) {
            throw new RuntimeException("Une matière du même nom existe déjà dans la classe : " + classe.getNom());
        }

        Matiere matiere = MatiereDTO.matiereDTOtoMatiere(matiereDTO);
        matiere.setClasse(classe);
        classe.getMatieres().add(matiere);

        return matiereRepository.save(matiere);
    }

    public Matiere getMatiereById(Long id) {
        return matiereRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matiere introuvable"));
    }

    // Read
    public List <Matiere> getAll() {
        return matiereRepository.findAll();
    }
    //recuperer tous les matieres dans une classe


     public List<Matiere> getMatieresByClasse(Long classeId) {

        return matiereRepository.findByClasseId(classeId);


     }

    // update
    public MatiereDTO update(Long id, MatiereDTO matiereDTO) {
        Matiere matiere = getMatiereById(id);

        Classe classe = classeRepository.findById(matiereDTO.getClasseId())
                .orElseThrow(() -> new EntityNotFoundException("Classe introuvable avec l'ID : " + matiereDTO.getClasseId()));

        if (!matiere.getNomMatiere().equals(matiereDTO.getNomMatiere()) &&
                matiereRepository.existsByNomMatiereAndClasseId(matiereDTO.getNomMatiere(), matiereDTO.getClasseId())) {
            throw new RuntimeException("Une matière du même nom existe déjà dans cette classe.");
        }
        matiere.setNomMatiere(matiereDTO.getNomMatiere());
        matiere.setClasse(classe);

        Matiere savedMatiere = matiereRepository.save(matiere);
        return MatiereDTO.matiereToMatiereDTO(savedMatiere);

    }

    //  Supprimer une matière
    public void deleteMatiere(Long id) {
        if (!matiereRepository.existsById(id)) {
            throw new RuntimeException("Matiere introuvable");
        }
        matiereRepository.deleteById(id);
    }

}
