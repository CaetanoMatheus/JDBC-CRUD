package br.com.jdbc.model.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import br.com.jdbc.model.bean.Pessoa;
import br.com.jdbc.model.ConnectionFactory;

public class PessoaDao implements GenericoDao<Pessoa> {


       public int insert(Pessoa pessoa) throws SQLException {
              Connection connection = null;
              try {
                     connection = ConnectionFactory.getInstance().getConnection();
                     PreparedStatement statement = connection.prepareStatement("INSERT INTO `pessoas` "
                             + "(`nome`, `casado`, `sexo`, `data`) VALUES (?, ?, ?, ?)" );
                     statement.setString(1, pessoa.getNome());
                     statement.setBoolean(2, pessoa.isCasado());
                     statement.setString(3, pessoa.getSexo().toString());
                     statement.setDate(4, Date.valueOf(pessoa.getData()));
                     int affectedRows = statement.executeUpdate();
                     statement.close();
                     return affectedRows;

              } catch (SQLException e) {
                     throw new RuntimeException(e.getMessage());
              } finally {
                     if (connection != null) connection.close();
              }
       }

       public ArrayList select() throws SQLException {
              Connection connection = null;
              try {
                     connection = ConnectionFactory.getInstance().getConnection();
                     PreparedStatement statement = connection.prepareStatement("SELECT * FROM `pessoas`");
                     ResultSet resultSet = statement.executeQuery();
                     ArrayList<Pessoa> table = new ArrayList<>();
                     while (resultSet.next()) {
                            table.add(new Pessoa(
                                    resultSet.getInt("id"),
                                    resultSet.getString("nome"),
                                    resultSet.getBoolean("casado"),
                                    resultSet.getString("sexo").charAt(0),
                                    resultSet.getDate("data").toLocalDate()
                            ));
                     }

                     statement.close();
                     resultSet.close();
                     return table;

              } catch (SQLException e) {
                     throw new RuntimeException(e.getMessage());
              } finally {
                     if (connection != null) connection.close();
              }
       }

       public int update(Pessoa pessoa) throws SQLException {
              Connection connection  = null;
              try {
                     connection = ConnectionFactory.getInstance().getConnection();
                     PreparedStatement statement = connection.prepareStatement("UPDATE `pessoas` SET " +
                             "`nome` = ?, `casado` = ?, `sexo` = ?, `data` = ? WHERE `id` = ?");
                     statement.setString(1, pessoa.getNome());
                     statement.setBoolean(2, pessoa.isCasado());
                     statement.setString(3, pessoa.getSexo().toString());
                     statement.setDate(4, Date.valueOf(pessoa.getData()));
                     statement.setInt(5, pessoa.getId());
                     int affectedRows = statement.executeUpdate();
                     statement.close();
                     return affectedRows;

              } catch (SQLException e) {
                     throw new RuntimeException(e.getMessage());
              } finally {
                     if (connection != null) connection.close();
              }
       }

       public int remove(Integer id) throws SQLException {
              Connection connection = null;
              try {
                     connection = ConnectionFactory.getInstance().getConnection();
                     PreparedStatement statement = connection.prepareStatement("DELETE FROM `pessoas` " +
                             "WHERE (`id` = ?)");
                     statement.setInt(1, id);
                     int affectedRows = statement.executeUpdate();
                     statement.close();
                     return affectedRows;

              } catch (SQLException e) {
                     throw new RuntimeException(e.getMessage());
              } finally {
                     if (connection != null) connection.close();
              }
       }
}
