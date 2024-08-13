package com.example.OlympicTicketingSystem.repository;

import com.example.OlympicTicketingSystem.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Vous pouvez ajouter des méthodes de recherche personnalisées ici si nécessaire
}
