package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.models.Despesa;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DespesaDAO implements GenericDAO<Despesa> {

    private final Connection connection;

    public DespesaDAO(Connection connection) throws SQLException {
        this.connection = connection;
    }

    @Override
    public Despesa create(Despesa despesa) {
        String query = "INSERT INTO T_DESPESA(id_despesa, id_usuario_cpf, ds_despesa, vl_despesa, dt_despesa) VALUES (?, ?, ?, ?, ?)";
        try (var prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setInt(1, despesa.getIdDespesa());
            prepareStatement.setInt(2, despesa.getIdUsuarioCpf());
            prepareStatement.setString(3, despesa.getDescricao());
            prepareStatement.setDouble(4, despesa.getValor());
            prepareStatement.setDate(5, Date.valueOf(despesa.getData()));
            prepareStatement.execute();
            prepareStatement.close();
            System.out.println("Despesa cadastrada com sucesso!");

            return despesa;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Despesa getEntity(int id) {
        String query = "SELECT * FROM T_DESPESA WHERE id_despesa = ?";
        try (var prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setInt(1, id);
            ResultSet rs = prepareStatement.executeQuery();

            if (rs.next()) {
                return new Despesa(
                        rs.getInt("id_despesa"),
                        rs.getInt("id_usuario_cpf"),
                        rs.getString("ds_despesa"),
                        rs.getDouble("vl_despesa"),
                        rs.getDate("dt_despesa").toLocalDate()
                );
            }
            rs.close();
            prepareStatement.close();
            System.out.println("Despesa encontrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao buscar despesa!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Despesa> getEntitiesAll() throws SQLException {
        List<Despesa> despesas = new ArrayList<>();
        String query = "SELECT * FROM T_DESPESA";
        try (var prepareStatement = connection.prepareStatement(query)) {
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                despesas.add(new Despesa(
                        rs.getInt("id_despesa"),
                        rs.getInt("id_usuario_cpf"),
                        rs.getString("ds_despesa"),
                        rs.getDouble("vl_despesa"),
                        rs.getDate("dt_despesa").toLocalDate()
                ));
            }
            rs.close();
            prepareStatement.close();
            System.out.println("Despesas encontradas com sucesso!");
            return despesas;
        } catch (SQLException e) {
            System.out.println("Erro ao buscar despesas!");
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public Despesa update(Despesa despesa) {
        String query = "UPDATE T_DESPESA SET id_usuario_cpf = ?, ds_despesa = ?, vl_despesa = ?, dt_despesa = ? WHERE id_despesa = ?";
        try (var prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setInt(1, despesa.getIdUsuarioCpf());
            prepareStatement.setString(2, despesa.getDescricao());
            prepareStatement.setDouble(3, despesa.getValor());
            prepareStatement.setDate(4, Date.valueOf(despesa.getData()));
            prepareStatement.setInt(5, despesa.getIdDespesa());
            prepareStatement.execute();
            prepareStatement.close();
            System.out.println("Despesa atualizada com sucesso!");
            return despesa;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar despesa!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM T_DESPESA WHERE id_despesa = ?";
        try (var prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setInt(1, id);
            prepareStatement.execute();
            prepareStatement.close();
            System.out.println("Despesa deletada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar despesa!");
            e.printStackTrace();
        }
    }
}
