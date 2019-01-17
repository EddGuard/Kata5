/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class SelectApp {
    private final List<String> lista;

    public SelectApp(List<String> lista) {
        this.lista = lista;
    }

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
    public void createNewTableEmail() {
        String sql = "CREATE TABLE IF NOT EXISTS EMAIL (\n"
                + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " direccion text NOT NULL);";
        try (Connection conn = this.connect()) {
            Statement stmt = conn.createStatement();
            // Se crea la nueva tabla
            stmt.execute(sql);
            System.out.println("Tabla creada");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void insert(){
        String sql = "INSERT INTO EMAIL(direccion) VALUES(?)";
        try  (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
             for (String string : lista) {
                  pstmt.setString(1,string);
                  pstmt.executeUpdate();
             }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void list(){
        String sqlView = "SELECT * FROM EMAIL";
        try (Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlView)){
            int i = 0;
            while (rs.next()) {
                System.out.println(rs.getString("direccion"));
                i++;
            }   
            System.out.println("Nº de direcciones introducidas en la base de datos: " + i);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

}