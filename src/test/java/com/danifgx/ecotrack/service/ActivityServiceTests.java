package com.danifgx.ecotrack.service;

import com.danifgx.ecotrack.entity.Activity;
import com.danifgx.ecotrack.entity.User;
import com.danifgx.ecotrack.repository.ActivityRepository;
import com.danifgx.ecotrack.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ActivityServiceTests {

    @Mock
    private ActivityRepository activityRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ActivityService activityService;

    @Test
    public void testGetAllActivitiesForUser() {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);

        Activity activity1 = new Activity();
        activity1.setId(101L);
        activity1.setName("Activity 1");
        activity1.setUser(user);

        Activity activity2 = new Activity();
        activity2.setId(102L);
        activity2.setName("Activity 2");
        activity2.setUser(user);

        List<Activity> activities = List.of(activity1, activity2);

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(activityRepository.findAllByUser(user)).thenReturn(activities);

        List<Activity> resultActivities = activityService.getAllActivitiesForUser(userId);

        assertEquals(2, resultActivities.size());
        assertEquals("Activity 1", resultActivities.get(0).getName());
        assertEquals("Activity 2", resultActivities.get(1).getName());
    }

    @Test
    public void testGetAllActivitiesForUserNotFound() {
        Long userId = 2L;

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        List<Activity> resultActivities = activityService.getAllActivitiesForUser(userId);

        assertTrue(resultActivities.isEmpty());
    }

    // Puedes agregar más pruebas para otros métodos en ActivityService según sea necesario.
}
