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

    public Salarie(int id, String nom,String prenom, String fonction, Date date, int serviceId){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.fonction=fonction;
        this.date=date;
        this.serviceId=serviceId;
    }    
    
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getFonction() {
        return fonction;
    }

    public Date getDate() {
        return date;
    }

    public int getServiceId() {
        return serviceId;
    }
    
    }

