package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.models.Investimento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvestimentoDAO implements GenericDAO<Investimento> {

    private final Connection connection;

    public InvestimentoDAO(Connection connection) throws SQLException {
        this.connection = connection;
    }

    @Override
    public Investimento create(Investimento investimento) {
        String query = "INSERT INTO T_investimento(id_investimento, id_usuario_cpf, ds_investimento, vl_investimento, dt_investimento) VALUES (?, ?, ?, ?, ?)";
        try (var prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setInt(1, investimento.getIdInvestimento());
            prepareStatement.setInt(2, investimento.getIdUsuarioCpf());
            prepareStatement.setString(3, investimento.getDescricao());
            prepareStatement.setDouble(4, investimento.getValor());
            prepareStatement.setDate(5, Date.valueOf(investimento.getData()));
            prepareStatement.execute();
            prepareStatement.close();
            System.out.println("investimento cadastrada com sucesso!");

            return investimento;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Investimento getEntity(int id) {
        String query = "SELECT * FROM T_investimento WHERE id_investimento = ?";
        try (var prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setInt(1, id);
            ResultSet rs = prepareStatement.executeQuery();

            if (rs.next()) {
                return new Investimento(
                        rs.getInt("id_investimento"),
                        rs.getInt("id_usuario_cpf"),
                        rs.getString("ds_investimento"),
                        rs.getDouble("vl_investimento"),
                        rs.getDate("dt_investimento").toLocalDate()
                );
            }
            rs.close();
            prepareStatement.close();
            System.out.println("investimento encontrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao buscar investimento!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Investimento> getEntitiesAll() throws SQLException {
        List<Investimento> investimentos = new ArrayList<>();
        String query = "SELECT * FROM T_INVESTIMENTO";
        try (var prepareStatement = connection.prepareStatement(query)) {
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                investimentos.add(new Investimento(
                        rs.getInt("id_investimento"),
                        rs.getInt("id_usuario_cpf"),
                        rs.getString("ds_investimento"),
                        rs.getDouble("vl_investimento"),
                        rs.getDate("dt_investimento").toLocalDate()
                ));
            }
            rs.close();
            prepareStatement.close();
            System.out.println("investimentos encontradas com sucesso!");
            return investimentos;
        } catch (SQLException e) {
            System.out.println("Erro ao buscar investimentos!");
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public Investimento update(Investimento entity) {
        String query = "UPDATE T_INVESTIMENTO SET id_usuario_cpf = ?, ds_investimento = ?, vl_investimento = ?, dt_investimento = ? WHERE id_investimento = ?";
        try (var prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setInt(1, entity.getIdUsuarioCpf());
            prepareStatement.setString(2, entity.getDescricao());
            prepareStatement.setDouble(3, entity.getValor());
            prepareStatement.setDate(4, Date.valueOf(entity.getData()));
            prepareStatement.setInt(5, entity.getIdInvestimento());
            prepareStatement.execute();
            prepareStatement.close();
            System.out.println("investimento atualizada com sucesso!");
            return entity;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar investimento!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM T_investimento WHERE id_investimento = ?";
        try (var prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setInt(1, id);
            prepareStatement.execute();
            prepareStatement.close();
            System.out.println("investimento deletada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar investimento!");
            e.printStackTrace();
        }
    }
}
