package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.models.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements GenericDAO<Usuario> {

    private final Connection connection;

    public UsuarioDAO(Connection connection) throws SQLException {
        this.connection = connection;
    }

    @Override
    public Usuario create(Usuario usuario) throws SQLException {
        String query = "INSERT INTO T_USUARIO(id_usuario_cpf, nm_usuario, email, telefone, dt_nascimento) VALUES (?, ?, ?, ?, ?)";
        try (var prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setInt(1, usuario.getIdUsuarioCPF());
            prepareStatement.setString(2, usuario.getNome());
            prepareStatement.setString(3, usuario.getEmail());
            prepareStatement.setString(4, usuario.getTelefone());
            prepareStatement.setDate(5, Date.valueOf(usuario.getDataNascimento()));
            prepareStatement.execute();
            prepareStatement.close();
//            connection.close();
            System.out.println("Usuário cadastrado com sucesso!");
            return usuario;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Usuario getEntity(int id) throws SQLException {
        String query = "SELECT * FROM T_USUARIO WHERE id_usuario_cpf = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id_usuario_cpf"),
                        rs.getString("nm_usuario"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        rs.getDate("dt_nascimento").toLocalDate()
                );
            }
            rs.close();
            ps.close();
            System.out.println("Usuário encontrado com sucesso!");
//            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuário!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Usuario> getEntitiesAll() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM T_USUARIO";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usuarios.add(new Usuario(
                        rs.getInt("id_usuario_cpf"),
                        rs.getString("nm_usuario"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        rs.getDate("dt_nascimento").toLocalDate()
                ));
            }
            rs.close();
            ps.close();
//            connection.close();
            return usuarios;
        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuários!");
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public Usuario update(Usuario usuario) throws SQLException {
        String query = "UPDATE T_USUARIO SET nm_usuario = ?, email = ?, telefone = ?, dt_nascimento = ? WHERE id_usuario_cpf = ?";
        try (var prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setString(2, usuario.getEmail());
            prepareStatement.setString(3, usuario.getTelefone());
            prepareStatement.executeUpdate();
            prepareStatement.close();
//            connection.close();
            System.out.println("Usuário atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM T_USUARIO WHERE id_usuario_cpf = ?";
        try (var prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
            prepareStatement.close();
//            connection.close();
            System.out.println("Usuário deletado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
