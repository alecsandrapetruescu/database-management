DROP DATABASE IF EXISTS user_management;
CREATE DATABASE IF NOT EXISTS user_management CHARACTER SET utf8 COLLATE utf8_unicode_ci;

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user`
(
    id BIGINT(50) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci null,
    first_name VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci null,
    last_name VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci null
) ENGINE = InnoDB;
