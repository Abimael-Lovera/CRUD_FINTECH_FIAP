package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.ReceitaDAO;
import br.com.fiap.fintech.exception.NotFoundEntitiesException;
import br.com.fiap.fintech.infra.ConnectionDB;
import br.com.fiap.fintech.models.Receita;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class ReceitaController {
    public ReceitaController() {
    }

    public void iniciarAplicacao() {
        Connection conexao = null;
        try {
            conexao = ConnectionDB.getConnection();
            ReceitaDAO receitaDAO = new ReceitaDAO(conexao);
            System.out.println("Inicializando criação de Despesas...");
            Receita receita1 = new Receita(1, 111222333, "Salário", 100.0, LocalDate.of(2021, 4, 7));
            Receita receita2 = new Receita(2, 222333444, "Bônus", 50.0, LocalDate.of(2021, 5, 7));
            Receita receita3 = new Receita(3, 333444555, "Freelance", 80.0, LocalDate.of(2021, 6, 7));
            Receita receita4 = new Receita(4, 444555666, "Venda de itens", 120.0, LocalDate.of(2021, 7, 7));
            Receita receita5 = new Receita(5, 555666777, "Salário", 70.0, LocalDate.of(2021, 8, 7));

            receitaDAO.create(receita1);
            receitaDAO.create(receita2);
            receitaDAO.create(receita3);
            receitaDAO.create(receita4);
            receitaDAO.create(receita5);

            System.out.println("Despesas criadas com sucesso!");
            System.out.println("Listando Despesas criadas...");

            if(!receitaDAO.getEntitiesAll().isEmpty()){
                System.out.println("==================RECEITA============================");
                receitaDAO.getEntitiesAll().forEach(System.out::println);
                System.out.println("=======================================================");
            }else{
               throw new NotFoundEntitiesException("Nenhuma despesa encontrada");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao criar despesas: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deletarTodos() {
        Connection conexao = null;
        try {
            conexao = ConnectionDB.getConnection();
           ReceitaDAO receitaDAO = new ReceitaDAO(conexao);
            receitaDAO.getEntitiesAll().forEach(receita -> {
                try {
                    receitaDAO.delete(receita.getIdReceita());
                } catch (Exception e) {
                    System.out.println("Erro ao deletar despesas:" + e.getMessage());
                    e.printStackTrace();
                }
            });
            System.out.println("Todos os usuários foram deletados com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar usuários!");
            e.printStackTrace();
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
