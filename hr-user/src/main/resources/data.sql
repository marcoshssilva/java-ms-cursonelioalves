INSERT INTO tb_users (name, email, password) VALUES ('Nina Brown', 'nina@gmail.com', '$2a$10$z1sLwDzTYpKRHKkk2IFhMeSLu9iAzQkP5/sx2dYA0yJqhgaS0y95i');
INSERT INTO tb_users (name, email, password) VALUES ('Leia Red', 'leia@gmail.com', '$2a$10$z1sLwDzTYpKRHKkk2IFhMeSLu9iAzQkP5/sx2dYA0yJqhgaS0y95i');

INSERT INTO tb_roles (role_name) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_roles (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
