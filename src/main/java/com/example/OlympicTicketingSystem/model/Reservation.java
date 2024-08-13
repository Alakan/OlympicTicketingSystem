package com.example.OlympicTicketingSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Entity // Indique que cette classe est une entité JPA.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // La clé primaire sera générée automatiquement.
    private Long id;

    @NotNull // Assure que la clé de la réservation ne peut pas être nulle.
    @Column(name = "reservation_key")
    private String reservationKey;

    @Temporal(TemporalType.TIMESTAMP) // Indique que ce champ représente une date et une heure.
    @NotNull // Assure que la date de réservation ne peut pas être nulle.
    private Date date;

    // Relation Many-to-One avec l'entité User. Plusieurs réservations peuvent être faites par un utilisateur.
    @ManyToOne(fetch = FetchType.LAZY) // Chargement paresseux pour améliorer la performance.
    @JoinColumn(name = "user_id") // Indique la colonne user_id dans la table Reservation qui référence l'utilisateur.
    private User user;

    // Relation Many-to-One avec l'entité Offer. Plusieurs réservations peuvent être faites pour une même offre.
    @ManyToOne(fetch = FetchType.LAZY) // Chargement paresseux pour améliorer la performance.
    @JoinColumn(name = "offer_id") // Indique la colonne offer_id dans la table Reservation qui référence l'offre.
    private Offer offer;
}