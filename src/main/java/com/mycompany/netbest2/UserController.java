/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.netbest2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dominik Rogosz
 */
public class UserController 
{
    private Statement statement;
    private String queryString;
    private PreparedStatement stmt = null; 
    private ResultSet rs;
    private Connection conn;
    private boolean flaga;
    
    /**
     * Hashowanie hasla uzytkownika
     * @param password - haslo uzytkownika do zahashowania
     * @return
     * @throws NoSuchAlgorithmException 
     */
    public String hashPassword(String password) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance("SHA");
        md.update(password.getBytes());
        byte[] b = md.digest();
        StringBuffer sb = new StringBuffer();
        for(byte b1 : b)
        {
            sb.append(Integer.toHexString(b1 & 0xff).toString());
        }
        return sb.toString();
    }
    
    /**
    * Ustalanie połącczenia
    * @throws SQLException 
    */
    public void connection() throws SQLException    
    {
       conn = DriverManager.getConnection("jdbc:mysql://sql2.freesqldatabase.com/sql2212964", "sql2212964", "tV5!yB5!");
   }
    
    /**
     * Dodawanie uzytkownika
     * @param login
     * @param haslo
     * @param pozwolenie
     * @param imie
     * @param nazwisko
     * @throws SQLException
     * @throws NoSuchAlgorithmException 
     */
    public void dodajUser (String login, String haslo, String pozwolenie, String imie, String nazwisko) throws SQLException, NoSuchAlgorithmException
    {
            
   try {
      connection();
      stmt = conn.prepareStatement("INSERT INTO `sql2212964`.`Users` (`Login`, `Password`, `Private`, `Name`, `Lastname`) VALUES (?,?,?,?,?);");
      stmt.setString(1, login);
      stmt.setString(2, hashPassword(haslo));
      stmt.setString(3, pozwolenie);
      stmt.setString(4, imie);
      stmt.setString(5, nazwisko);
      stmt.executeUpdate();
   }
   finally {
      try {
         if (stmt != null) { stmt.close(); }
      }
      catch (Exception e) {
         
      }
      try {
         if (conn != null) { conn.close(); }
      }
      catch (Exception e) {     
      }
   }
    
    
       
}
    
    /**
     * Usuwanie uzytkownika z bazy
     * @param login
     * @throws SQLException 
     */
    public void usunUser(String login) throws SQLException
    {   
        connection();
        System.out.println(login);
        String deleteSQL = "DELETE FROM Users WHERE Login = ?";
        PreparedStatement preparedStatement = null;  
        preparedStatement = conn.prepareStatement(deleteSQL);  
        preparedStatement.setString(1, login);
        preparedStatement.executeUpdate();
    }
    
    /**
     * Sprawdzanie czy dany uzytkownik istnieje
     * @param login
     * @throws SQLException 
     */
    public void czyIstnieje (String login) throws SQLException
    {
                connection();
                stmt = conn.prepareStatement("SELECT COUNT(login) FROM Users WHERE login = ?");
                stmt.setString(1, login);
                stmt.executeQuery();
                ResultSet rs;
                rs = stmt.executeQuery( );
                while(rs.next()){
                flaga = rs.getString(1).equals("1");
                }
    }
    
    /**
     * Zwracanie wartości flagi
     * @return 
     */
    public boolean getFlaga()
    {
        return flaga;
    }
    
    /**
     * Update uzytkownika gdy nie chcemy zmienic hasla
     * @param priv
     * @param name
     * @param lastname
     * @param login
     * @throws SQLException 
     */
    public void updateUser1(String priv, String name, String lastname, String login) throws SQLException
    {               
                    connection();
                    String updateTableSQL = "UPDATE `sql2212964`.`Users` SET `Private`=?, `Name`=?, `Lastname`=? WHERE  `Login`=?";
                    PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
                    preparedStatement.setString(1, priv);
                    preparedStatement.setString(2, name);
                    preparedStatement.setString(3, lastname);
                    preparedStatement.setString(4, login);
                    preparedStatement.executeUpdate();
    }
    
 /**
  * Update uzytkownika gdy chcemy zmienic haslo
  * @param pass
  * @param priv
  * @param name
  * @param lastname
  * @param login
  * @throws SQLException 
     * @throws java.security.NoSuchAlgorithmException 
  */
    public void updateUser2(String pass, String priv, String name, String lastname, String login) throws SQLException, NoSuchAlgorithmException
    {               connection();
                    String updateTableSQL = "UPDATE `sql2212964`.`Users` SET `Password`=?, `Private`=?, `Name`=?, `Lastname`=? WHERE  `Login`=?";
                    PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
                    preparedStatement.setString(1, hashPassword(pass));
                    preparedStatement.setString(2, priv);
                    preparedStatement.setString(3, name);
                    preparedStatement.setString(4, lastname);
                    preparedStatement.setString(5, login);
                    preparedStatement.executeUpdate();
    }
}
