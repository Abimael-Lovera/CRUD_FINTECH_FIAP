--1. Cadastrar os dados do usuário.
INSERT INTO T_USUARIO (nm_usuario, email, telefone, dt_nascimento)
VALUES ('[NOME DO USUÁRIO]', '[EMAIL]', '[TELEFONE]', TO_DATE('[DATA DE NASCIMENTO]', 'YYYY-MM-DD'));
--2. Cadastrar os dados para a conta do usuário.
INSERT INTO T_LOGIN (id_usuario_cpf, tipo, senha)
VALUES ([CÓDIGO DO USUÁRIO], '[TIPO DE LOGIN]', '[SENHA]');
--3. Alterar todos os dados do usuário, utilizando seu código como referência.
UPDATE T_USUARIO
SET nm_usuario = '[NOVO NOME]', email = '[NOVO EMAIL]', telefone = '[NOVO TELEFONE]'
WHERE id_usuario_cpf = [CÓDIGO DO USUÁRIO];
--4. Cadastrar as receitas do usuário.
INSERT INTO T_RECEITA (id_usuario_cpf, ds_receita, vl_receita, dt_receita)
VALUES ([CÓDIGO DO USUÁRIO], '[DESCRIÇÃO DA RECEITA]', [VALOR DA RECEITA], TO_DATE('[DATA DA RECEITA]', 'YYYY-MM-DD'));
--5. Alterar todos os dados das receitas do usuário, utilizando o código como referência.
UPDATE T_RECEITA
SET ds_receita = '[NOVA DESCRIÇÃO]', vl_receita = [NOVO VALOR]
WHERE id_receita = [CÓDIGO DA RECEITA] AND id_usuario_cpf = [CÓDIGO DO USUÁRIO];
--6. Cadastrar as despesas do usuário.
INSERT INTO T_DESPESA (id_usuario_cpf, ds_despesa, vl_despesa, dt_despesa)
VALUES ([CÓDIGO DO USUÁRIO], '[DESCRIÇÃO DA DESPESA]', [VALOR DA DESPESA], TO_DATE('[DATA DA DESPESA]', 'YYYY-MM-DD'));
--7. Alterar todos os dados das despesas do usuário, utilizando o código como referência.
UPDATE T_DESPESA
SET ds_despesa = '[NOVA DESCRIÇÃO]', vl_despesa = [NOVO VALOR]
WHERE id_despesa = [CÓDIGO DA DESPESA] AND id_usuario_cpf = [CÓDIGO DO USUÁRIO];
--8. Cadastrar os dados para investimentos.
INSERT INTO T_INVESTIMENTO (id_usuario_cpf, ds_investimento, vl_investimento, dt_investimento)
VALUES ([CÓDIGO DO USUÁRIO], '[DESCRIÇÃO DO INVESTIMENTO]', [VALOR DO INVESTIMENTO], TO_DATE('[DATA DO INVESTIMENTO]', 'YYYY-MM-DD'));
--9. Alterar todos os dados para investimentos do usuário, utilizando o código como referência.
UPDATE T_INVESTIMENTO
SET ds_investimento = '[NOVA DESCRIÇÃO]', vl_investimento = [NOVO VALOR]
WHERE id_investimento = [CÓDIGO DO INVESTIMENTO] AND id_usuario_cpf = [CÓDIGO DO USUÁRIO];
--10. Consultar os dados de um usuário (filtrar a partir do seu código).
SELECT nm_usuario, email, telefone, dt_nascimento FROM T_USUARIO WHERE id_usuario_cpf = [CÓDIGO DO USUÁRIO];
--11. Consultar os dados de um único registro de despesa de um  usuário (filtrar a partir do código do usuário e do código da despesa).
SELECT ds_despesa, vl_despesa, dt_despesa FROM T_DESPESA WHERE id_despesa = [CÓDIGO DA DESPESA] AND id_usuario_cpf = [CÓDIGO DO USUÁRIO];
--12. Consultar os dados de todos os registros de despesas de um  usuário, ordenando-os dos registros mais recentes para os mais antigos (filtrar a partir do seu código).
SELECT ds_despesa, vl_despesa, dt_despesa FROM T_DESPESA WHERE id_usuario_cpf = [CÓDIGO DO USUÁRIO] ORDER BY dt_despesa DESC;
--13. Consultar os dados de um único registro de investimento de um  usuário (filtrar a partir do código do usuário e do código de investimento.
SELECT ds_investimento, vl_investimento, dt_investimento FROM T_INVESTIMENTO WHERE id_investimento = [CÓDIGO DO INVESTIMENTO] AND id_usuario_cpf = [CÓDIGO DO USUÁRIO];
--14. Consultar os dados de todos os registros de investimentos de um  usuário, ordenando-os dos registros mais recentes para os mais antigos (filtrar a partir do seu código).
SELECT ds_investimento, vl_investimento, dt_investimento FROM T_INVESTIMENTO WHERE id_usuario_cpf = [CÓDIGO DO USUÁRIO] ORDER BY dt_investimento DESC;
--15. Consultar os dados básicos de um usuário, o último investimento registrado e a última despesa registrada (filtrar a partir do código de usuário – consulta necessária para o dashboard. Dica: veja consulta com junções).
SELECT 
    U.nm_usuario,
    U.email,
    I.ds_investimento,
    D.ds_despesa
FROM 
    T_USUARIO U
LEFT JOIN 
    (SELECT * FROM T_INVESTIMENTO WHERE id_usuario_cpf = [CÓDIGO DO USUÁRIO] ORDER BY dt_investimento DESC FETCH FIRST 1 ROWS ONLY) I
ON 
    U.id_usuario_cpf = I.id_usuario_cpf
LEFT JOIN 
    (SELECT * FROM T_DESPESA WHERE id_usuario_cpf = [CÓDIGO DO USUÁRIO] ORDER BY dt_despesa DESC FETCH FIRST 1 ROWS ONLY) D
ON 
    U.id_usuario_cpf = D.id_usuario_cpf
WHERE 
    U.id_usuario_cpf = [CÓDIGO DO USUÁRIO];
