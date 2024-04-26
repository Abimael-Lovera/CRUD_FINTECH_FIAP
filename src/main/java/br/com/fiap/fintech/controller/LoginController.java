package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.LoginDAO;
import br.com.fiap.fintech.exception.ErroDeleteException;
import br.com.fiap.fintech.exception.NotFoundEntitiesException;
import br.com.fiap.fintech.infra.ConnectionDB;
import br.com.fiap.fintech.models.Login;
import br.com.fiap.fintech.models.TipoLoginEnum;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class LoginController {

    public void iniciarAplicacao() {
        Connection conexao = null;
        try {
            conexao = ConnectionDB.getConnection();
            LoginDAO loginDAO = new LoginDAO(conexao);
            System.out.println("Inicializando criação de Usuarios...");
            Login login1 = new Login(1, 111222333, TipoLoginEnum.EMAIL, "1234567", LocalDate.now(), LocalDate.now());
            Login login2 = new Login(2, 222333444, TipoLoginEnum.GOOGLE, "1234567", LocalDate.now(), LocalDate.now());
            Login login3 = new Login(3, 333444555, TipoLoginEnum.APPLE, "1234567", LocalDate.now(), LocalDate.now());
            Login login4 = new Login(4, 444555666, TipoLoginEnum.EMAIL, "1234567", LocalDate.now(), LocalDate.now());
            Login login5 = new Login(5, 555666777, TipoLoginEnum.GOOGLE, "1234567", LocalDate.now(), LocalDate.now());

            loginDAO.create(login1);
            loginDAO.create(login2);
            loginDAO.create(login3);
            loginDAO.create(login4);
            loginDAO.create(login5);
            System.out.println("Usuarios criados com sucesso!");
            System.out.println("Listando Usuarios criados...");

            if(!loginDAO.getEntitiesAll().isEmpty()){
                System.out.println("==================LOGIN============================");
                loginDAO.getEntitiesAll().forEach(System.out::println);
                System.out.println("==========================================================");
            }else{
                throw new NotFoundEntitiesException("Nenhuma tipo de login encontrada");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao criar usuários!");
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
            LoginDAO loginDAO = new LoginDAO(conexao);
            loginDAO.getEntitiesAll().forEach(login -> {
                try {
                    loginDAO.delete(login.getIdLogin());
                } catch (ErroDeleteException e) {
                    System.out.println("Erro ao deletar tipo de login: " + e.getMessage());
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
