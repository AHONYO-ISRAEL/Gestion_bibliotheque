/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entite.Ouvrage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class OuvrageDao {
        public static boolean verifTitre(String titre){
        boolean resultat=false;
        
        
        
      
        
           //Ouvrir connexion
            Connection conn=Connexion.seConnecter();
            String verfSql="select * from ouvrage where titre=?";
            //Initialiser un objet de sql precompilé
            PreparedStatement ps= null;
            try {
                //On prépare la requete 
               ps=conn.prepareStatement(verfSql);
               ps.setString(1, titre);
               
             
            
          
                                    
        } catch (SQLException ex) {
            Logger.getLogger(OuvrageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
     
     //initialiser un table de donnée
     
     ResultSet rs= null;
        try {
            rs=ps.executeQuery();
            if(rs.next()){
            
                resultat= true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OuvrageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
     // libérer le tableau
     if(rs != null){
     
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(OuvrageDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
     
     
      //Fermerla connexion
      
      
            if(conn !=null){
            
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OuvrageDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       return resultat;
     
    } 
        

        public static boolean verifCode(String code){
        boolean resultat=false;
        
        
        
      
        
           //Ouvrir connexion
            Connection conn=Connexion.seConnecter();
            String verfSql="select * from ouvrage where code=?";
            //Initialiser un objet de sql precompilé
            PreparedStatement ps= null;
            try {
                //On prépare la requete 
               ps=conn.prepareStatement(verfSql);
               ps.setString(1, code);
               
             
            
          
                                    
        } catch (SQLException ex) {
            Logger.getLogger(OuvrageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
     
     //initialiser un table de donnée
     
     ResultSet rs= null;
        try {
            rs=ps.executeQuery();
            if(rs.next()){
            
                resultat= true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OuvrageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
     // libérer le tableau
     if(rs != null){
     
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(OuvrageDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
     
     
      //Fermerla connexion
      
      
            if(conn !=null){
            
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OuvrageDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       return resultat;
     
    } 
         public static int saveOuvrage(Ouvrage unOuvrage){
         
           
            int resultat=0;
            
            
         
          
            /*
            0 => Erreur
            1 => Enregistrement effectué avec succès
            2 => titre déja utilisé ou code deja utilise (livre deja dans la base)
            */
            
            if(verifCode(unOuvrage.getCode())== true){
            
            resultat=2;
            }else{
            
            //Ouvrir une connexion
             Connection conn=Connexion.seConnecter();
            
            String insertSQL="INSERT INTO ouvrage(code, titre, nbPage, resume) VALUES(?,?,?,?)";
            
            
            //Initialiser un objet sql précompilé
            PreparedStatement ps= null;
            try {
                //On prépare la requete 
               ps=conn.prepareStatement(insertSQL);
               
               // On initialise les paramètres
            ps.setString(1, unOuvrage.getCode());
            ps.setString(2, unOuvrage.getTitre());
            ps.setInt(3, unOuvrage.getNbPage());
            ps.setString(4, unOuvrage.getResume());
            
            //On exécute la requete
            resultat = ps.executeUpdate();
            
          
                                    
        } catch (SQLException ex) {
            Logger.getLogger(OuvrageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            //Fermer  l'objet
            if(ps !=null){
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OuvrageDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            //Fermerla connexion
            if(conn !=null){
            
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OuvrageDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            }
             return resultat;
                
        }
}
