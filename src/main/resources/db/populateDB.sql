DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM meals;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password');

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO meals (userId, dateTime, description, calories) VALUES
  ('100000',TIMESTAMP '2017-05-16 10:36:38','test1','111'),
  ('100000',TIMESTAMP '2017-05-16 11:36:38','test2','222'),
  ('100000',TIMESTAMP '2017-05-16 15:36:38','test3','333'),
  ('100000',TIMESTAMP '2017-05-16 17:36:38','test4','444'),
  ('100001',TIMESTAMP '2017-05-16 22:36:38','test5','555'),
  ('100001',NOW(),'test6','666');