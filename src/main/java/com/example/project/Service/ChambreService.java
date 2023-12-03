package com.example.project.Service;

import com.example.project.Entity.Bloc;
import com.example.project.Entity.Chambre;
import com.example.project.Entity.TypeChambre;
import com.example.project.Repository.BlocRepository;
import com.example.project.Repository.ChambreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ChambreService implements IChambreService{
    ChambreRepository chambreRepository;
    BlocRepository blocRepository;

    @Override
    public List<Chambre> retrieveAllchambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre ch) {
        return chambreRepository.save(ch);
    }

    @Override
    public Chambre updateChambre(Chambre ch) {
        return chambreRepository.save(ch);
    }

    @Override
    public Chambre retrieveChambre(Long idChambre) {
        return chambreRepository.findById(idChambre).get();
    }

    @Override
    public void removeChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);


    }

    @Scheduled(fixedRate = 20000)
    public void listeChambresParBloc() {
        log.info("Method with fixed Rate");


    }

    @Override
    public List<Chambre> getChambresParNomBloc(String nomBloc) {
        Bloc bloc =blocRepository.findByNomBloc(nomBloc);
        return new ArrayList<>(bloc.getChambres());
    }

    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) {
        return blocRepository.countChambresByTypeAndBlocId(type,idBloc);    }
}
