package com.danifgx.ecotrack.service;

import com.danifgx.ecotrack.entity.ActivityCatalog;
import com.danifgx.ecotrack.repository.ActivityCatalogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityCatalogService {

    private final ActivityCatalogRepository activityCatalogRepository;

    public ActivityCatalogService(ActivityCatalogRepository activityCatalogRepository) {
        this.activityCatalogRepository = activityCatalogRepository;
    }

    public List<ActivityCatalog> getCatalog(String catalogName) {
        switch (catalogName) {
            case "activity_catalog":
                return activityCatalogRepository.findAll();
            default:
                throw new IllegalArgumentException("Catalog not found: " + catalogName);
        }
    }

    public List<ActivityCatalog> getAllCatalogItems() {
        return activityCatalogRepository.findAll();
    }
}
