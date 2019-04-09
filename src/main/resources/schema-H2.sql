DELETE from t_user where user_Id = 1;
INSERT into t_user (user_Id,user_Name,`password`,salt,state) values (1,'admin','a9da90b514ec92e0973212c868408c79','root',1);