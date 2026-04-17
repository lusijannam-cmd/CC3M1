CREATE DATABASE IF NOT EXISTS gallery_db;
USE gallery_db;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL
);


CREATE TABLE exhibits (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
);


CREATE TABLE bookings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(100),
    exhibit_name VARCHAR(100),
    booking_date VARCHAR(50),
    booking_time VARCHAR(50),
    pax INT,
    status VARCHAR(20) DEFAULT 'Pending'
);


INSERT INTO users (name, email, password, role) VALUES 
('Admin Gomer', 'admin', 'admin123', 'Admin'),
('Test User', 'user', 'user123', 'User');

INSERT INTO exhibits (name) VALUES 
('Renaissance Art'), 
('Digital Dreams'), 
('Philippine History'),
('Modern Abstract');

INSERT INTO bookings (user_name, exhibit_name, booking_date, booking_time, pax, status) VALUES 
('Test User', 'Renaissance Art', '2026-04-15', '10:00 AM', 2, 'Approved');

DROP database gallerry_db;