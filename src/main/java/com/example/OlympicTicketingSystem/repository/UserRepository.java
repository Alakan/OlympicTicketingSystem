package com.example.OlympicTicketingSystem.repository;

import com.example.OlympicTicketingSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Indique que cette interface est un composant Spring pour la gestion des données.
public interface UserRepository extends JpaRepository<User, Long> {

    // Méthode pour trouver un utilisateur par son email.
    Optional<User> findByEmail(String email);
}
