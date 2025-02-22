package com.telecom3.gestion_etudiants.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Filiere {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(nullable = false, unique = true)
    private String nom;
    @OneToMany(mappedBy = "filiere", cascade = CascadeType.ALL)
    private List<Classe> classes= new ArrayList<>();

}
