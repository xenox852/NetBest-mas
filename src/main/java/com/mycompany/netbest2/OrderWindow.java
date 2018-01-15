/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.netbest2;

import java.awt.Color;
import java.awt.print.PrinterException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author domin
 */
public class OrderWindow extends javax.swing.JFrame {
    
    Connection conn;
    PreparedStatement stmt = null;
    ResultSet rs;
    int selectedRowIndex;
    Statement statement;
    String queryString;
    String login;
    OrderController oc = new OrderController();
    String adres;
    public OrderWindow() {
        initComponents();
    }

    /**
     * Metoda do odswiezania zawartosci tabeli
     * @throws SQLException
     * @throws NoSuchAlgorithmException 
     */
    public void odswiez() throws SQLException, NoSuchAlgorithmException{
        
        
        for(int i=0;i<37;i++){
              userTable.getModel().setValueAt(" ", i, 0);
              userTable.getModel().setValueAt(" ", i, 1);
              userTable.getModel().setValueAt(" ", i, 2);
              userTable.getModel().setValueAt(" ", i, 3);
              userTable.getModel().setValueAt(" ", i, 4);
               userTable.getModel().setValueAt(" ", i, 5);
              userTable.getModel().setValueAt(" ", i, 6);
              userTable.getModel().setValueAt(" ", i, 7);
              }

        try{
              
              conn = DriverManager.getConnection("jdbc:mysql://sql2.freesqldatabase.com/sql2212964", "sql2212964", "tV5!yB5!");
              queryString = "select Orders.ID_Order, Users.Login, Clients.Name, Clients.Lastname, Orders.Adres, Orders.Date, Products.Name, Products.Price from Clients\n" +
"join Orders on Clients.Pesel = Orders.ID_Client\n" +
"join Products on Orders.ID_Product = Products.Name\n" +
"join Users on Orders.id_user = Users.login;";
              statement= conn.createStatement();
              rs = statement.executeQuery(queryString);
            for(int i=0;rs.next();i++){
              userTable.getModel().setValueAt(rs.getString("Orders.ID_Order"), i, 0);
              userTable.getModel().setValueAt(rs.getString("Users.Login"), i, 1);
              userTable.getModel().setValueAt(rs.getString("Clients.Name"), i, 2);
              userTable.getModel().setValueAt(rs.getString("Clients.Lastname"), i, 3);
              userTable.getModel().setValueAt(rs.getString("Orders.Adres"), i, 4);
              userTable.getModel().setValueAt(rs.getString("Orders.Date"), i, 5);
              userTable.getModel().setValueAt(rs.getString("Products.Name"), i, 6);
              userTable.getModel().setValueAt(rs.getString("Products.Price"), i, 7);
              }
       }
       catch(Exception e){
           e.printStackTrace();
              }
    }

    /**
     * Metoda wypełnia produkty z bazy danych
     * @param jaki
     * @throws SQLException 
     */
    public void combo1(int jaki) throws SQLException{

      conn = DriverManager.getConnection("jdbc:mysql://sql2.freesqldatabase.com/sql2212964", "sql2212964", "tV5!yB5!");
      stmt = conn.prepareStatement("SELECT Name FROM Products");
      stmt.executeQuery();       
      rs = stmt.executeQuery( ); 
      while(rs.next()){  
           if(jaki==1){jComboBox1.addItem(rs.getString(1));}
          if(jaki==2){jComboBox4.addItem(rs.getString(1));
   
      }
   }
   
    
}
    
    /**
     * Metoda wypełnia pole login z bazy dnaych
     * @param jaki
     * @throws SQLException 
     */
    public void combo2(int jaki) throws SQLException{
      conn = DriverManager.getConnection("jdbc:mysql://sql2.freesqldatabase.com/sql2212964", "sql2212964", "tV5!yB5!");
      stmt = conn.prepareStatement("SELECT Login FROM Users");
      stmt.executeQuery();       
      rs = stmt.executeQuery( ); 
      while(rs.next()){  
          if(jaki==1){jComboBox2.addItem(rs.getString(1));}
          if(jaki==2){jComboBox5.addItem(rs.getString(1));
      }
   }}

