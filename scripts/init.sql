CREATE DATABASE IF NOT EXISTS board_db;
USE board_db;

CREATE TABLE boards (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE cards (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    status VARCHAR(20) DEFAULT 'TODO',
    board_id BIGINT,
    FOREIGN KEY (board_id) REFERENCES boards(id)
);