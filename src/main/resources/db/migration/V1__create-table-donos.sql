CREATE TABLE donos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    especialidade VARCHAR(100) NOT NULL,
    rua VARCHAR(100) NOT NULL,
    cep VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);