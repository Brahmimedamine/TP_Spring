package com.example.project.Service;

import com.example.project.Entity.Bloc;
import com.example.project.Entity.Chambre;
import com.example.project.Repository.BlocRepository;
import com.example.project.Repository.ChambreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class BlocService implements IBlocService{
    BlocRepository blocRepository;
    ChambreRepository chambreRepository;

    @Override
    public List<Bloc> retrieveAllblocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public Bloc updateBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public Bloc retrieveBloc(Long idBloLc) {
        return blocRepository.findById(idBloLc).get();
    }

    @Override
    public void removeBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);

    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) {
        Bloc bloc = blocRepository.findByNomBloc(nomBloc);
        List<Chambre> chambres = new ArrayList<>();
        for (Long numeroChambre : numChambre) {
            Chambre chambre = chambreRepository.findByNumeroChambre(numeroChambre);
            chambre.setBloc(bloc); //chambre est le pere.
            chambreRepository.save(chambre);

    }

        return bloc;

    }}
