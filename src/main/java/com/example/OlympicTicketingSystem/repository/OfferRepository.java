package com.example.OlympicTicketingSystem.repository;

import com.example.OlympicTicketingSystem.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    // Vous pouvez ajouter d'autres méthodes personnalisées si nécessaire
}