/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author c.bories
 */
public class Salarie {
    int id;
    String nom;
    String prenom;
    String fonction;
    Date date;
    int serviceId;
    String serviceNom;

    public Salarie(int id, String nom,String prenom, String fonction, Date date, int serviceId){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.fonction=fonction;
        this.date=date;
        this.serviceId=serviceId;
        
    }    
    
    public int getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getFonction() {
        return this.fonction;
    }

    public Date getDate() {
        return this.date;
    }

    public int getServiceId() {
        return this.serviceId;
    }
    
    public String getServiceNom(){
        return this.serviceNom;
    }
    
    public void setServiceNom(String serviceNom){
        this.serviceNom=serviceNom;
    }
    
   
    
    }

