package com.telecom3.gestion_etudiants.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Etudiant etudiant;

    @ManyToOne
    private Matiere matiere;

    @Column(nullable = false)
    private Double noteObtenue;


    //
}
