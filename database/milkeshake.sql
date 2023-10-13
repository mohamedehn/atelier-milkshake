CREATE DATABASE IF NOT EXISTS `milkshake`;
USE `milkshake`;

DROP TABLE IF EXISTS `recipe`;
DROP TABLE IF EXISTS `saler`;

CREATE USER 'moha'@'localhost' IDENTIFIED BY 'azerty!';
GRANT ALL ON milkshake.* TO 'moha'@'localhost';
FLUSH PRIVILEGES;
