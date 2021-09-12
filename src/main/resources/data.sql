INSERT INTO USERS (name, email, password)
VALUES ('User', 'user@yandex.ru', '{noop}password'),
       ('Admin', 'admin@gmail.com', '{noop}admin');

INSERT INTO USER_ROLES (role, user_id)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2);

INSERT INTO RESTAURANT (name, date)
VALUES ('Ресторан_1', now()),
       ('Ресторан_2', now()),
       ('Ресторан_3', now());

INSERT INTO MEAL (name, date, price, restaurant_id)
VALUES ('Еда ресторана 1_1', now(), 500, 1),
       ('Еда ресторана 1_2', now(), 600, 1),
       ('Еда ресторана 1_3', now(), 700, 1),
       ('Еда ресторана 2_1', now(), 500, 2),
       ('Еда ресторана 2_2', now(), 600, 2),
       ('Еда ресторана 2_3', now(), 700, 2),
       ('Еда ресторана 3_1', now(), 500, 3),
       ('Еда ресторана 3_2', now(), 600, 3),
       ('Еда ресторана 3_3', now(), 700, 3);

INSERT INTO VOTE (date, time, restaurant_id, user_id)
VALUES (now(), '09:00:00', 1, 1),
       (now(), '10:00:00', 2, 2);


