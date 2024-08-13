package com.example.OlympicTicketingSystem.controller;

import com.example.OlympicTicketingSystem.model.Offer;
import com.example.OlympicTicketingSystem.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;

    // Endpoint pour récupérer toutes les offres
    @GetMapping
    public List<Offer> getAllOffers() {
        return offerService.findAllOffers();
    }

    // Endpoint pour créer une nouvelle offre
    @PostMapping
    public Offer createOffer(@RequestBody Offer offer) {
        return offerService.createOffer(offer);
    }

    // Autres endpoints pour la gestion des offres...
}