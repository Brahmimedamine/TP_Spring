package com.example.project.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "Bloc")
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBloc")
     Long idBloc;
     String nomBloc;
     Long capaciteBloc;
    @ManyToOne
    private Foyer foyer;
    @OneToMany(cascade = CascadeType.ALL,mappedBy ="bloc")
    private Set<Chambre>chambres;
}

