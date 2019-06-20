package br.com.jdbc.model;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.util.ResourceBundle;

public class ConnectionFactory {

       private static ConnectionFactory connection;
       private static ResourceBundle config;

       private ConnectionFactory() {
              this.config = ResourceBundle.getBundle("br.com.jdbc.model.config");
       }

       public static ConnectionFactory getInstance() {
              if (connection == null) connection = new ConnectionFactory();
              return connection;
       }

       public Connection getConnection() {
              try {
                    Class.forName(config.getString("br.com.jdbc.model.connector.mysql"));
                     return DriverManager.getConnection(config.getString("br.com.jdbc.model.db.connector"),
                             config.getString("br.com.jdbc.model.db.usuario"),
                             config.getString("br.com.jdbc.model.db.senha"));

              } catch (SQLException e) {
                     throw new RuntimeException(e.getMessage());
              } catch (ClassNotFoundException a) {
                     throw new RuntimeException(a.getMessage());
              }
       }
}
