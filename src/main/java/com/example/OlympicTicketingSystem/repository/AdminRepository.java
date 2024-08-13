package com.example.OlympicTicketingSystem.repository;

import com.example.OlympicTicketingSystem.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Indique que cette interface est un composant Spring pour la gestion des données.
public interface AdminRepository extends JpaRepository<Admin, Long> {

    // Méthode pour trouver un administrateur par son email.
    Optional<Admin> findByEmail(String email);
}
