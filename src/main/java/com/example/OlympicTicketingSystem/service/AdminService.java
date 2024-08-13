package com.example.OlympicTicketingSystem.service;

import com.example.OlympicTicketingSystem.model.Admin;
import com.example.OlympicTicketingSystem.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // Méthode pour trouver un administrateur par email
    public Optional<Admin> findAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    // Méthode pour enregistrer un nouvel administrateur
    public Admin registerAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Autres méthodes métiers pour la gestion des administrateurs...
}