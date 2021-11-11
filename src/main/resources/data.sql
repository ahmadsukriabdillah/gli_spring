insert into role(id,name) values (1,"SA");
insert into role(id,name) values (2,"QA");

insert into users(id, email,name, role_id) values(1, "admin@gmail.com", "admin", 1);
insert into users(id, email,name, role_id) values(1, "user@gmail.com", "user", 2);