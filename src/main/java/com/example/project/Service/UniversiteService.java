package com.example.project.Service;

import com.example.project.Entity.Foyer;
import com.example.project.Entity.Universite;
import com.example.project.Repository.FoyerRepository;
import com.example.project.Repository.UniversiteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UniversiteService implements IUniversiteService{
    UniversiteRepository universiteRepository;
    FoyerRepository foyerRepository;

    @Override
    public List<Universite> retrieveAlluniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(Long idUniversite) {
        return universiteRepository.findById(idUniversite).get();
    }

    @Override
    public void removeUniversite(Long idUniversite) {
        universiteRepository.deleteById(idUniversite);

    }

    @Override
    public Universite affecterFoyerAUniversite(Long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer).get();
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        foyer.setUniversite(universite); //foyer est le pere.
        foyerRepository.save(foyer);
        return universite;
    }

    @Override
    public Universite desaffecterFoyerAUniversite(Long idFoyer) {
        Foyer foyer =foyerRepository.findById(idFoyer).get();

        foyer.setUniversite(null);
        foyerRepository.save(foyer);
        return null;
    }


}

