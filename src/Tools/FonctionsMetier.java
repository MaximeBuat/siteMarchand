/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Entity.Login;
import Entity.stock;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class FonctionsMetier implements IMetier
{
    private ResultSet rs;
    private PreparedStatement ps;
    private Connection maCnx;
    
    @Override
    public Login VerifierIdentifiants(String login, String mdp) {
        Login user = null;
        try {
            
            maCnx = BddAccess.getCnx();
            
            ps = maCnx.prepareStatement("SELECT login, mdp from connexions where login = ? and mdp = ? ");
            ps.setString(1, login);
            ps.setString(2, mdp);
            rs = ps.executeQuery();
            
            if(rs.next()){
                user = new Login(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    @Override
    public Login VerifierLogin(String login) {
        Login user = null;
        try {
            
            maCnx = BddAccess.getCnx();
            
            ps = maCnx.prepareStatement("SELECT login from connexions where login = ?");
            ps.setString(1,login);
            rs = ps.executeQuery();
            
            if(rs.next()){
                user = new Login(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    @Override
    public Login addLogin(String unLogin, String unMdp) {
        Login unUser = null;
        try {
            maCnx = BddAccess.getCnx();
            ps = maCnx.prepareStatement("INSERT INTO connexions (login,mdp) VALUES (?,?);");
            ps.setString(1, unLogin);
            ps.setString(2, unMdp);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unUser;
    }
    
    @Override
    public ArrayList<stock> GetAllStock() {
        ArrayList<stock> lesStocks = new ArrayList<>();
        try {
            maCnx = BddAccess.getCnx();
            ps = maCnx.prepareStatement("SELECT Genre, TypVet, Taille, Couleur, Prix, Quantite FROM stock");
            rs = ps.executeQuery();
            while(rs.next())
            {
                stock med = new stock(rs.getString("Genre"),rs.getString("TypVet"),rs.getString("Taille"),rs.getString("Couleur"),rs.getInt("Prix"),rs.getInt("Quantite"));
                lesStocks.add(med);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesStocks;
    }
    
    @Override
    public stock SetAchat(Object genre,Object typVet ,Object taille ,Object couleur, Object quantite) {
        stock unAchat = null;
        try {
            maCnx = BddAccess.getCnx();
            
            ps = maCnx.prepareStatement("UPDATE stock SET Quantite = Quantite - ? WHERE Genre = ? AND typVet = ? AND Taille = ? AND Couleur = ?");
            ps.setObject(1, quantite);
            ps.setObject(2, genre);
            ps.setObject(3, typVet);
            ps.setObject(4, taille);
            ps.setObject(5, couleur);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unAchat;
    }
    
    @Override
    public stock VerifierAchat(Object genre,Object typVet ,Object taille ,Object couleur, Object quantite) {
        stock unAchat = null;
        try {
            maCnx = BddAccess.getCnx();
            
            ps = maCnx.prepareStatement("SELECT Genre, TypVet, Taille, Couleur, Prix, Quantite FROM stock WHERE Genre = ? AND typVet = ? AND Taille = ? AND Couleur = ? AND Quantite >= ?");
            
            ps.setObject(1, genre);
            ps.setObject(2, typVet);
            ps.setObject(3, taille);
            ps.setObject(4, couleur);
            ps.setObject(5, quantite);
            
            rs = ps.executeQuery();
            if(rs.next()){
                unAchat = new stock(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unAchat;
    }
}
