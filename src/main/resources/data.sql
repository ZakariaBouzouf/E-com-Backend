MERGE INTO user_profile (id,username,email,password,role) VALUES (1,'dezo','dezo@test.com','$2y$10$/oIpI.RamKKTKOGt8IvdXOmeODapOdarWl9z5KeNO1ngomIHd9TfG','ROLE_ADMIN');
-- MERGE INTO user_profile (id,username,email,password,role) VALUES(2,'Sasuke','sasuke@test.com','{bcrypt}123','ROLE_ADMIN');
-- MERGE INTO user_profile (id,username,email,password,role) VALUES(3,'Goji','goji@test.com','{bcrypt}123','ROLE_ADMIN');

MERGE INTO address (id,street,number,user_profile_id) VALUES(11,'Houria',670,1);
MERGE INTO address (id,street,number,user_profile_id) VALUES(12,'la siesta',30,1);

MERGE INTO product (id,name,description,image,price) VALUES(1,'Iphone 14','It s an iphone','iphone-14.jpeg',999.99);
MERGE INTO product (id,name,description,image,price) VALUES(2,'gtx 4080','Gaming','honda-trx-400.jpeg',899.99);
MERGE INTO product (id,name,description,image,price) VALUES(3,'ps5','Playstatin 5','ps5.jpeg',599.99);
MERGE INTO product (id,name,description,image,price) VALUES(4,'BabyLiss pro','BabyLiss pro 4artist','babyliss-pro.jpeg',299.99);