    /**
     * Metoda wypełnia pesel kilenta z bazy danych
     * @param jaki
     * @throws SQLException
     */
    public void combo3(int jaki) throws SQLException{

      conn = DriverManager.getConnection("jdbc:mysql://sql2.freesqldatabase.com/sql2212964", "sql2212964", "tV5!yB5!");
      stmt = conn.prepareStatement("SELECT Pesel FROM Clients");
      stmt.executeQuery();       
      rs = stmt.executeQuery( ); 
      while(rs.next()){  
          if(jaki==1){jComboBox3.addItem(rs.getString(1));}
          if(jaki==2){jComboBox6.addItem(rs.getString(1));}
      }
}
    
    
     
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addOrder = new javax.swing.JDialog();
        jPanel45 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jSeparator75 = new javax.swing.JSeparator();
        jLabel102 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jLabel103 = new javax.swing.JLabel();
        jSeparator77 = new javax.swing.JSeparator();
        ulText = new javax.swing.JTextField();
        jSeparator78 = new javax.swing.JSeparator();
        jLabel105 = new javax.swing.JLabel();
        jSeparator79 = new javax.swing.JSeparator();
        domText = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        jSeparator80 = new javax.swing.JSeparator();
        kodText = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        miejscowoscText = new javax.swing.JTextField();
        jSeparator81 = new javax.swing.JSeparator();
        jLabel108 = new javax.swing.JLabel();
        bladText3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel104 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        czyUsun = new javax.swing.JDialog();
        jPanel8 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        updateOrder = new javax.swing.JDialog();
        jPanel47 = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jSeparator76 = new javax.swing.JSeparator();
        jLabel111 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        jSeparator83 = new javax.swing.JSeparator();
        ulText1 = new javax.swing.JTextField();
        jSeparator84 = new javax.swing.JSeparator();
        jLabel113 = new javax.swing.JLabel();
        jSeparator85 = new javax.swing.JSeparator();
        domText1 = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        jSeparator86 = new javax.swing.JSeparator();
        kodText1 = new javax.swing.JTextField();
        jLabel115 = new javax.swing.JLabel();
        miejscowoscText1 = new javax.swing.JTextField();
        jSeparator87 = new javax.swing.JSeparator();
        jLabel116 = new javax.swing.JLabel();
        bladText4 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel117 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        NetBest = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();

        addOrder.setTitle("NetBest");
        addOrder.setMaximumSize(new java.awt.Dimension(390, 550));
        addOrder.setMinimumSize(new java.awt.Dimension(390, 550));
        addOrder.setResizable(false);

        jPanel45.setBackground(new java.awt.Color(255, 255, 255));
        jPanel45.setMinimumSize(new java.awt.Dimension(390, 550));
        jPanel45.setRequestFocusEnabled(false);

