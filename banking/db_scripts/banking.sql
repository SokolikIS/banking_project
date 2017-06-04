DROP SCHEMA IF EXISTS banking;

CREATE SCHEMA IF NOT EXISTS banking
CHARACTER SET utf8;

USE banking;

CREATE TABLE users (
			 id_user INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
			 login VARCHAR(45) NOT NULL UNIQUE,
			 password VARCHAR(45) NOT NULL,
			 role INT(1),
			 del_status INT(1));
			 
INSERT INTO users (login, password, role, del_status) VALUES ('admin', 'admin', 1, 0);

CREATE TABLE usersInfo (
					 id_user INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
					 email VARCHAR(45) NOT NULL UNIQUE,
					 firstName VARCHAR(45),
					 lastName VARCHAR(45),
					 adress VARCHAR(200),
					 sex VARCHAR(45));
					 
INSERT INTO usersInfo (email) VALUES ('javaeemailapi@gmail.com');

CREATE TABLE del_users (
					 id_user INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
					 login VARCHAR(45) NOT NULL UNIQUE,
					 password VARCHAR(45) NOT NULL,
					 ip VARCHAR(45),
					 status INT(1),
					 email VARCHAR(45));
					 
CREATE TABLE banking_cards (
					 id_card INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
					 id_user INT,
					 number VARCHAR(45) NOT NULL UNIQUE,
					 date VARCHAR(45) NOT NULL,
					 currency INT);
					 
CREATE TABLE transactions (
					 id_transaction INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
					 id_from INT NOT NULL,
					 id_to INT NOT NULL,
					 amount INT);
					 
									 
					 