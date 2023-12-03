package com.example.project.Service;

import com.example.project.Entity.Bloc;
import com.example.project.Entity.Foyer;
import com.example.project.Entity.Reservation;
import com.example.project.Repository.BlocRepository;
import com.example.project.Repository.FoyerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class FoyerService implements IFoyerService {
    FoyerRepository foyerRepository;
    BlocRepository blocRepository;

    @Override
    public List<Foyer> retrieveAllFoyer() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(Long idFoyer) {
        return foyerRepository.findById(idFoyer).get();
    }

    @Override
    public void removeFoyer(Long idFoyer) {
        foyerRepository.deleteById(idFoyer);

    }
    @Override
    public Foyer addFoyerWithBloc(Foyer foyer) {
        Foyer Foyerr = foyerRepository.save(foyer);
        Set<Bloc> blocs = Foyerr.getBlocs();
        if (blocs != null && !blocs.isEmpty()) {
            for (Bloc bloc : blocs) {
                bloc.setFoyer(Foyerr);
                blocRepository.save(bloc);
            }
        }
        return Foyerr;


    }
}
