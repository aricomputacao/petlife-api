CREATE TABLE usuario (
           usr_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
           usr_cpf VARCHAR(11) NOT NULL UNIQUE,
           usr_nome VARCHAR(255) NOT NULL,
           usr_email VARCHAR(255) NOT NULL UNIQUE,
           usr_senha VARCHAR(512) NOT NULL,
           end_logradouro VARCHAR(255) NOT NULL,
           end_numero INTEGER,
           end_complemento VARCHAR(255),
           end_bairro VARCHAR(255) NOT NULL,
           end_cidade VARCHAR(255) NOT NULL,
           end_estado VARCHAR(255) NOT NULL,
           end_cep VARCHAR(10)
);



INSERT INTO usuario (usr_cpf, usr_nome, usr_email, usr_senha,end_logradouro,
                     end_numero, end_complemento, end_bairro, end_cidade, end_estado, end_cep)
VALUES ('03125422201', 'Usuário 01', 'usuario01@gmail.com', '$2a$10$o8wTSxLhVGSAjFlJZQ3fCO1QYm6.xNnmWDVwWB/4Mm/10i61Ds8vG',
        'Rua General Costa', 143, '','Centro','Fortaleza','CE','60110370');

INSERT INTO usuario (usr_cpf, usr_nome, usr_email, usr_senha,end_logradouro,
                     end_numero, end_complemento, end_bairro, end_cidade, end_estado, end_cep)
VALUES ('05445622443', 'Usuário 02', 'usuario02@gmail.com', '$2a$10$o8wTSxLhVGSAjFlJZQ3fCO1QYm6.xNnmWDVwWB/4Mm/10i61Ds8vG',
        'Rua General Costa', 143, '','Centro','Fortaleza','CE','60110370');
