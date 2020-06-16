DROP DATABASE IF EXISTS `awsupload`;
CREATE DATABASE `awsupload`; 
USE `awsupload`; 
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS userprofiles;
CREATE TABLE userprofiles (
	user_id VARCHAR(36) PRIMARY KEY NOT NULL,
	username VARCHAR(50) UNIQUE KEY NOT NULL,
	profile_image_link VARCHAR(20)
);
