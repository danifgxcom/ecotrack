-- Insertar roles
INSERT INTO role (name) VALUES ('ADMIN');
INSERT INTO role (name) VALUES ('ATTENDEE');
INSERT INTO role (name) VALUES ('STAFF');

-- Insertar usuarios con roles específicos
-- Usuario ADMIN
INSERT INTO user (username, password) VALUES ('admin', '$2a$10$VZDY8UZ/EB6IZukQjVqJFeK.Fq4MT0Xn9.6l4kG0Bl7ov5akpNfma'); -- La contraseña 'admin'
INSERT INTO user_role (user_id, role_id) VALUES ((SELECT id FROM user WHERE username = 'admin'), (SELECT id FROM role WHERE name = 'ADMIN'));

-- Usuarios STAFF
INSERT INTO user (username, password) VALUES ('staff1', '$2a$10$VZDY8UZ/EB6IZukQjVqJFeK.Fq4MT0Xn9.6l4kG0Bl7ov5akpNfma'); -- La contraseña 'staff1'
INSERT INTO user_role (user_id, role_id) VALUES ((SELECT id FROM user WHERE username = 'staff1'), (SELECT id FROM role WHERE name = 'STAFF'));

INSERT INTO user (username, password) VALUES ('staff2', '$2a$10$VZDY8UZ/EB6IZukQjVqJFeK.Fq4MT0Xn9.6l4kG0Bl7ov5akpNfma'); -- La contraseña 'staff2'
INSERT INTO user_role (user_id, role_id) VALUES ((SELECT id FROM user WHERE username = 'staff2'), (SELECT id FROM role WHERE name = 'STAFF'));
