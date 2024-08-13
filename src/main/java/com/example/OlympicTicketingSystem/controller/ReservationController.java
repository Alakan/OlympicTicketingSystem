package com.example.OlympicTicketingSystem.controller;

import com.example.OlympicTicketingSystem.model.Reservation;
import com.example.OlympicTicketingSystem.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    // Endpoint pour récupérer les réservations d'un utilisateur
    @GetMapping("/user/{userId}")
    public List<Reservation> getReservationsByUser(@PathVariable Long userId) {
        return reservationService.findReservationsByUser(userId);
    }

    // Endpoint pour créer une nouvelle réservation
    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    // Autres endpoints pour la gestion des réservations...
}