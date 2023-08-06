package com.danifgx.ecotrack.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "activity_catalog")
@Data
public class ActivityCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, precision = 5, scale = 3)
    private BigDecimal averageEmissionFactor;

    // Getters y setters (puedes usar Lombok para generarlos automáticamente).

}
