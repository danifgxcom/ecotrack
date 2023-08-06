package com.danifgx.ecotrack.service;

import com.danifgx.ecotrack.entity.User;
import com.danifgx.ecotrack.repository.UserRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserServiceTests {

    // Define el contenedor de PostgreSQL en memoria
    @Container
    private static final PostgreSQLContainer<?> postgreSQLContainer =
            new PostgreSQLContainer<>("postgres:latest") // Reemplaza "latest" con la versión deseada de PostgreSQL
                    .withDatabaseName("testdb")
                    .withUsername("testuser")
                    .withPassword("testpassword");

    @DynamicPropertySource
    static void setDataSourceProperties(DynamicPropertyRegistry registry) {
        // Configura las propiedades del DataSource para que utilicen las del contenedor
        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
    }


    @BeforeAll
    public static void setUp() {
        // Inicia el contenedor antes de que se ejecuten las pruebas
        postgreSQLContainer.start();
    }

    @AfterAll
    public static void tearDown() {
        // Detiene y elimina el contenedor después de que se ejecuten todas las pruebas
        postgreSQLContainer.stop();
    }

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserById() {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setName("John Doe");

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        User resultUser = userService.getUserById(userId);

        assertEquals(userId, resultUser.getId());
        assertEquals("John Doe", resultUser.getName());
    }

    @Test
    public void testGetUserByIdNotFound() {
        Long userId = 2L;

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        User resultUser = userService.getUserById(userId);

        assertNull(resultUser);
    }

    // Puedes agregar más pruebas para otros métodos en UserService según sea necesario.
}
