package com.mycompany.netbest2;

import java.awt.Color;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.StringProperty;

/**
 *
 * @author domin
 */
public class LogWindow extends javax.swing.JFrame {
       
        LogController log = new LogController();
        UserPanel up = new UserPanel();
        public String login;
        public String pass;
        private boolean flaga;
          private PreparedStatement stmt = null; 
    private ResultSet rs;

    public int zalogowany;
    private Connection conn;
        /**
         * Inicjuje komponenty okna
         */
        public LogWindow() 
        {
        initComponents();
        login = loginText.getText();
        pass = passText.getText();
        
        }
         
        /**
         * Zmienia okno gdy zalogowanie się powiodło lub wyświetla informacje o błędzie jeżeli nie
         */
        /*public void zmiana() throws SQLException, NoSuchAlgorithmException{
            MainWindow zmiana;
            zmiana = new MainWindow();
            if(log.zalogujSie(login, pass)==false)
            {
                
                zmiana.setVisible(true);
                this.setVisible(false);
            }
            else
            {
                System.out.println(log.zalogujSie(login, pass));
                error.setVisible(true);
            }
        }
        
         public void connection() throws SQLException
   {
       conn = DriverManager.getConnection("jdbc:mysql://sql2.freesqldatabase.com/sql2212964", "sql2212964", "tV5!yB5!");
   }
   */
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
     * Logowanie użytkownika do programu
     * @param login
     * @param pass
     * @return 
     * @throws SQLException
     * @throws NoSuchAlgorithmException 
     */
    public void zalogujSie() throws SQLException, NoSuchAlgorithmException
    {

      conn = DriverManager.getConnection("jdbc:mysql://sql2.freesqldatabase.com/sql2212964", "sql2212964", "tV5!yB5!");
      stmt = conn.prepareStatement("SELECT COUNT(login) FROM Users WHERE login = ? and password = ?");
      stmt.setString(1, loginText.getText());
      stmt.setString(2, hashPassword(passText.getText()));
      stmt.executeQuery(); 
      
      rs = stmt.executeQuery( ); 
      while(rs.next()){  
          zalogowany = rs.getInt(1);
          System.out.println(zalogowany);
            }
      if(zalogowany == 1)
      {
          MainWindow zmiana;
            zmiana = new MainWindow();
            zmiana.setVisible(true);
                this.setVisible(false);
            zmiana.uprawnienia(loginText.getText());
      }
      else
      {
          error.setVisible(true);
      }
      
    }
          
     
      
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        NetBest = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        loginText = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        zalogujSieButton = new javax.swing.JPanel();
        zaloguj = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        error = new javax.swing.JLabel();
        passText = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NetBest");
        setMaximumSize(new java.awt.Dimension(300, 375));
        setMinimumSize(new java.awt.Dimension(300, 375));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(300, 375));
        jPanel1.setMinimumSize(new java.awt.Dimension(300, 375));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 375));

        NetBest.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        NetBest.setForeground(new java.awt.Color(207, 6, 46));
        NetBest.setText("NetBest");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(216, 45, 2));
        jLabel3.setText("Login:");

        loginText.setBorder(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(216, 45, 2));
        jLabel4.setText("Hasło:");

        zalogujSieButton.setBackground(new java.awt.Color(255, 255, 255));
        zalogujSieButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        zalogujSieButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zalogujSieButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                zalogujSieButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                zalogujSieButtonMouseExited(evt);
            }
        });

        zaloguj.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        zaloguj.setForeground(new java.awt.Color(207, 6, 46));
        zaloguj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zaloguj.setText("Zaloguj się");
        zaloguj.setToolTipText("");
        zaloguj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zalogujMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                zalogujMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                zalogujMouseExited(evt);
            }
        });

        javax.swing.GroupLayout zalogujSieButtonLayout = new javax.swing.GroupLayout(zalogujSieButton);
        zalogujSieButton.setLayout(zalogujSieButtonLayout);
        zalogujSieButtonLayout.setHorizontalGroup(
            zalogujSieButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zalogujSieButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(zaloguj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        zalogujSieButtonLayout.setVerticalGroup(
            zalogujSieButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, zalogujSieButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(zaloguj)
                .addContainerGap())
        );

        error.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        error.setForeground(new java.awt.Color(207, 6, 46));
        error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        error.setText("Próba logowania nie powiodła się!");
        error.setToolTipText("");

        passText.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3)
                    .addComponent(zalogujSieButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(loginText)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NetBest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passText)
                    .addComponent(jSeparator2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(75, 75, 75))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(NetBest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(zalogujSieButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(error)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void zalogujMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zalogujMouseClicked
            try {
                zalogujSie();
            } catch (SQLException | NoSuchAlgorithmException ex) {
                Logger.getLogger(LogWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_zalogujMouseClicked

    private void zalogujMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zalogujMouseEntered
        zalogujSieButton.setBackground(Color.getHSBColor(0, 0, (float) 0.97));
        // TODO add your handling code here:
    }//GEN-LAST:event_zalogujMouseEntered

    private void zalogujMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zalogujMouseExited
        zalogujSieButton.setBackground(Color.getHSBColor(0, 0, (float) 1));
        // TODO add your handling code here:
    }//GEN-LAST:event_zalogujMouseExited

    private void zalogujSieButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zalogujSieButtonMouseClicked
            try {
                
                zalogujSie();
            } catch (SQLException | NoSuchAlgorithmException ex) {
                Logger.getLogger(LogWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_zalogujSieButtonMouseClicked

    private void zalogujSieButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zalogujSieButtonMouseEntered
        zalogujSieButton.setBackground(Color.getHSBColor(0, 0, (float) 0.97));
        // TODO add your handling code here:
    }//GEN-LAST:event_zalogujSieButtonMouseEntered

    private void zalogujSieButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zalogujSieButtonMouseExited
        zalogujSieButton.setBackground(Color.getHSBColor(0, 0, (float) 1));
        // TODO add your handling code here:
    }//GEN-LAST:event_zalogujSieButtonMouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        error.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(LogWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NetBest;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField loginText;
    private javax.swing.JPasswordField passText;
    private javax.swing.JLabel zaloguj;
    private javax.swing.JPanel zalogujSieButton;
    // End of variables declaration//GEN-END:variables
}
