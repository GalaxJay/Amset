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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author c.perrat
 */
public class ServiceDao {

    private Connection connexion;

    public ServiceDao() {
        this.connexion = Connexion.getConnexion();
    }

    public ArrayList<Service> getAll() {
        try {
            String query = "SELECT * FROM service";
            PreparedStatement ps = this.connexion.prepareStatement(query);
            ResultSet res = ps.executeQuery();

            ArrayList<Service> serviceList = new ArrayList<Service>();

            while (res.next()) {
                int id = res.getInt("id");
                String nom = res.getString("nom");
                int administratif = res.getInt("administratif");

                serviceList.add(new Service(id, nom, administratif));
            }

            return serviceList;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void insertSrv(String nom, int admini) {
        try {
            String query = "INSERT INTO service (nom, administratif) VALUES (?, ?)";
            PreparedStatement ps = this.connexion.prepareStatement(query);
            ps.setString(1, nom);
            ps.setInt(2, admini);
            int n = ps.executeUpdate();
            // n contient l'id généré lors de l'insertion en base
            // ici on le récupère car c'est un insert (inutile dans le cas d'un update ou d'un delete)
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateSrv(int id, String nom, int admini) {
        try {
            String query = "UPDATE service SET nom = ?, administratif = ? WHERE id = ?";
            PreparedStatement ps = this.connexion.prepareStatement(query);
            ps.setString(1, nom);
            ps.setInt(2, admini);
            ps.setInt(3, id);
            int n = ps.executeUpdate();
            // n contient l'id généré lors de l'insertion en base
            // ici on le récupère car c'est un insert (inutile dans le cas d'un update ou d'un delete)
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteSrv(int id) {
        try {
            String query = "DELETE FROM service WHERE id = ?";
            PreparedStatement ps = this.connexion.prepareStatement(query);
            ps.setInt(1, id);
            int n = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNameById(int id) {
         
        try {
            String query = "SELECT nom FROM service WHERE id = ?";
            PreparedStatement ps = this.connexion.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            String serviceName= null;
           
            while (res.next()) {
                
                serviceName = res.getString("nom");
   
            }
            return serviceName;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
