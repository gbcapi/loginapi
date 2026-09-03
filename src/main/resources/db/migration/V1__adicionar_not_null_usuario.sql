-- Migration V1: torna obrigatorios os campos essenciais da tabela usuario
-- Motivo: o ddl-auto=update do Hibernate ignorou silenciosamente essa alteracao
-- quando tentamos aplica-la anteriormente, entao agora aplicamos via Flyway,
-- de forma explicita e confiavel.

ALTER TABLE usuario MODIFY nome VARCHAR(255) NOT NULL;
ALTER TABLE usuario MODIFY email VARCHAR(255) NOT NULL;
ALTER TABLE usuario MODIFY senha VARCHAR(255) NOT NULL;
ALTER TABLE usuario MODIFY tipo ENUM('ADMIN','OPERADOR','USER') NOT NULL;