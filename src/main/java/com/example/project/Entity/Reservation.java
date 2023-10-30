package com.example.project.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Reservation")
public class Reservation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idReservation")
  private Long idReservation; // Clé primaire
    private Date anneeUniversitaire;
    private boolean estValide;
    @ManyToMany(cascade = CascadeType.ALL)
  private List<Etudiant> etudiants;

}
