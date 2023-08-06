CREATE TABLE IF NOT EXISTS activity_catalog (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    average_emission_factor DECIMAL(5, 3) NOT NULL
);

INSERT INTO activity_catalog (id, name, average_emission_factor) VALUES (1, 'Use of public transport', 0.100);
INSERT INTO activity_catalog (id, name, average_emission_factor) VALUES (2, 'Use of private vehicle', 0.150);
INSERT INTO activity_catalog (id, name, average_emission_factor) VALUES (3, 'Electricity consumption', 0.400);
INSERT INTO activity_catalog (id, name, average_emission_factor) VALUES (4, 'Natural gas consumption', 0.250);
INSERT INTO activity_catalog (id, name, average_emission_factor) VALUES (5, 'Water consumption', 0.005);
INSERT INTO activity_catalog (id, name, average_emission_factor) VALUES (6, 'Airplane usage', 0.200);
INSERT INTO activity_catalog (id, name, average_emission_factor) VALUES (7, 'Train usage', 0.080);
INSERT INTO activity_catalog (id, name, average_emission_factor) VALUES (8, 'Bicycle usage', 0.000);
INSERT INTO activity_catalog (id, name, average_emission_factor) VALUES (9, 'Motorcycle usage', 0.120);
INSERT INTO activity_catalog (id, name, average_emission_factor) VALUES (10, 'Truck usage', 0.180);
INSERT INTO activity_catalog (id, name, average_emission_factor) VALUES (11, 'Boat usage', 0.090);
INSERT INTO activity_catalog (id, name, average_emission_factor) VALUES (12, 'Heating fuel consumption', 0.210);
INSERT INTO activity_catalog (id, name, average_emission_factor) VALUES (13, 'Cooking fuel consumption', 0.180);
INSERT INTO activity_catalog (id, name, average_emission_factor) VALUES (14, 'Solid waste generation', 0.050);
INSERT INTO activity_catalog (id, name, average_emission_factor) VALUES (15, 'Paper consumption', 0.010);
INSERT INTO activity_catalog (id, name, average_emission_factor) VALUES (16, 'Plastic products usage', 0.020);

