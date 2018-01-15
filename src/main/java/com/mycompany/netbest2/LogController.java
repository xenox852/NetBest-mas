
package com.mycompany.netbest2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Dominik Rogosz
 */
public class LogController
{
    private PreparedStatement stmt = null; 
    private String login;
    private String pass;
    private ResultSet rs;
    public boolean flaga = true;
    public boolean zalogowany;
    private Connection conn;
    public String uprawnienia;
   /**
    * Ustalanie połącczenia
    * @throws SQLException 
    */
  
    
    /**
     * Zwracanie wartości flagi
     * @return 
     */
    public boolean getFlaga()
    {
        return flaga;
    }
    
}