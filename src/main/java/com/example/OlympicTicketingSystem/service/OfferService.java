package com.example.OlympicTicketingSystem.service;

import com.example.OlympicTicketingSystem.model.Offer;
import com.example.OlympicTicketingSystem.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    // Méthode pour récupérer toutes les offres
    public List<Offer> findAllOffers() {
        return offerRepository.findAll();
    }

    // Méthode pour créer une nouvelle offre
    public Offer createOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    // Autres méthodes métiers pour la gestion des offres...
}