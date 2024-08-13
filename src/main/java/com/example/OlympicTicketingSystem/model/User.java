package com.example.OlympicTicketingSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity // Indique que cette classe est une entité JPA, mappée à une table dans la base de données.
@Getter // Génère automatiquement les getters pour tous les champs de la classe.
@Setter // Génère automatiquement les setters pour tous les champs de la classe.
@NoArgsConstructor // Génère un constructeur sans arguments.
@AllArgsConstructor // Génère un constructeur avec tous les arguments.
@Builder // Permet de créer des instances de cette classe en utilisant le pattern Builder.
@Table(name = "users") // Spécifie le nom de la table dans la base de données.
public class User {

    @Id // Indique que ce champ est la clé primaire de l'entité.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Spécifie que la clé primaire sera générée automatiquement par la base de données.
    private Long id;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "Le prénom doit contenir uniquement des lettres.")
    @NotNull(message = "Le prénom ne doit pas être nul.")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "Le nom doit contenir uniquement des lettres.")
    @NotNull(message = "Le nom ne doit pas être nul.")
    private String lastName;

    @Email(message = "L'email doit être une adresse électronique valide.")
    @NotNull(message = "L'email ne doit pas être nul.")
    @Column(unique = true) // Spécifie que l'email doit être unique dans la base de données.
    private String email;

    @NotNull(message = "Le mot de passe ne doit pas être nul.")
    @Size(min = 8, message = "Le mot de passe doit contenir au moins 8 caractères.")
    private String password;

    @Column(name = "user_key")
    private String userKey; // Un champ optionnel qui peut stocker une clé de sécurité pour l'utilisateur.

    // Relation avec l'entité Reservation. Un utilisateur peut avoir plusieurs réservations.
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;
}
