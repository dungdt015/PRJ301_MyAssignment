/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public abstract class DBContext<T> {
   protected PreparedStatement stm;
   Connection connection;
    public DBContext() {
        try {
            String user = "sa";
            String pass = "1";
            String url = "jdbc:sqlserver://DUNGDT-PC\\SQLEXPRESS:1433;databaseName=Assignment_SU24;encript=true;trustservercertificate=true;";
            Class.forName("com.microsoft.server.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
           
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
       }

    }
    public abstract  ArrayList<T> all();
     public abstract T get(int id);
     public abstract void insert(T model);
      public abstract void update(T model);
       public abstract void delete(T model);
}
