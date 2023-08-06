package com.danifgx.ecotrack.repository;

import com.danifgx.ecotrack.entity.Activity;
import com.danifgx.ecotrack.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findAllByUser(User user);
}
