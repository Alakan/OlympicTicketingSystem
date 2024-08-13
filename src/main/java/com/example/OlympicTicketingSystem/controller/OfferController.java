package com.example.OlympicTicketingSystem.controller;

import com.example.OlympicTicketingSystem.model.Offer;
import com.example.OlympicTicketingSystem.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @PostMapping
    public ResponseEntity<Offer> createOffer(@RequestBody Offer offer) {
        Offer createdOffer = offerService.createOffer(offer);
        return ResponseEntity.status(201).body(createdOffer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Offer>> getOfferById(@PathVariable Long id) {
        Optional<Offer> offer = offerService.findOfferById(id);
        if (offer.isPresent()) {
            return ResponseEntity.ok(offer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Offer>> getAllOffers() {
        List<Offer> offers = offerService.findAllOffers();
        return ResponseEntity.ok(offers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Offer> updateOffer(@PathVariable Long id, @RequestBody Offer offerDetails) {
        Optional<Offer> offerOptional = offerService.findOfferById(id);
        if (offerOptional.isPresent()) {
            Offer offer = offerOptional.get();
            offer.setDescription(offerDetails.getDescription());
            offer.setPrice(offerDetails.getPrice());
            offer.setType(offerDetails.getType());
            final Offer updatedOffer = offerService.updateOffer(offer);
            return ResponseEntity.ok(updatedOffer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable Long id) {
        Optional<Offer> offerOptional = offerService.findOfferById(id);
        if (offerOptional.isPresent()) {
            offerService.deleteOffer(offerOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
