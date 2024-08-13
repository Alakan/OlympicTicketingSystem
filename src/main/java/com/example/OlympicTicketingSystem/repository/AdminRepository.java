package com.example.OlympicTicketingSystem.repository;

import com.example.OlympicTicketingSystem.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    // Méthode pour trouver un administrateur par email
    Optional<Admin> findByEmail(String email);
}