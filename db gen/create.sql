CREATE DATABASE ForoHub;
USE ForoHub;

-- Tabla Curso
CREATE TABLE Curso (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    categoria VARCHAR(50)
);

-- Tabla Usuario
CREATE TABLE Usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    correoElectronico VARCHAR(100) UNIQUE,
    contrasena VARCHAR(255),
    perfiles INT
);

-- Tabla Perfil
CREATE TABLE Perfil (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50)
);

-- Tabla Topico
CREATE TABLE Topico (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255),
    mensaje TEXT,
    fechaCreacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    status ENUM('abierto', 'cerrado'),
    autor INT,
    curso INT,
    FOREIGN KEY (autor) REFERENCES Usuario(id),
    FOREIGN KEY (curso) REFERENCES Curso(id)
);

-- Tabla Respuesta
CREATE TABLE Respuesta (
    id INT PRIMARY KEY AUTO_INCREMENT,
    mensaje TEXT,
    topico INT,
    fechaCreacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    autor INT,
    solucion BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (topico) REFERENCES Topico(id),
    FOREIGN KEY (autor) REFERENCES Usuario(id)
);