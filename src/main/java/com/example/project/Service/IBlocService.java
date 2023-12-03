package com.example.project.Service;

import com.example.project.Entity.Bloc;
import com.example.project.Entity.Etudiant;

import java.util.List;

public interface IBlocService {

    List<Bloc> retrieveAllblocs();

    Bloc addBloc(Bloc b);

    Bloc updateBloc(Bloc b);

    Bloc retrieveBloc(Long idBloLc);

    void removeBloc(Long idBloc);
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) ;

}
