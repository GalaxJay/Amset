/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author c.perrat
 */
public class Service {
    
    private int id;
    private String nom;
    private int administratif;
    
    public Service(int id, String nom, int administratif) {
        this.id = id;
        this.nom = nom;
        this.administratif = administratif;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int isAdministratif() {
        return administratif;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdministratif(int administratif) {
        this.administratif = administratif;
    }
}
