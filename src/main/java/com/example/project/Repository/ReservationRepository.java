package com.example.project.Repository;

import com.example.project.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
        List<Reservation> findByAnneeUniversitaireBetween(Date dateD , Date dateF );

}
