package com.example.project.Service;

import com.example.project.Entity.Etudiant;
import com.example.project.Entity.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {


    List<Reservation> retrieveAllReservations();

    Reservation addReservation(Reservation r);

    Reservation updateReservation(Reservation r);

    Reservation retrieveReservation(Long idReservation);

    void removeReservation(Long idReservation);

    List<Reservation> getReservationParAnneeUniversitaire(Date dateD , Date dateF );

}
