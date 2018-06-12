CREATE TABLE users (
    user_id BIGINT PRIMARY KEY auto_increment,
    username VARCHAR(128) UNIQUE,
    password VARCHAR(256),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;