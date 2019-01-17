/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Eduardo
 */
public class SelectApp {

    private Connection connect() {

        String url = "jdbc:sqlite:Kata5.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    @SuppressWarnings("empty-statement")
    public void selectAll(){
        String sql = "DROP TABLE IF EXISTS EMAIL";
        String sql2 = "CREATE TABLE IF NOT EXISTS EMAIL (ID int NOT NULL PRIMARY KEY, EMAIL text NOT NULL)";
        String sql3 = "INSERT INTO EMAIL (ID, EMAIL) VALUES (1, 'test@gmail.com')";
        try (Connection conn = this.connect();
            Statement stmt = conn.createStatement()){
            stmt.execute(sql);
            stmt.execute(sql2);
            stmt.execute(sql3);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        String sqlView = "SELECT * FROM EMAIL";
        try (Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlView)){
            // Se itera sobre los registros
            while (rs.next()) {
                System.out.println(rs.getInt("ID") + " => " +
                rs.getString("EMAIL"));
            }   
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

}