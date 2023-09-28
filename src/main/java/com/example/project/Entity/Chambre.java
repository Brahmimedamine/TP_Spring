package com.example.project.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "Chambre")
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idChambre")
    private Long idChambre;
    private Long numeroChambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre TypeC;
    @ManyToOne(cascade = CascadeType.ALL)
    private Bloc bloc;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Reservation>reservations;

}
