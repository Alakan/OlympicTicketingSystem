package com.example.OlympicTicketingSystem.service;

import com.example.OlympicTicketingSystem.model.User;
import com.example.OlympicTicketingSystem.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Indique que cette classe est un service Spring.
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    // Méthode pour enregistrer un nouvel utilisateur.
    public User registerUser(User user) {
        // Hacher le mot de passe avant de le sauvegarder.
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Enregistrement de l'utilisateur dans la base de données.
        return userRepository.save(user);
    }

    // Méthode pour trouver un utilisateur par son email.
    public Optional<User> findUserByEmail(String email) {
        // Recherche de l'utilisateur dans la base de données par email.
        return userRepository.findByEmail(email);
    }

    // Méthode pour trouver un utilisateur par son ID.
    public Optional<User> findUserById(Long id) {
        // Recherche de l'utilisateur dans la base de données par ID.
        return userRepository.findById(id);
    }

    @Transactional
    // Méthode pour mettre à jour un utilisateur.
    public User updateUser(User user) {
        // Mise à jour de l'utilisateur dans la base de données.
        return userRepository.save(user);
    }

    @Transactional
    // Méthode pour supprimer un utilisateur.
    public void deleteUser(User user) {
        // Suppression de l'utilisateur dans la base de données.
        userRepository.delete(user);
    }

    // Méthode pour récupérer tous les utilisateurs.
    public List<User> findAllUsers() {
        // Récupération de tous les utilisateurs dans la base de données.
        return userRepository.findAll();
    }
}
