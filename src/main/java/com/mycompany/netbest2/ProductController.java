/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.netbest2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author domin
 */
public class ProductController {
    private Statement statement;
    private String queryString;
    private PreparedStatement stmt = null; 
    private ResultSet rs;
    private Connection conn;
    private boolean flaga;
    
    /**
    * Ustalanie połącczenia
    * @throws SQLException 
    */
    public void connection() throws SQLException    
    {
       conn = DriverManager.getConnection("jdbc:mysql://sql2.freesqldatabase.com/sql2212964", "sql2212964", "tV5!yB5!");
   }
    
    /**
     * sprawdza czy peodukt juz istnieje
     * @param nazwa
     * @return
     * @throws SQLException 
     */
    public boolean czyIstnieje (String nazwa) throws SQLException
    {
        connection();
                stmt = conn.prepareStatement("SELECT COUNT(Name) FROM Users WHERE Name = ?");
                stmt.setString(1, nazwa);
                stmt.executeQuery();
                rs = stmt.executeQuery( );
                while(rs.next()){
                flaga = rs.getString(1).equals("1");
                }
                return flaga;
    }
    
    /**
     * dodaje produkt
     * @param nazwa
     * @param cena
     * @throws SQLException 
     */
    public void dodajProdukt(String nazwa, float cena) throws SQLException
    {
      connection();
      stmt = conn.prepareStatement("INSERT INTO `sql2212964`.`Products` (`Name`, `Price`) VALUES (?,?);");
      stmt.setString(1, nazwa);
      stmt.setFloat(2, cena);
      stmt.executeUpdate();
    }
    
    /**
     * usuwa produkt
     * @param name
     * @throws SQLException 
     */
    public void deleteProduct (String name) throws SQLException
    {
        connection();
        String deleteSQL = "DELETE FROM Products WHERE Name = ?";
        PreparedStatement preparedStatement = null;
        preparedStatement = conn.prepareStatement(deleteSQL);
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
    }
    
    /**
     * Funkcja do modyfikacji produktów
     * @param nazwa
     * @param cena 
     * @param index 
     * @throws java.sql.SQLException 
     */
    public void updateProduct(String nazwa, float cena, String index) throws SQLException
    {
                connection();
                String updateTableSQL = "UPDATE `sql2212964`.`Products` SET `Name`=?, `Price`=? WHERE  `Name`=?";
                PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
                preparedStatement.setString(1, nazwa);
                preparedStatement.setFloat(2, (float) cena);
                preparedStatement.setString(3, index );
                preparedStatement.executeUpdate();  
    }
}
