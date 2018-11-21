CREATE TABLE account (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    birth_date DATE
);