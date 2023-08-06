package com.danifgx.ecotrack.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // Nombre de la actividad, por ejemplo, "Viaje en transporte público"

    @Column(nullable = false)
    private double carbonFootprint; // La cantidad de huella de carbono generada por esta actividad

    // Fecha y hora de la actividad
    @Column(nullable = false)
    private LocalDateTime dateTime;

    // Relación muchos a uno con la entidad User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Métodos getter y setter
}
