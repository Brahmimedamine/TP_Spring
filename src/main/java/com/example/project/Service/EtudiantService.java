package com.example.project.Service;

import com.example.project.Entity.Etudiant;
import com.example.project.Entity.Foyer;
import com.example.project.Entity.Reservation;
import com.example.project.Repository.EtudiantRepository;
import com.example.project.Repository.ReservationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class EtudiantService implements IEtudiantService{

    EtudiantRepository repository;
    ReservationRepository reservationRepository;

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

    @Override
    public Etudiant affecterEtudiantAReservation(String nomEt, String prenomEt, Long idReservation) {
        Etudiant etudiant=repository.findByNomEtAndAndPrenomEt( nomEt,prenomEt);
        Reservation reservation=reservationRepository.findById(idReservation).get();
        reservation.getEtudiants().add(etudiant); //le reservation est le pere (la liste on n'utilise pas set on utilise get &&add)
        reservationRepository.save(reservation);

        return (etudiant);
    }
}
