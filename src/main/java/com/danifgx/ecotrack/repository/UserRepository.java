package com.danifgx.ecotrack.repository;

import com.danifgx.ecotrack.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Puedes agregar métodos personalizados aquí si necesitas consultas específicas
}
