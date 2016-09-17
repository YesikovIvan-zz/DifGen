DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;

CREATE TABLE users(
  id integer NOT NULL,
  email character varying(255) NOT NULL,
  username character varying(255) NOT NULL,
  password character varying(255) NOT NULL,
  CONSTRAINT users_pkey PRIMARY KEY (id),
  CONSTRAINT uk_dc4eq7plr20fdhq528twsak1b UNIQUE (email)
);

CREATE TABLE roles (
  role_id int(11) NOT NULL AUTO_INCREMENT,
  role_name character varying(255) NOT NULL,
  user_id integer,
  CONSTRAINT roles_pkey PRIMARY KEY (role_id),
  CONSTRAINT fk_g46n82f45xs0ds0r7m7ahel3d FOREIGN KEY (user_id)
      REFERENCES users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