        jLabel100.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(207, 6, 46));
        jLabel100.setText("NetBest");

        jLabel101.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(207, 6, 46));
        jLabel101.setText("ID produktu:");

        jLabel102.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(207, 6, 46));
        jLabel102.setText("Pesel klienta:");

        jPanel46.setBackground(new java.awt.Color(255, 255, 255));
        jPanel46.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel46MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel46MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel46MouseExited(evt);
            }
        });

        jLabel103.setBackground(new java.awt.Color(255, 255, 255));
        jLabel103.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(207, 6, 46));
        jLabel103.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel103.setText("Dodaj zamówienie!");
        jLabel103.setToolTipText("");

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator77)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel103)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel103)
                .addGap(18, 18, 18)
                .addComponent(jSeparator77, javax.swing.GroupLayout.DEFAULT_SIZE, 9, Short.MAX_VALUE))
        );

        ulText.setBorder(null);
        ulText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ulTextActionPerformed(evt);
            }
        });

        jLabel105.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(207, 6, 46));
        jLabel105.setText("Ulica:");

        domText.setBorder(null);
        domText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                domTextActionPerformed(evt);
            }
        });

        jLabel106.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(207, 6, 46));
        jLabel106.setText("Numer domu:");

        kodText.setBorder(null);
        kodText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodTextActionPerformed(evt);
            }
        });

        jLabel107.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(207, 6, 46));
        jLabel107.setText("Kod pocztowy:");

        miejscowoscText.setBorder(null);
        miejscowoscText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miejscowoscTextActionPerformed(evt);
            }
        });

        jLabel108.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(207, 6, 46));
        jLabel108.setText("Miejscowość:");

        bladText3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bladText3.setForeground(new java.awt.Color(207, 6, 46));
        bladText3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bladText3.setText("Niepoprawnie uzupełnione pola formularza!");
        bladText3.setToolTipText("");

        jComboBox1.setBorder(null);

        jComboBox2.setBorder(null);

        jLabel104.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(207, 6, 46));
        jLabel104.setText("Sprzedawca:");

        jComboBox3.setBorder(null);

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel100))
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                                    .addComponent(jLabel106)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator79, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(domText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                                    .addComponent(jLabel107)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator80, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(kodText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                                    .addComponent(jLabel108)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator81, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(miejscowoscText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                                    .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel102, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel45Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel104)
                                                    .addComponent(jLabel101))))
                                        .addComponent(jLabel105))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator78, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(ulText)
                                        .addComponent(jComboBox1, 0, 221, Short.MAX_VALUE)
                                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox3, 0, 221, Short.MAX_VALUE))))
                            .addComponent(bladText3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator75, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel100)
                .addGap(34, 34, 34)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel104)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel101)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel102)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ulText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel105))
                .addGap(0, 0, 0)
                .addComponent(jSeparator78, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel106)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addComponent(domText)
                        .addGap(1, 1, 1)))
                .addGap(0, 0, 0)
                .addComponent(jSeparator79, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel107)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addComponent(kodText)
                        .addGap(1, 1, 1)))
                .addGap(0, 0, 0)
                .addComponent(jSeparator80, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel108)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addComponent(miejscowoscText)
                        .addGap(1, 1, 1)))
                .addGap(0, 0, 0)
                .addComponent(jSeparator81, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bladText3)
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel45Layout.createSequentialGroup()
                    .addGap(79, 79, 79)
                    .addComponent(jSeparator75, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(456, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout addOrderLayout = new javax.swing.GroupLayout(addOrder.getContentPane());
        addOrder.getContentPane().setLayout(addOrderLayout);
        addOrderLayout.setHorizontalGroup(
            addOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        addOrderLayout.setVerticalGroup(
            addOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        czyUsun.setTitle("NetBest");
        czyUsun.setMinimumSize(new java.awt.Dimension(400, 200));
        czyUsun.setResizable(false);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(207, 6, 46));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Czy chcesz usunąć zamówienie:");
        jLabel28.setToolTipText("");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel9MouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("TAK");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel2)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel10MouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("NIE");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(67, 67, 67))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(207, 6, 46));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("UWAGA! Ta operacja jest nieodwracalna!");
        jLabel29.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout czyUsunLayout = new javax.swing.GroupLayout(czyUsun.getContentPane());
        czyUsun.getContentPane().setLayout(czyUsunLayout);
        czyUsunLayout.setHorizontalGroup(
            czyUsunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        czyUsunLayout.setVerticalGroup(
            czyUsunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        updateOrder.setTitle("NetBest");
        updateOrder.setMinimumSize(new java.awt.Dimension(485, 550));
        updateOrder.setResizable(false);

        jPanel47.setBackground(new java.awt.Color(255, 255, 255));
        jPanel47.setMinimumSize(new java.awt.Dimension(390, 550));
        jPanel47.setRequestFocusEnabled(false);

        jLabel109.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(207, 6, 46));
        jLabel109.setText("NetBest");

        jLabel110.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(207, 6, 46));
        jLabel110.setText("ID produktu:");

        jLabel111.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(207, 6, 46));
        jLabel111.setText("Pesel klienta:");

        jPanel48.setBackground(new java.awt.Color(255, 255, 255));
        jPanel48.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel48MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel48MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel48MouseExited(evt);
            }
        });

        jLabel112.setBackground(new java.awt.Color(255, 255, 255));
        jLabel112.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(207, 6, 46));
        jLabel112.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel112.setText("Edytuj zamówienie!");
        jLabel112.setToolTipText("");

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator83)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel112)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel112)
                .addGap(18, 18, 18)
                .addComponent(jSeparator83, javax.swing.GroupLayout.DEFAULT_SIZE, 9, Short.MAX_VALUE))
        );

        ulText1.setBorder(null);
        ulText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ulText1ActionPerformed(evt);
            }
        });

        jLabel113.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(207, 6, 46));
        jLabel113.setText("Ulica:");

        domText1.setBorder(null);
        domText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                domText1ActionPerformed(evt);
            }
        });

        jLabel114.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(207, 6, 46));
        jLabel114.setText("Numer domu:");

        kodText1.setBorder(null);
        kodText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodText1ActionPerformed(evt);
            }
        });

        jLabel115.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(207, 6, 46));
        jLabel115.setText("Kod pocztowy:");

        miejscowoscText1.setBorder(null);
        miejscowoscText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miejscowoscText1ActionPerformed(evt);
            }
        });

        jLabel116.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(207, 6, 46));
        jLabel116.setText("Miejscowość:");

        bladText4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bladText4.setForeground(new java.awt.Color(207, 6, 46));
        bladText4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bladText4.setText("Niepoprawnie uzupełnione pola formularza!");
        bladText4.setToolTipText("");

        jComboBox4.setBorder(null);

        jComboBox5.setBorder(null);

        jLabel117.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(207, 6, 46));
        jLabel117.setText("Sprzedawca:");

        jComboBox6.setBorder(null);

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel109))
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                                    .addComponent(jLabel114)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator85, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(domText1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                                    .addComponent(jLabel115)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator86, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(kodText1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                                    .addComponent(jLabel116)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator87, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(miejscowoscText1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                                    .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel111, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel47Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel117)
                                                    .addComponent(jLabel110))))
                                        .addComponent(jLabel113))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator84, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(ulText1)
                                        .addComponent(jComboBox4, 0, 221, Short.MAX_VALUE)
                                        .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox6, 0, 221, Short.MAX_VALUE))))
                            .addComponent(bladText4, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(120, Short.MAX_VALUE))
            .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator76, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel109)
                .addGap(34, 34, 34)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel117)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel110)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel111)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ulText1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel113))
                .addGap(0, 0, 0)
                .addComponent(jSeparator84, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel114)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(domText1)
                        .addGap(1, 1, 1)))
                .addGap(0, 0, 0)
                .addComponent(jSeparator85, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel115)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(kodText1)
                        .addGap(1, 1, 1)))
                .addGap(0, 0, 0)
                .addComponent(jSeparator86, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel116)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(miejscowoscText1)
                        .addGap(1, 1, 1)))
                .addGap(0, 0, 0)
                .addComponent(jSeparator87, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bladText4)
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel47Layout.createSequentialGroup()
                    .addGap(79, 79, 79)
                    .addComponent(jSeparator76, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(456, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout updateOrderLayout = new javax.swing.GroupLayout(updateOrder.getContentPane());
        updateOrder.getContentPane().setLayout(updateOrderLayout);
        updateOrderLayout.setHorizontalGroup(
            updateOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        updateOrderLayout.setVerticalGroup(
            updateOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel47, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NetBest");
        setMaximumSize(new java.awt.Dimension(1000, 630));
        setMinimumSize(new java.awt.Dimension(1000, 630));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        NetBest.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        NetBest.setForeground(new java.awt.Color(207, 6, 46));
        NetBest.setText("NetBest");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(207, 6, 46));
        jLabel10.setText("Dodaj");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel10)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel10)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(207, 6, 46));
        jLabel11.setText("Usuń");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel11)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel11)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(207, 6, 46));
        jLabel12.setText("Modyfikuj");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel12)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel12)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(207, 6, 46));
        jLabel13.setText("Drukuj");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel13)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel13)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Numer zamówienia", "Sprzedawca", "Imie", "Naziwsko", "Adres", "Data zamówienia", "Nazwa produktu", "Cena"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        userTable.setGridColor(new java.awt.Color(255, 255, 255));
        userTable.setMaximumSize(new java.awt.Dimension(375, 816));
        userTable.setMinimumSize(new java.awt.Dimension(375, 816));
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(userTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(329, 329, 329)
                        .addComponent(NetBest, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(NetBest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
       
            try {
            
            combo1(1);
            combo2(1);
            combo3(1);
            
            
            addOrder.setVisible(true);
            bladText3.setVisible(false);
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(OrderWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        jPanel2.setBackground(Color.getHSBColor(0, 0, (float) 0.97));
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited

        jPanel2.setBackground(Color.getHSBColor(0, 0, (float) 1));
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseExited

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        if(login.equals("") || login.equals(" ")){

        }
        else{
            jLabel1.setText((String) userTable.getValueAt(selectedRowIndex, 0));
            czyUsun.setVisible(true);
        }

    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        jPanel3.setBackground(Color.getHSBColor(0, 0, (float) 0.97));
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        jPanel3.setBackground(Color.getHSBColor(0, 0, (float) 1));
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
if(login.equals("") || login.equals(" ")){
    
}
else
{
try {         
            combo1(2);
            combo2(2);
            combo3(2);

            updateOrder.setVisible(true);
            bladText4.setVisible(false);
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(OrderWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
}

        

        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        jPanel4.setBackground(Color.getHSBColor(0, 0, (float) 0.97));
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        jPanel4.setBackground(Color.getHSBColor(0, 0, (float) 1));
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        try{
            MessageFormat header;
            header = new MessageFormat("Tabela zamówień");
            MessageFormat footer;
            footer = new MessageFormat("NetBest");
            userTable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }
        catch(PrinterException e){
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered
        jPanel5.setBackground(Color.getHSBColor(0, 0, (float) 0.97));
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MouseEntered

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited
        jPanel5.setBackground(Color.getHSBColor(0, 0, (float) 1));
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MouseExited

    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMouseClicked
        DefaultTableModel model = (DefaultTableModel)userTable.getModel();
        selectedRowIndex = userTable.getSelectedRow();
        login = (String) userTable.getValueAt(selectedRowIndex, 0);
        // TODO add your handling code here:
    }//GEN-LAST:event_userTableMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        try {
            odswiez();        // TODO add your handling code here:
        } catch (SQLException | NoSuchAlgorithmException ex) {
            Logger.getLogger(OrderWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void jPanel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel46MouseClicked

        if(ulText.getText().equals("")||domText.getText().equals("")||kodText.getText().equals("")||miejscowoscText.getText().equals(""))
        {
            bladText3.setVisible(true);
        }
        else
        {
     try {
         adres = ulText.getText()+" "+domText.getText()+", "+kodText.getText()+" "+miejscowoscText.getText();
         oc.dodajKlienta((String) jComboBox2.getSelectedItem(), (String) jComboBox1.getSelectedItem(), (String) jComboBox3.getSelectedItem(), adres);
         oc.newFaktura((String) jComboBox1.getSelectedItem(), (String) jComboBox3.getSelectedItem(), adres);
         odswiez();
         addOrder.setVisible(false);
     }
     // TODO add your handling code here:
     catch (SQLException | NoSuchAlgorithmException ex) {
         Logger.getLogger(OrderWindow.class.getName()).log(Level.SEVERE, null, ex);
     }
}
    }//GEN-LAST:event_jPanel46MouseClicked

    private void jPanel46MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel46MouseEntered

        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel46MouseEntered

    private void jPanel46MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel46MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel46MouseExited

    private void ulTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ulTextActionPerformed

    private void domTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_domTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_domTextActionPerformed

    private void kodTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodTextActionPerformed

    private void miejscowoscTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miejscowoscTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miejscowoscTextActionPerformed

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
       
        try {
            oc.usunZamowienie(login);
            odswiez();
        } catch (SQLException ex) {
            Logger.getLogger(OrderWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(OrderWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
            czyUsun.setVisible(false);
            
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jPanel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseEntered
        jPanel9.setBackground(Color.getHSBColor(0, 0, (float) 0.98));
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel9MouseEntered

    private void jPanel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseExited
        jPanel9.setBackground(Color.getHSBColor(0, 0, (float) 1));
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel9MouseExited

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked

        czyUsun.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jPanel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseEntered
        jPanel10.setBackground(Color.getHSBColor(0, 0, (float) 0.98));
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseEntered

    private void jPanel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseExited
        jPanel10.setBackground(Color.getHSBColor(0, 0, (float) 1));
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseExited

    private void jPanel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel48MouseClicked

        if(ulText1.getText().equals("")||domText1.getText().equals("")||kodText1.getText().equals("")||miejscowoscText1.getText().equals("")){
            bladText4.setVisible(true);
        }
        else{
            
            try {
                adres = ulText1.getText()+" "+domText1.getText()+", "+kodText1.getText()+" "+miejscowoscText1.getText();
                oc.updateOrder(login, (String) jComboBox5.getSelectedItem(), (String) jComboBox4.getSelectedItem(), (String) jComboBox6.getSelectedItem(), adres);
                System.out.println(login);
                odswiez();
                updateOrder.dispose();
            } catch (SQLException | NoSuchAlgorithmException ex) {
                Logger.getLogger(OrderWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
               
                
           
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel48MouseClicked

    private void jPanel48MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel48MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel48MouseEntered

    private void jPanel48MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel48MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel48MouseExited

    private void ulText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ulText1ActionPerformed

    private void domText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_domText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_domText1ActionPerformed

    private void kodText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodText1ActionPerformed

    private void miejscowoscText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miejscowoscText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miejscowoscText1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrderWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NetBest;
    private javax.swing.JDialog addOrder;
    private javax.swing.JLabel bladText3;
    private javax.swing.JLabel bladText4;
    private javax.swing.JDialog czyUsun;
    private javax.swing.JTextField domText;
    private javax.swing.JTextField domText1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator75;
    private javax.swing.JSeparator jSeparator76;
    private javax.swing.JSeparator jSeparator77;
    private javax.swing.JSeparator jSeparator78;
    private javax.swing.JSeparator jSeparator79;
    private javax.swing.JSeparator jSeparator80;
    private javax.swing.JSeparator jSeparator81;
    private javax.swing.JSeparator jSeparator83;
    private javax.swing.JSeparator jSeparator84;
    private javax.swing.JSeparator jSeparator85;
    private javax.swing.JSeparator jSeparator86;
    private javax.swing.JSeparator jSeparator87;
    private javax.swing.JTextField kodText;
    private javax.swing.JTextField kodText1;
    private javax.swing.JTextField miejscowoscText;
    private javax.swing.JTextField miejscowoscText1;
    private javax.swing.JTextField ulText;
    private javax.swing.JTextField ulText1;
    private javax.swing.JDialog updateOrder;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
