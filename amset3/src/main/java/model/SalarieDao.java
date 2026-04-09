/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author c.bories
 */
public class SalarieDao {
    private Connection connexion;

    public SalarieDao() {
        this.connexion = Connexion.getConnexion();
    }

    public ArrayList<Salarie> getAll() {
        try {
            String query = "SELECT * FROM salarie";
            PreparedStatement ps = this.connexion.prepareStatement(query);
            ResultSet res = ps.executeQuery();

            ArrayList<Salarie> salarieList = new ArrayList<Salarie>();

            while (res.next()) {
                int id = res.getInt("id");
                String nom = res.getString("nom");
                String prenom = res.getString("prenom");
                String fonction = res.getString("fonction");
                Date dateNaissance = res.getDate("date_naissance");
                int serviceId = res.getInt("service_id");
                

                salarieList.add(new Salarie(id, nom, prenom, fonction, dateNaissance, serviceId));
                
            }

            return salarieList;
        } catch (SQLException ex) {
            Logger.getLogger(SalarieDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public void insertSalarie(String nom, String prenom, String fonction,Date date,int serviceId) {
        try {
            String query = "insert into salarie( nom, prenom, fonction, date_naissance, service_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = this.connexion.prepareStatement(query);
            ps.setString(1, nom);
            ps.setString(2 , prenom);
            ps.setString(3 , fonction);
            ps.setDate(4, date);
            ps.setInt(5 , serviceId);
            int n = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SalarieDao.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
    public void updateSalarie(int id,String nom, String prenom, String fonction,Date date,int serviceId) {
        try {
            String query = "UPDATE salarie SET nom = ?, prenom = ?, fonction = ?, date_naissance = ?, service_id = ? WHERE id = ?";
            PreparedStatement ps = this.connexion.prepareStatement(query);
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, fonction);
            ps.setDate(4, date);
            ps.setInt(5, serviceId);
            ps.setInt(6, id);
            int n = ps.executeUpdate();
            // n contient l'id généré lors de l'insertion en base
            // ici on le récupère car c'est un insert (inutile dans le cas d'un update ou d'un delete)
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    

