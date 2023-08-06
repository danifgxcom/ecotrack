package com.danifgx.ecotrack.service;

import com.danifgx.ecotrack.entity.User;
import com.danifgx.ecotrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        // Lógica para crear un nuevo usuario y guardar en la base de datos
        return userRepository.save(user);
    }

    public User getUserById(Long userId) {
        // Lógica para obtener un usuario por su ID desde la base de datos
        return userRepository.findById(userId).orElse(null);
    }

    public User updateUser(Long userId, User updatedUser) {
        // Lógica para actualizar un usuario existente en la base de datos
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            // Actualizar atributos relevantes del usuario
            // user.setName(updatedUser.getName());
            // user.setEmail(updatedUser.getEmail());
            // ... Otros atributos

            return userRepository.save(user);
        }
        return null;
    }
}
