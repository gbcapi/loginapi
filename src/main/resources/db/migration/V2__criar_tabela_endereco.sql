-- Migration V2: cria a tabela endereco, com relacionamento 1:N para usuario
-- Cada endereco pertence a um unico usuario (chave estrangeira usuario_id).
-- Um usuario pode ter varios enderecos (relacionamento controlado pelo lado @ManyToOne).

CREATE TABLE endereco (
    id BIGINT NOT NULL AUTO_INCREMENT,
    rua VARCHAR(255) NOT NULL,
    numero VARCHAR(255),
    cep VARCHAR(255) NOT NULL,
    complemento VARCHAR(255),
    estado VARCHAR(255),
    cidade VARCHAR(255),
    tipo ENUM('CASA','TRABALHO') NOT NULL,
    usuario_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_endereco_usuario FOREIGN KEY (usuario_id) REFERENCES usuario (id)
) ENGINE=InnoDB;