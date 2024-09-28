MERGE INTO user_profile (id,username,email,password,role) VALUES (1,'dezo','dezo@test.com','$2y$10$/oIpI.RamKKTKOGt8IvdXOmeODapOdarWl9z5KeNO1ngomIHd9TfG','ROLE_ADMIN');
-- MERGE INTO user_profile (id,username,email,password,role) VALUES(2,'Sasuke','sasuke@test.com','{bcrypt}123','ROLE_ADMIN');
-- MERGE INTO user_profile (id,username,email,password,role) VALUES(3,'Goji','goji@test.com','{bcrypt}123','ROLE_ADMIN');

MERGE INTO address (id,street,number,user_profile_id) VALUES(11,'Houria',670,1);
MERGE INTO address (id,street,number,user_profile_id) VALUES(12,'la siesta',30,1);
