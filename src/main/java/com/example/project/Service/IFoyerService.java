package com.example.project.Service;

import com.example.project.Entity.Etudiant;
import com.example.project.Entity.Foyer;

import java.util.List;

public interface IFoyerService {
    List<Foyer> retrieveAllFoyer();

    Foyer addFoyer(Foyer f);

    Foyer updateFoyer(Foyer f);

    Foyer retrieveFoyer(Long idFoyer);

    void removeFoyer(Long idFoyer);
    Foyer addFoyerWithBloc (Foyer foyer);


}
