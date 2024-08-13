package com.example.OlympicTicketingSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity // Indique que cette classe est une entité JPA, mappée à une table dans la base de données.
@Getter // Génère automatiquement les getters pour tous les champs de la classe.
@Setter // Génère automatiquement les setters pour tous les champs de la classe.
@NoArgsConstructor // Génère un constructeur sans arguments.
@AllArgsConstructor // Génère un constructeur avec tous les arguments.
@Builder // Permet de créer des instances de cette classe en utilisant le pattern Builder.
@Table(name = "admin") // Spécifie le nom de la table dans la base de données.
public class Admin {

    @Id // Indique que ce champ est la clé primaire de l'entité.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Spécifie que la clé primaire sera générée automatiquement par la base de données.
    private Long id;

    @Email // Valide que ce champ contient une adresse email valide.
    @NotNull // Assure que l'email ne peut pas être nul.
    @Column(unique = true) // Spécifie que l'email doit être unique dans la base de données.
    private String email;

    @NotNull // Assure que le nom ne peut pas être nul.
    private String name;

    @NotNull // Assure que le mot de passe ne peut pas être nul.
    @Size(min = 8, message = "Le mot de passe doit contenir au moins 8 caractères")
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    public enum Role {
        SUPER_ADMIN,
        ADMIN,
        USER_MANAGER
    }
}
