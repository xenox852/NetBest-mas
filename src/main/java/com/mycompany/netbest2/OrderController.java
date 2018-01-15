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
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author domin
 */
public class OrderController {
    private Statement statement;
    private String queryString;
    private PreparedStatement stmt = null; 
    private ResultSet rs;
    private Connection conn;
    private boolean flaga; 
    int numer;
    /**
    * Ustalanie połącczenia
    * @throws SQLException 
    */
    public void connection() throws SQLException    
    {
       conn = DriverManager.getConnection("jdbc:mysql://sql2.freesqldatabase.com/sql2212964", "sql2212964", "tV5!yB5!");
   }  
    
    /**
   * Metoda zwraca aktualna date
   * @return 
   */
    public String currentDateStr()
    {
  String currDate;

  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  java.util.Date date = new java.util.Date();
  currDate = dateFormat.format(date);

  return (currDate);
}
    
    /**
   * Metoda dodaje zamowienie do bazy dnaych
   * @param user
   * @param produkt
   * @param klient
   * @param adres
   * @throws SQLException 
   */
     public void dodajKlienta(String user, String produkt, String klient, String adres) throws SQLException
    {
      connection();
      stmt = conn.prepareStatement("INSERT INTO `sql2212964`.`Orders` (`ID_User`, `ID_Product`, `ID_Client`, `Date`, `Adres`) VALUES (?, ?, ?, ?, ?);");
      stmt.setString(1, user);
      stmt.setString(2, produkt);
      stmt.setString(3, klient);
      stmt.setString(4,  currentDateStr());
      stmt.setString(5, adres);
      stmt.executeUpdate();
      
      
      
    }
    /**
     *
     * @param produkt
     * @param klient
     * @param adres
     * @throws java.sql.SQLException
     */
    public void newFaktura(String produkt, String klient, String adres) throws SQLException
      {
          float cena = 0;
      
      connection();
      stmt = conn.prepareStatement("SELECT Price from Products where Name=?;");
      stmt.setString(1, produkt);
      stmt.executeQuery();       
      rs = stmt.executeQuery();
      while(rs.next())
      {
       cena = rs.getFloat(1);
      }
      stmt = conn.prepareStatement("INSERT INTO `sql2212964`.`Payments` (`ID_Client`, `Adres`, `Data`, `ID_Produkt`, `Brutto`) VALUES (?, ?, ?, ?, ?);");
      stmt.setString(1, klient);
      stmt.setString(2, adres);
      stmt.setString(3,  currentDateStr());
      stmt.setString(4, produkt);
      stmt.setFloat(5, cena);
      stmt.executeUpdate();
          
      }
       
      
      
   
   
     /**
      * Metoda sluzy do usuwania zamowienia
      * @param numer
      * @throws SQLException 
      */
     public void usunZamowienie(String numer) throws SQLException
     {
         connection();
         String deleteSQL = "DELETE FROM Orders WHERE ID_Order = ?";
         PreparedStatement preparedStatement = null;
         preparedStatement = conn.prepareStatement(deleteSQL);
         preparedStatement.setString(1, numer);
         preparedStatement.executeUpdate();
     }
     
     public void updateOrder(String id, String user, String produkt, String klient, String adres) throws SQLException
     {
        conn = DriverManager.getConnection("jdbc:mysql://sql2.freesqldatabase.com/sql2212964", "sql2212964", "tV5!yB5!");
        String updateTableSQL = "UPDATE `sql2212964`.`Orders` SET `ID_User`=?, `ID_Product`=?, `ID_Client`=?, `Adres`=? WHERE  `ID_Order`=?";
        PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
        
        preparedStatement.setString(3, klient);
        preparedStatement.setString(1, user);
        preparedStatement.setString(2, produkt);
        preparedStatement.setString(4, adres);
        preparedStatement.setString(5, id);       
        preparedStatement.executeUpdate();
     }
}
