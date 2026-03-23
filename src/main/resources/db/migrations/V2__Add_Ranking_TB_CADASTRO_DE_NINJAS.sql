-- V2: Migrations para adicionar a coluna de ranking na tabela de cadastro de ninjas
ALTER TABLE tb_cadastro_de_ninjas
ADD COLUMN ranking VARCHAR(255);