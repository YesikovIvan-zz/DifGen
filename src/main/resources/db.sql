delete from roles;
delete from users;

INSERT INTO users (id,email,username,password) VALUES
 (1,'admin@mail.com','admin','123123'),
 (2,'test@mail.com','user','123123');

INSERT INTO roles (role_id,role_name,user_id) VALUES 
 (1,'ROLE_USER',1),
 (2,'ROLE_ADMIN',1),
 (3,'ROLE_USER',2);
