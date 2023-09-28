package com.example.project.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "Foyer")
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFoyer")
    private Long idFoyer;
    private String nomFoyer;
    private String capaciteFoyer;
@OneToOne
    private Universite universite;
@OneToMany(cascade = CascadeType.ALL,mappedBy = "foyer")
    private Set<Bloc>blocs;


}
