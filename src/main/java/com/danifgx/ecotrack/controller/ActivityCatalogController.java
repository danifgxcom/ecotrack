package com.danifgx.ecotrack.controller;

import com.danifgx.ecotrack.entity.ActivityCatalog;
import com.danifgx.ecotrack.service.ActivityCatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/catalogs")
public class ActivityCatalogController {

    private final ActivityCatalogService activityCatalogService;

    public ActivityCatalogController(ActivityCatalogService activityCatalogService) {
        this.activityCatalogService = activityCatalogService;
    }

    @GetMapping
    public ResponseEntity<List<ActivityCatalog>> getAllCatalogItems() {
        List<ActivityCatalog> allCatalogItems = activityCatalogService.getAllCatalogItems();
        return ResponseEntity.ok(allCatalogItems);
    }

    @GetMapping("/{catalogName}")
    public ResponseEntity<List<ActivityCatalog>> getCatalogByName(@PathVariable String catalogName) {
        try {
            List<ActivityCatalog> catalogItems = activityCatalogService.getCatalog(catalogName);
            return ResponseEntity.ok(catalogItems);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
