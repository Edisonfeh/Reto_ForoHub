CREATE TABLE usuarios (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          apellido VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL UNIQUE,
                          enabled BIT(1) NOT NULL,
                          nombre VARCHAR(255) NOT NULL,
                          password VARCHAR(255) NOT NULL,
                          role ENUM('ADMINISTRADOR', 'USUARIO', 'EXPECTADOR') NOT NULL,
                          username VARCHAR(255) NOT NULL UNIQUE
);