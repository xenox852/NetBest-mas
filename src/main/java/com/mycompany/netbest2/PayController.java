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
public class PayController {
    private Statement statement;
    private String queryString;
    private PreparedStatement stmt = null; 
    private ResultSet rs;
    private Connection conn;
    private boolean flaga; 
    int numer;
    public void rozliczenie(String id) throws SQLException
    {
         conn = DriverManager.getConnection("jdbc:mysql://sql2.freesqldatabase.com/sql2212964", "sql2212964", "tV5!yB5!");
        String updateTableSQL = "UPDATE `sql2212964`.`Payments` SET `platnosc`=? WHERE `ID_Invoice`=?";
        PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);       
        preparedStatement.setString(1, "zaplacone");
        preparedStatement.setString(2, id);
        preparedStatement.executeUpdate();
    }
}
