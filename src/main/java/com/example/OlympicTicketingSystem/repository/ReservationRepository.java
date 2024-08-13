package com.example.OlympicTicketingSystem.repository;

import com.example.OlympicTicketingSystem.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Vous pouvez ajouter d'autres méthodes personnalisées si nécessaire
}
