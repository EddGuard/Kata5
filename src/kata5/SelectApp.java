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
    public void selectAll(){
        String sql = "SELECT * FROM PEOPLE";
        try (Connection conn = this.connect();
            java.sql.Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            // Se itera sobre los registros
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + " => " +
                rs.getString("Name") + " => " +
                rs.getString("Apellidos") + " => " +
                rs.getString("Departamento"));
            }   
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}