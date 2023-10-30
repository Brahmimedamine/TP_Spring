package com.example.project.Service;

import com.example.project.Entity.Bloc;
import com.example.project.Repository.BlocRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class BlocService implements IBlocService{
    BlocRepository blocRepository;

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
}
