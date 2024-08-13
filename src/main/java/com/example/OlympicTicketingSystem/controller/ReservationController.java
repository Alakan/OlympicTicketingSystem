package com.example.OlympicTicketingSystem.controller;

import com.example.OlympicTicketingSystem.model.Reservation;
import com.example.OlympicTicketingSystem.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation createdReservation = reservationService.createReservation(reservation);
        return ResponseEntity.status(201).body(createdReservation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Reservation>> getReservationById(@PathVariable Long id) {
        Optional<Reservation> reservation = reservationService.findReservationById(id);
        if (reservation.isPresent()) {
            return ResponseEntity.ok(reservation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.findAllReservations();
        return ResponseEntity.ok(reservations);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservationDetails) {
        Optional<Reservation> reservationOptional = reservationService.findReservationById(id);
        if (reservationOptional.isPresent()) {
            Reservation reservation = reservationOptional.get();
            reservation.setDate(reservationDetails.getDate());
            reservation.setReservationKey(reservationDetails.getReservationKey());
            reservation.setOffer(reservationDetails.getOffer());
            reservation.setUser(reservationDetails.getUser());
            final Reservation updatedReservation = reservationService.updateReservation(reservation);
            return ResponseEntity.ok(updatedReservation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        Optional<Reservation> reservationOptional = reservationService.findReservationById(id);
        if (reservationOptional.isPresent()) {
            reservationService.deleteReservation(reservationOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
