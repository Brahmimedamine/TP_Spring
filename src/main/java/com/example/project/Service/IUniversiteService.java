package com.example.project.Service;

import com.example.project.Entity.Chambre;
import com.example.project.Entity.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAlluniversites();

    Universite addUniversite(Universite u);

    Universite updateUniversite(Universite u);

    Universite retrieveUniversite(Long idUniversite);

    void removeUniversite(Long idUniversite);



}
