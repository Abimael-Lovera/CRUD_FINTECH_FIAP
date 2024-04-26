Consultas:
--10. Consultar os dados de um usuário (filtrar a partir do seu código).
SELECT * FROM T_USUARIO WHERE id_usuario_cpf = 1;
--11. Consultar os dados de um único registro de despesa de um  usuário (filtrar a partir do código do usuário e do código da despesa).
SELECT * FROM T_DESPESA WHERE id_despesa = 1 AND id_usuario_cpf = 1;
--12. Consultar os dados de todos os registros de despesas de um  usuário, ordenando-os dos registros mais recentes para os mais antigos (filtrar a partir do seu código).
SELECT * FROM T_DESPESA WHERE id_usuario_cpf = 1 ORDER BY dt_despesa DESC;
--13. Consultar os dados de um único registro de investimento de um  usuário (filtrar a partir do código do usuário e do código de investimento.
SELECT * FROM T_INVESTIMENTO WHERE id_investimento = 1 AND id_usuario_cpf = 1;
--14. Consultar os dados de todos os registros de investimentos de um  usuário, ordenando-os dos registros mais recentes para os mais antigos (filtrar a partir do seu código).
SELECT * FROM T_INVESTIMENTO WHERE id_usuario_cpf = 1 ORDER BY dt_investimento DESC;
--15. Consultar os dados básicos de um usuário, o último investimento registrado e a última despesa registrada (filtrar a partir do código de usuário – consulta necessária para o dashboard. Dica: veja consulta com junções).
SELECT 
    U.nm_usuario,
    U.email,
    I.ds_investimento,
    D.ds_despesa
FROM 
    T_USUARIO U
LEFT JOIN 
    (SELECT * FROM T_INVESTIMENTO WHERE id_usuario_cpf = 1 ORDER BY dt_investimento DESC FETCH FIRST 1 ROWS ONLY) I
ON 
    U.id_usuario_cpf = I.id_usuario_cpf
LEFT JOIN 
    (SELECT * FROM T_DESPESA WHERE id_usuario_cpf = 1 ORDER BY dt_despesa DESC FETCH FIRST 1 ROWS ONLY) D
ON 
    U.id_usuario_cpf = D.id_usuario_cpf
WHERE 
    U.id_usuario_cpf = 1;
