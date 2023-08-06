package com.danifgx.ecotrack.repository;

import com.danifgx.ecotrack.entity.ActivityCatalog;
import com.danifgx.ecotrack.service.ActivityCatalogService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface ActivityCatalogRepository extends JpaRepository<ActivityCatalog, Long> {
    // Si necesitas hacer consultas personalizadas, puedes agregar métodos aquí.
}
