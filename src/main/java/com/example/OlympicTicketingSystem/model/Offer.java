package com.example.OlympicTicketingSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity // Indique que cette classe est une entité JPA.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // La clé primaire sera générée automatiquement.
    private Long id;

    @NotNull // Assure que le type de l'offre (ex: solo, duo, famille) ne peut pas être nul.
    private String type;

    @NotNull // Assure que la description de l'offre ne peut pas être nulle.
    private String description;

    @NotNull // Assure que le prix de l'offre ne peut pas être nul.
    private Double price;

    // Relation avec l'entité Reservation. Une offre peut avoir plusieurs réservations.
    @OneToMany(mappedBy = "offer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;
}