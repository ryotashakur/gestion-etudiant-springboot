package com.telecom3.gestion_etudiants.Services;


import com.telecom3.gestion_etudiants.DTO.EtudiantDTO;
import com.telecom3.gestion_etudiants.Models.Classe;
import com.telecom3.gestion_etudiants.Models.Etudiant;
import com.telecom3.gestion_etudiants.Repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EtudiantService  {
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private ClasseService classeService;

    //METHODE CRUD
    public Etudiant create(EtudiantDTO etudiantDTO){
      Classe classe=  classeService.findById(etudiantDTO.getIdClass());
     Etudiant etudiant= EtudiantDTO.etudiantDTOToEtudiant(etudiantDTO);
     etudiant.setClasse(classe);
      return etudiantRepository.save(etudiant);

    }


}
