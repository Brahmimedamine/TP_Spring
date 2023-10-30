package com.example.project.Service;

import com.example.project.Entity.Bloc;
import com.example.project.Entity.Chambre;

import java.util.List;

public interface IChambreService {

    List<Chambre> retrieveAllchambres();

    Chambre addChambre(Chambre ch);

    Chambre updateChambre(Chambre ch);

    Chambre retrieveChambre(Long idChambre);

    void removeChambre(Long idChambre);


}
