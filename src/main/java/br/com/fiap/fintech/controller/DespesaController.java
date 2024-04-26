package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.DespesaDAO;
import br.com.fiap.fintech.exception.NotFoundEntitiesException;
import br.com.fiap.fintech.infra.ConnectionDB;
import br.com.fiap.fintech.models.Despesa;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class DespesaController {
    public DespesaController() {
    }

    public void iniciarAplicacao() {
        Connection conexao = null;
        try {
            conexao = ConnectionDB.getConnection();
            DespesaDAO despesaDAO = new DespesaDAO(conexao);
            System.out.println("Inicializando criação de Despesas...");
            Despesa despesa1 = new Despesa(1, 111222333, "Conta de Luz", 100.0, LocalDate.of(2021, 4, 7));
            Despesa despesa2 = new Despesa(2, 222333444, "Conta de Água", 50.0, LocalDate.of(2021, 5, 7));
            Despesa despesa3 = new Despesa(3, 333444555, "Conta de Telefone", 80.0, LocalDate.of(2021, 6, 7));
            Despesa despesa4 = new Despesa(4, 444555666, "Conta de Internet", 120.0, LocalDate.of(2021, 7, 7));
            Despesa despesa5 = new Despesa(5, 555666777, "Conta de Gás", 70.0, LocalDate.of(2021, 8, 7));

            despesaDAO.create(despesa1);
            despesaDAO.create(despesa2);
            despesaDAO.create(despesa3);
            despesaDAO.create(despesa4);
            despesaDAO.create(despesa5);
            System.out.println("Despesas criadas com sucesso!");
            System.out.println("Listando Despesas criadas...");
            despesaDAO.getEntitiesAll().forEach(System.out::println);
            if(!despesaDAO.getEntitiesAll().isEmpty()){
                System.out.println("==================DESPESA============================");
                despesaDAO.getEntitiesAll().forEach(System.out::println);
                System.out.println("======================================================");
            }else{
                throw new NotFoundEntitiesException("Nenhuma Despesa foi encontrada!");
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
            DespesaDAO despesaDAO = new DespesaDAO(conexao);
            despesaDAO.getEntitiesAll().forEach(despesa -> {
                try {
                    despesaDAO.delete(despesa.getIdDespesa());
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
