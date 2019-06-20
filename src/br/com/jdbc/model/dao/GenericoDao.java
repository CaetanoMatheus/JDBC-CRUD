package br.com.jdbc.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface GenericoDao<T> {

       public int insert(T objeto) throws SQLException;

       public ArrayList select() throws SQLException;

       public int update(T objeto) throws SQLException;

       public int remove(Integer id) throws SQLException;
}
