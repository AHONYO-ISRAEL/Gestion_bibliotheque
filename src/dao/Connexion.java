/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Connexion {
    public static Connection seConnecter(){
    
        try {
            //chargement du driver de JBDC

            Class.forName("com.mysql.cj.jdbc.Driver" );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url= "jdbc:mysql://localhost:3306/bd_biblio";
        String user="root";
        String pwd="";
        
        
        try {
            Connection con=DriverManager.getConnection(url, user, pwd);
            //JOptionPane.showMessageDialog(null, "Connexion réussie");
            return con;
            
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    }
}
