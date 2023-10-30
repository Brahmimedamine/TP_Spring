package com.example.project.Controller;
import com.example.project.Entity.Reservation;
import com.example.project.Service.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class ReservationController {
    IReservationService reservationService;

    @GetMapping("/retrieve-all-reservation")
    public List<Reservation> getlistReservations() {
        List<Reservation> listReservations = reservationService.retrieveAllReservations();
        return listReservations;
    }

    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") Long idReservation) {
        return reservationService.retrieveReservation(idReservation);
    }
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation r) {
        Reservation reservation = reservationService.addReservation(r);
        return reservation;
    }

    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") Long idReservation) {
        reservationService.removeReservation(idReservation);
    }
    @PutMapping("/update-reservation")
    public Reservation updateReservation(@RequestBody Reservation r) {
        Reservation reservation= reservationService.updateReservation(r);
        return reservation;
    }



}
