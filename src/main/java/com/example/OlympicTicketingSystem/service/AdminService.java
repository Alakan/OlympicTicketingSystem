package com.example.OlympicTicketingSystem.service;

import com.example.OlympicTicketingSystem.model.Admin;
import com.example.OlympicTicketingSystem.repository.AdminRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Indique que cette classe est un service Spring.
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    // Méthode pour enregistrer un nouvel administrateur.
    public Admin registerAdmin(Admin admin) {
        // Hacher le mot de passe avant de le sauvegarder.
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        // Enregistrement de l'administrateur dans la base de données.
        return adminRepository.save(admin);
    }

    // Méthode pour trouver un administrateur par son email.
    public Optional<Admin> findAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    // Méthode pour trouver un administrateur par son ID.
    public Optional<Admin> findAdminById(Long id) {
        return adminRepository.findById(id);
    }

    @Transactional
    // Méthode pour mettre à jour un administrateur.
    public Admin updateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Transactional
    // Méthode pour supprimer un administrateur.
    public void deleteAdmin(Admin admin) {
        adminRepository.delete(admin);
    }

    // Méthode pour récupérer tous les administrateurs.
    public List<Admin> findAllAdmins() {
        return adminRepository.findAll();
    }
}
