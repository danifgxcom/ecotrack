package com.danifgx.ecotrack.service;

import com.danifgx.ecotrack.entity.Activity;
import com.danifgx.ecotrack.entity.User;
import com.danifgx.ecotrack.repository.ActivityRepository;
import com.danifgx.ecotrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository, UserRepository userRepository) {
        this.activityRepository = activityRepository;
        this.userRepository = userRepository;
    }

    public Activity createActivity(Long userId, Activity activity) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            // Lógica para calcular la huella de carbono de la actividad y establecerla en activity.setCarbonFootprint(...)
            // ...

            return activityRepository.save(activity);
        }
        return null;
    }

    public List<Activity> getAllActivitiesForUser(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return activityRepository.findAllByUser(user);
        }
        return Collections.emptyList();
    }


    public Activity getActivityById(Long activityId) {
        return activityRepository.findById(activityId).orElse(null);
    }

    // Resto de métodos del servicio...
}

