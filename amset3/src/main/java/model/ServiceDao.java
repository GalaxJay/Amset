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
            return null;
        }
    }
    
    
}
