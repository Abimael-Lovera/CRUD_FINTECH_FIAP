-- Tabela de usuário
CREATE TABLE T_USUARIO (
    id_usuario_cpf INTEGER PRIMARY KEY,
    nm_usuario VARCHAR2(255) NOT NULL,
    email VARCHAR2(100) NOT NULL,
    telefone VARCHAR2(15) NOT NULL,
    dt_nascimento DATE NOT NULL
);
-- Tabela de login
CREATE TABLE T_LOGIN (
    id_login INTEGER PRIMARY KEY,
    id_usuario_cpf INTEGER NOT NULL,
    tipo VARCHAR2(255) NOT NULL
      CHECK (tipo IN('GOOGLE','APPLE','EMAIL')),
    senha VARCHAR2(255) NOT NULL,
    dt_criacao DATE NOT NULL,
    dt_ultimo_acesso DATE NOT NULL,
    FOREIGN KEY(id_usuario_cpf) REFERENCES T_USUARIO(id_usuario_cpf)
);
-- Tabela de receita
CREATE TABLE T_RECEITA (
    id_receita INTEGER PRIMARY KEY,
    id_usuario_cpf INTEGER NOT NULL,
    ds_receita VARCHAR2(255) NOT NULL, -- descrição
    vl_receita NUMBER(10, 2) NOT NULL, -- valor receita
    dt_receita DATE NOT NULL,
    FOREIGN KEY(id_usuario_cpf) REFERENCES T_USUARIO(id_usuario_cpf)
);
-- Tablea de despesa
CREATE TABLE T_DESPESA (
    id_despesa INTEGER PRIMARY KEY,
    id_usuario_cpf INTEGER NOT NULL,
    ds_despesa VARCHAR2(255) NOT NULL, -- descrição
    vl_despesa NUMBER(10, 2) NOT NULL, -- valor
    dt_despesa DATE NOT NULL,
    FOREIGN KEY(id_usuario_cpf) REFERENCES T_USUARIO(id_usuario_cpf)
);
-- Tabela de investimento
CREATE TABLE T_INVESTIMENTO (
    id_investimento INTEGER PRIMARY KEY,
    id_usuario_cpf INTEGER NOT NULL,
    ds_investimento VARCHAR2(255) NOT NULL, -- descrição
    vl_investimento NUMBER(10, 2) NOT NULL, -- valor
    dt_investimento DATE NOT NULL,
    FOREIGN KEY(id_usuario_cpf) REFERENCES T_USUARIO(id_usuario_cpf)
);
