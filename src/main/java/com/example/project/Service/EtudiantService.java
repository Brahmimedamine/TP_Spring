package com.example.project.Service;

import com.example.project.Entity.Etudiant;
import com.example.project.Repository.EtudiantRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class EtudiantService implements IEtudiantService{

    EtudiantRepository repository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {

        return repository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return repository.save(e);

    }

    @Override
    public Etudiant updateEtudiant(Etudiant e)
    {
       return repository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant)
    {
        return repository.findById(idEtudiant).get();
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
       repository.deleteById(idEtudiant);

    }
}
