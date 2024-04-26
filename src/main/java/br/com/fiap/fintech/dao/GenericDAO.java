package br.com.fiap.fintech.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {
    T create(T entity) throws SQLException;
    T getEntity(int id) throws SQLException;
    List<T> getEntitiesAll() throws SQLException;
    T update(T entity) throws SQLException;
    void delete(int id) throws SQLException;
}
