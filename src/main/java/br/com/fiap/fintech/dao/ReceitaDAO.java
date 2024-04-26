package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.models.Receita;
import br.com.fiap.fintech.models.Receita;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReceitaDAO implements GenericDAO<Receita> {

    private final Connection connection;

    public ReceitaDAO(Connection connection) throws SQLException {
        this.connection = connection;
    }

    @Override
    public Receita create(Receita receita) {
        String query = "INSERT INTO T_Receita(id_receita, id_usuario_cpf, ds_receita, vl_receita, dt_receita) VALUES (?, ?, ?, ?, ?)";
        try (var prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setInt(1, receita.getIdReceita());
            prepareStatement.setInt(2, receita.getIdUsuarioCpf());
            prepareStatement.setString(3, receita.getDescricao());
            prepareStatement.setDouble(4, receita.getValor());
            prepareStatement.setDate(5, Date.valueOf(receita.getData()));
            prepareStatement.execute();
            prepareStatement.close();
            System.out.println("receita cadastrada com sucesso!");

            return receita;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Receita getEntity(int id) {
        String query = "SELECT * FROM T_Receita WHERE id_receita = ?";
        try (var prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setInt(1, id);
            ResultSet rs = prepareStatement.executeQuery();

            if (rs.next()) {
                return new Receita(
                        rs.getInt("id_receita"),
                        rs.getInt("id_usuario_cpf"),
                        rs.getString("ds_receita"),
                        rs.getDouble("vl_receita"),
                        rs.getDate("dt_receita").toLocalDate()
                );
            }
            rs.close();
            prepareStatement.close();
            System.out.println("Receita encontrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Receita!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Receita> getEntitiesAll() throws SQLException {
        List<Receita> receitas = new ArrayList<>();
        String query = "SELECT * FROM T_Receita";
        try (var prepareStatement = connection.prepareStatement(query)) {
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                receitas.add(new Receita(
                        rs.getInt("id_receita"),
                        rs.getInt("id_usuario_cpf"),
                        rs.getString("ds_receita"),
                        rs.getDouble("vl_receita"),
                        rs.getDate("dt_receita").toLocalDate()
                ));
            }
            rs.close();
            prepareStatement.close();
            System.out.println("receitas encontradas com sucesso!");
            return receitas;
        } catch (SQLException e) {
            System.out.println("Erro ao buscar receitas!");
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public Receita update(Receita receita) {
        String query = "UPDATE T_Receita SET id_usuario_cpf = ?, ds_receita = ?, vl_receita = ?, dt_receita = ? WHERE id_receita = ?";
        try (var prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setInt(1, receita.getIdUsuarioCpf());
            prepareStatement.setString(2, receita.getDescricao());
            prepareStatement.setDouble(3, receita.getValor());
            prepareStatement.setDate(4, Date.valueOf(receita.getData()));
            prepareStatement.setInt(5, receita.getIdReceita());
            prepareStatement.execute();
            prepareStatement.close();
            System.out.println("receita atualizada com sucesso!");
            return receita;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar receita!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM T_Receita WHERE id_Receita = ?";
        try (var prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setInt(1, id);
            prepareStatement.execute();
            prepareStatement.close();
            System.out.println("Receita deletada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Receita!");
            e.printStackTrace();
        }
    }
}
