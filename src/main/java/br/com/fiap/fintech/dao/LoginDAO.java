package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.models.Login;
import br.com.fiap.fintech.models.TipoLoginEnum;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO implements GenericDAO<Login> {

    private final Connection connection;

    public LoginDAO(Connection connection) throws SQLException {
        this.connection = connection;
    }

    @Override
    public Login create(Login login) {
        String query = "INSERT INTO T_Login(ID_LOGIN, ID_USUARIO_CPF, TIPO, SENHA, DT_CRIACAO, DT_ULTIMO_ACESSO) VALUES (?, ?, ?, ?, ?, ?)";
        try (var prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setInt(1, login.getIdLogin());
            prepareStatement.setInt(2, login.getIdUsuarioCpf());
            prepareStatement.setString(3, login.getTipo().toString());
            prepareStatement.setString(4, login.getSenha());
            prepareStatement.setDate(5, Date.valueOf(login.getDtCriacao()));
            prepareStatement.setDate(6, Date.valueOf(login.getDtUltimoAcesso()));
            prepareStatement.execute();
            prepareStatement.close();
            System.out.println("login cadastrada com sucesso!");

            return login;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Login getEntity(int id) {
        String query = "SELECT * FROM T_Login WHERE id_Login = ?";
        try (var prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setInt(1, id);
            ResultSet rs = prepareStatement.executeQuery();



            if (rs.next()) {

                return new Login(
                        rs.getInt("ID_LOGIN"),
                        rs.getInt("ID_USUARIO_CPF"),
                        TipoLoginEnum.valueOf(rs.getString("TIPO")),
                        rs.getString("SENHA"),
                        rs.getDate("DT_CRIACAO").toLocalDate(),
                        rs.getDate("DT_ULTIMO_ACESSO").toLocalDate()
                );
            }
            rs.close();
            prepareStatement.close();
            System.out.println("Login encontrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Login!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Login> getEntitiesAll() throws SQLException {
        List<Login> Logins = new ArrayList<>();
        String query = "SELECT * FROM T_LOGIN";
        try (var prepareStatement = connection.prepareStatement(query)) {
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {

                Logins.add(new Login(
                        rs.getInt("ID_LOGIN"),
                        rs.getInt("ID_USUARIO_CPF"),
                        TipoLoginEnum.valueOf(rs.getString("TIPO")),
                        rs.getString("SENHA"),
                        rs.getDate("DT_CRIACAO").toLocalDate(),
                        rs.getDate("DT_ULTIMO_ACESSO").toLocalDate()
                ));
            }
            rs.close();
            prepareStatement.close();
            System.out.println("Logins encontradas com sucesso!");
            return Logins;
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Logins!");
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public Login update(Login Login) {
        String query = "UPDATE T_LOGIN SET TIPO = ?, SENHA = ?, DT_ULTIMO_ACESSO = ? WHERE ID_LOGIN = ?";
        try (var prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setString(1, Login.getTipo().toString());
            prepareStatement.setString(2, Login.getSenha());
            prepareStatement.setDate(3, Date.valueOf(Login.getDtUltimoAcesso()));
            prepareStatement.execute();
            prepareStatement.close();
            System.out.println("Login atualizada com sucesso!");
            return Login;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Login!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM T_Login WHERE ID_LOGIN = ?";
        try (var prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setInt(1, id);
            prepareStatement.execute();
            prepareStatement.close();
            System.out.println("Login deletada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Login!");
            e.printStackTrace();
        }
    }
}
