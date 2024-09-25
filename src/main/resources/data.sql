MERGE INTO users (id,username,email,password) VALUES (1,'dezo','dezo@test.com','123');
MERGE INTO users (id,username,email,password) VALUES(2,'Sasuke','sasuke@test.com','123');
MERGE INTO users (id,username,email,password) VALUES(3,'Goji','goji@test.com','123');

MERGE INTO address (id,street,number,user_id) VALUES(11,'Houria',670,1);
MERGE INTO address (id,street,number,user_id) VALUES(12,'la siesta',30,1);
