package com.example.OlympicTicketingSystem.service;

import com.example.OlympicTicketingSystem.model.Reservation;
import com.example.OlympicTicketingSystem.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    // Méthode pour récupérer toutes les réservations d'un utilisateur
    public List<Reservation> findReservationsByUser(Long userId) {
        return reservationRepository.findAll().stream()
                .filter(reservation -> reservation.getUser().getId().equals(userId))
                .toList();
    }

    // Méthode pour créer une nouvelle réservation
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // Autres méthodes métiers pour la gestion des réservations...
}