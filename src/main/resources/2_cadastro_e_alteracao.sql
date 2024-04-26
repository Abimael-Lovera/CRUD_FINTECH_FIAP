-- 1. Cadastrar os dados do usuário.
INSERT INTO T_USUARIO (id_usuario_cpf, nm_usuario, email, telefone, dt_nascimento)
VALUES (1, 'João Silva', 'joao@email.com', '11987654321', TO_DATE('1990-05-15', 'YYYY-MM-DD'));
-- 2. Cadastrar os dados para a conta do usuário.
INSERT INTO T_LOGIN (id_login, id_usuario_cpf, tipo, senha, dt_criacao, dt_ultimo_acesso)
VALUES (1, 1, 'EMAIL', 'senha123', SYSDATE, SYSDATE);
-- 3. Alterar todos os dados do usuário, utilizando seu código como referência.
UPDATE T_USUARIO
SET nm_usuario = 'João da Silva', email = 'joao.silva@email.com', telefone = '11987654321'
WHERE id_usuario_cpf = 1;
-- 4. Cadastrar as receitas do usuário.
INSERT INTO T_RECEITA (id_receita, id_usuario_cpf, ds_receita, vl_receita, dt_receita)
VALUES (1, 1, 'Salário', 5000.00, TO_DATE('2024-04-01', 'YYYY-MM-DD'));
-- 5. Alterar todos os dados das receitas do usuário, utilizando o código como referência.
UPDATE T_RECEITA
SET ds_receita = 'Bônus', vl_receita = 6000.00
WHERE id_receita = 1 AND id_usuario_cpf = 1;
-- 6. Cadastrar as despesas do usuário.
INSERT INTO T_DESPESA (id_despesa, id_usuario_cpf, ds_despesa, vl_despesa, dt_despesa)
VALUES (1, 1, 'Aluguel', 1500.00, TO_DATE('2024-04-05', 'YYYY-MM-DD'));
-- 7. Alterar todos os dados das despesas do usuário, utilizando o código como referência.
UPDATE T_DESPESA
SET ds_despesa = 'Aluguel e Condomínio', vl_despesa = 1700.00
WHERE id_despesa = 1 AND id_usuario_cpf = 1;
-- 8. Cadastrar os dados para investimentos.
INSERT INTO T_INVESTIMENTO (id_investimento, id_usuario_cpf, ds_investimento, vl_investimento, dt_investimento)
VALUES (1, 1, 'Ações', 2000.00, TO_DATE('2024-04-10', 'YYYY-MM-DD'));
-- 9. Alterar todos os dados para investimentos do usuário, utilizando o código como referência.
UPDATE T_INVESTIMENTO
SET ds_investimento = 'Ações e Fundos', vl_investimento = 2500.00
WHERE id_investimento = 1 AND id_usuario_cpf = 1;
