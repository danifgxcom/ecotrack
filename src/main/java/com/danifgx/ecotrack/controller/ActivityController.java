package com.danifgx.ecotrack.controller;

import com.danifgx.ecotrack.entity.Activity;
import com.danifgx.ecotrack.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    // Endpoint para registrar una nueva actividad para un usuario específico
    @PostMapping("/{userId}")
    public ResponseEntity<Activity> createActivity(@PathVariable Long userId, @RequestBody Activity activity) {
        Activity createdActivity = activityService.createActivity(userId, activity);
        return new ResponseEntity<>(createdActivity, HttpStatus.CREATED);
    }

    // Endpoint para obtener todas las actividades de un usuario específico
    @GetMapping("/{userId}")
    public ResponseEntity<List<Activity>> getAllActivitiesForUser(@PathVariable Long userId) {
        List<Activity> activities = activityService.getAllActivitiesForUser(userId);
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    // Endpoint para obtener una actividad específica por su ID
    @GetMapping("/{activityId}")
    public ResponseEntity<Activity> getActivityById(@PathVariable Long activityId) {
        Activity activity = activityService.getActivityById(activityId);
        if (activity != null) {
            return new ResponseEntity<>(activity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Otros endpoints para actualizar y eliminar actividades también podrían ser implementados según sea necesario.
}
