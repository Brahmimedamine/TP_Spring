package com.example.project.Service;

import com.example.project.Entity.Chambre;
import com.example.project.Repository.ChambreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ChambreService implements IChambreService{
    ChambreRepository chambreRepository;

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
}
