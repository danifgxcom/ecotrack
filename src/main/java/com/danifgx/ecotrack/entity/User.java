package com.danifgx.ecotrack.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    // Otros atributos relevantes para el usuario, como contraseñas, preferencias, etc.

    // Relación uno a muchos con la entidad Activity
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Activity> activities = new ArrayList<>();


}
