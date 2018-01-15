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
public class ClientsController {
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
     * validacje emailu
     * @param email
     * @return 
     */
    public boolean czyEmail(String email)
    {
        return email.contains("@");
    }
    
    /**
     * validacja peselu
     * @param pesel
     * @return 
     */
    public boolean czyPesel(String pesel)
    {
         int[] wagi = {1, 3, 7, 9, 1, 3, 7 ,9 ,1 ,3};

  // sprawdzamy długość PESEL'a, jeśli nie jest to 11 zwracamy false
  if (pesel.length() != 11) return false;
  
  // zakładamy zmienną będącą sumą kontrolną
  int suma = 0;
  
  // liczymy w pętli sumę kontrolną przemnażając odpowiednie
  // cyfry z PESEL'a przez odpowiednie wagi
  for (int i = 0; i < 10; i++)
     suma += Integer.parseInt(pesel.substring(i, i+1)) * wagi[i];
  
  // pobieramy do zmiennej cyfraKontrolna wartość ostatniej cyfry z PESEL'a   
  int cyfraKontrolna = Integer.parseInt(pesel.substring(10, 11));

  // obliczamy cyfrę kontrolną z sumy (najpierw modulo 10 potem odejmujemy 10 i jeszcze raz modulo 10)
  suma %= 10;
  suma = 10 - suma;
  suma %= 10;
  
  // zwracamy wartość logiczną porównania obliczonej i pobranej cyfry kontrolnej
  return (suma == cyfraKontrolna);
  
    }
    
    /**
     * sprawdzanie czy istnieje juz klient o danym peselu
     * @param pesel
     * @return
     * @throws SQLException 
     */
    public boolean czyIstnieje (String pesel) throws SQLException
    {
                connection();
                stmt = conn.prepareStatement("SELECT COUNT(login) FROM Users WHERE login = ?");
                stmt.setString(1, pesel);
                stmt.executeQuery();
                ResultSet rs;
                rs = stmt.executeQuery( );
                while(rs.next())
                {
                flaga = rs.getString(1).equals("1");
                }
        return flaga;
    }
    
    /**
     * dodawanie klienta
     * @param imie
     * @param naziwsko
     * @param email
     * @param pesel
     * @param sprzedawca
     * @throws SQLException 
     */
    public void addCllent(String imie, String naziwsko, String email, String pesel, String sprzedawca ) throws SQLException
    {
      try {
      connection();
      stmt = conn.prepareStatement("INSERT INTO `sql2212964`.`Clients` (`Login`, `Name`, `Lastname`, `Email`, `Pesel`) VALUES (?,?,?,?,?);");
      stmt.setString(2, imie);
      stmt.setString(3, naziwsko);
      stmt.setString(4, email);
      stmt.setString(5, pesel);
      stmt.setString(1, sprzedawca);
      stmt.executeUpdate();
   }
   finally {
      try {
         if (stmt != null) { stmt.close(); }
      }
      catch (SQLException e) {
         
      }
      try {
         if (conn != null) { conn.close(); }
      }
      catch (SQLException e) {
       
      }
    }
    }
    
    /**
     * metoda usuwa klienta
     * @param pesel
     * @throws SQLException 
     */
    public void usunKlienta(String pesel) throws SQLException
    {
        connection();
        String deleteSQL = "DELETE FROM Clients WHERE Pesel = ?";
        PreparedStatement preparedStatement = null;
        preparedStatement = conn.prepareStatement(deleteSQL);
        preparedStatement.setString(1, pesel);
        preparedStatement.executeUpdate();
    }
    
    /**
     * metoda updateuje klienta
     * @param imie
     * @param nazwisko
     * @param email
     * @param pesel
     * @throws SQLException 
     */
    public void updateClient (String imie, String nazwisko, String email, String pesel) throws SQLException
    {
        connection();
        String updateTableSQL = "UPDATE `sql2212964`.`Clients` SET `Name`=?, `Lastname`=?, `Email`=? WHERE  `Pesel`=?";
        PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
        preparedStatement.setString(1, imie);
        preparedStatement.setString(2, nazwisko);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, pesel);
        preparedStatement.executeUpdate();
    }
}
