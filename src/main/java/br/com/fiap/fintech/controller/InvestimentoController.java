package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.exception.NotFoundEntitiesException;
import br.com.fiap.fintech.infra.ConnectionDB;
import br.com.fiap.fintech.models.Investimento;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class InvestimentoController {
    public void cadastrarInvestimento() {
    }

    public void iniciarAplicacao() {
        Connection conexao = null;
        try {
            conexao = ConnectionDB.getConnection();
            InvestimentoDAO investimentoDAO = new InvestimentoDAO(conexao);
            System.out.println("Inicializando criação de Despesas...");
            Investimento investimento1 = new Investimento(1, 111222333, "Renda Fixa", 100.0, LocalDate.of(2021, 4, 7));
            Investimento investimento2 = new Investimento(2, 222333444, "CDB Banco", 50.0, LocalDate.of(2021, 5, 7));
            Investimento investimento3 = new Investimento(3, 333444555, "Renda Variavel", 80.0, LocalDate.of(2021, 6, 7));
            Investimento investimento4 = new Investimento(4, 444555666, "CDB Banco", 120.0, LocalDate.of(2021, 7, 7));
            Investimento investimento5 = new Investimento(5, 555666777, "Renda Fixa", 70.0, LocalDate.of(2021, 8, 7));

            investimentoDAO.create(investimento1);
            investimentoDAO.create(investimento2);
            investimentoDAO.create(investimento3);
            investimentoDAO.create(investimento4);
            investimentoDAO.create(investimento5);

            System.out.println("Investimento criadas com sucesso!");
            System.out.println("Listando Despesas criadas...");
            if(!investimentoDAO.getEntitiesAll().isEmpty()){
                System.out.println("==================INVESTIMENTO============================");
                investimentoDAO.getEntitiesAll().forEach(System.out::println);
                System.out.println("============================================================");
            }else{
                throw new NotFoundEntitiesException("Nenhuma Investimento foi encontrada!");
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
            InvestimentoDAO investimentoDAO = new InvestimentoDAO(conexao);
            investimentoDAO.getEntitiesAll().forEach(investimento -> {
                try {
                    investimentoDAO.delete(investimento.getIdInvestimento());
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
