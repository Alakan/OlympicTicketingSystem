package com.example.OlympicTicketingSystem.service;

import com.example.OlympicTicketingSystem.model.Offer;
import com.example.OlympicTicketingSystem.repository.OfferRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Transactional
    public Offer createOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    public Optional<Offer> findOfferById(Long id) {
        return offerRepository.findById(id);
    }

    public List<Offer> findAllOffers() {
        return offerRepository.findAll();
    }

    @Transactional
    public Offer updateOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    @Transactional
    public void deleteOffer(Offer offer) {
        offerRepository.delete(offer);
    }
}
