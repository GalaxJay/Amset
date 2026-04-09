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
    
    public void addSalarie(String nom, String prenom, String fonction,Date date,int serviceId) {
        try {
            String query = "insert into salarie( nom, prenom, fonction, date, serviceId) VALUES (?, ?, ?, ?, ?)";
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
}
    

