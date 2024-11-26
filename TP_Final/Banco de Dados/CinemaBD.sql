-- Criação do banco de dados
CREATE DATABASE CinemaDB;
USE CinemaDB;

-- Tabela Cinema
CREATE TABLE Cinema (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL UNIQUE,
    local VARCHAR(255) NOT NULL
);

-- Tabela Sala
CREATE TABLE Sala (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    capacidade INT NOT NULL,
    cinema_id INT NOT NULL,
    FOREIGN KEY (cinema_id) REFERENCES Cinema(id) ON DELETE CASCADE,
    UNIQUE (nome, cinema_id)
);

-- Tabela Filme
CREATE TABLE Filme (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL UNIQUE,
    duracao_s BIGINT NOT NULL
);

-- Tabela Sessao
CREATE TABLE Sessao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sala_id INT NOT NULL,
    filme_id INT NOT NULL,
    data_hora DATETIME NOT NULL,
    FOREIGN KEY (sala_id) REFERENCES Sala(id) ON DELETE CASCADE,
    FOREIGN KEY (filme_id) REFERENCES Filme(id) ON DELETE CASCADE,
    UNIQUE (sala_id, data_hora)
);

-- Tabela VendaIngresso
CREATE TABLE VendaIngresso (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sessao_id INT NOT NULL,
    quantidade INT NOT NULL,
    FOREIGN KEY (sessao_id) REFERENCES Sessao(id) ON DELETE CASCADE
);