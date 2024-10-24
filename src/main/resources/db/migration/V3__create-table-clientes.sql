CREATE TABLE clientes (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    data_cadastro DATE,
    servicos VARCHAR(255) NOT NULL, -- O enum será armazenado como String
    telefone VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);
