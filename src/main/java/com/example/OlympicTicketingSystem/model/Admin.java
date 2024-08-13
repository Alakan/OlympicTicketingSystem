package com.example.OlympicTicketingSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity // Indique que cette classe est une entité JPA.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // La clé primaire sera générée automatiquement.
    private Long id;

    @NotNull // Assure que le nom de l'administrateur ne peut pas être nul.
    private String name;

    @Email // Valide que ce champ contient une adresse email valide.
    @NotNull // Assure que l'email ne peut pas être nul.
    @Column(unique = true) // Spécifie que l'email doit être unique dans la base de données.
    private String email;

    @NotNull // Assure que le mot de passe ne peut pas être nul.
    private String password;

    // D'autres relations et méthodes peuvent être ajoutées ici en fonction des besoins.
}