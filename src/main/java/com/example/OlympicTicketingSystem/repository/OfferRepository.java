package com.example.OlympicTicketingSystem.repository;

import com.example.OlympicTicketingSystem.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    // Vous pouvez ajouter des méthodes de recherche personnalisées ici si nécessaire
}
