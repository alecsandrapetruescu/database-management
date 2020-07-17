DROP DATABASE IF EXISTS `users`;
CREATE DATABASE IF NOT EXISTS `users` CHARACTER SET utf8 COLLATE utf8_unicode_ci;

USE `users`;
DROP TABLE IF EXISTS `users`.`users`;
CREATE TABLE IF NOT EXISTS `users`.`users`
(
    id BIGINT(50) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci null,
    first_name VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci null,
    last_name VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci null
) ENGINE = InnoDB;

INSERT INTO `users`.`users` (id, username, first_name, last_name) VALUES
(1, "user1", "jon", "doe"),
(2, "user2", "jane", "doe"),
(3, "user3", "jack", "doe"),
(4, "user4", "janet", "doe");

SELECT * FROM `users`.`users`;