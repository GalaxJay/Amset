/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author c.perrat
 */
public class Connexion {
    // Connexion à la base de donnée
    private static String url = "jdbc:mysql://172.28.1.13:3306/amset";
    private static String user = "amset3";
    private static String pass = "amset3";

    private static Connection con = null;

    public static Connection getConnexion() {
        if (con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, pass);
            } catch (Exception ex) {
                Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }
}
