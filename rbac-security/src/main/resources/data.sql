INSERT INTO
    tb_role (id, name)
VALUES
    (1, 'ROLE_ADMIN'),
    (2, 'ROLE_USER');

INSERT INTO
    tb_user (id, username, password, enabled)
VALUES
    (1, 'admin', '123', true),
    (2, 'user', '456', true),
    (3, 'super', '789', true);

INSERT INTO
    user_roles (user_id, role_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 1),
    (3, 2);