package com.danifgx.ecotrack.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class CarbonFootprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double totalCarbonFootprint; // Huella de carbono total del usuario

    @Column(nullable = false)
    private LocalDate date; // Fecha del registro del cálculo de la huella de carbono

    // Relación uno a uno con la entidad User
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Métodos getter y setter
}
