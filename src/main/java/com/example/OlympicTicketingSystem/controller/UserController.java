package com.example.OlympicTicketingSystem.controller;

import com.example.OlympicTicketingSystem.model.User;
import com.example.OlympicTicketingSystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint pour enregistrer un nouvel utilisateur.
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody User user) {
        // Appel au service pour enregistrer un nouvel utilisateur.
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.status(201).body(registeredUser);
    }

    // Endpoint pour récupérer un utilisateur par email.
    @GetMapping("/{email}")
    public ResponseEntity<Optional<User>> getUserByEmail(@PathVariable String email) {
        // Recherche de l'utilisateur par email.
        Optional<User> user = userService.findUserByEmail(email);
        // Si l'utilisateur est trouvé, retournez une réponse OK avec l'utilisateur, sinon retournez une réponse Not Found.
        if (user.isPresent()) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint pour récupérer tous les utilisateurs.
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        // Appel au service pour récupérer tous les utilisateurs.
        List<User> users = userService.findAllUsers();
        // Retourne une réponse OK avec la liste des utilisateurs.
        return ResponseEntity.ok(users);
    }

    // Endpoint pour mettre à jour un utilisateur par ID.
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User userDetails) {
        // Recherche de l'utilisateur par ID.
        Optional<User> userOptional = userService.findUserById(id);

        // Si l'utilisateur est trouvé, mise à jour des détails et sauvegarde.
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setEmail(userDetails.getEmail());
            // Mise à jour d'autres champs si nécessaire.
            final User updatedUser = userService.updateUser(user);
            return ResponseEntity.ok(updatedUser);
        } else {
            // Si l'utilisateur n'est pas trouvé, retournez une réponse Not Found.
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint pour supprimer un utilisateur par ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        // Recherche de l'utilisateur par ID.
        Optional<User> userOptional = userService.findUserById(id);

        // Si l'utilisateur est trouvé, suppression de l'utilisateur.
        if (userOptional.isPresent()) {
            userService.deleteUser(userOptional.get());
            // Retourne une réponse No Content après la suppression.
            return ResponseEntity.noContent().build();
        } else {
            // Si l'utilisateur n'est pas trouvé, retournez une réponse Not Found.
            return ResponseEntity.notFound().build();
        }
    }
}
