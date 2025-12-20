/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Codeur
 */
public class TestConnexion {
     public static void main(String[] args) {
        if (util.DBConnection.getConnection() != null) {
            System.out.println("Connexion OK");
        } else {
            System.out.println("Connexion échouée");
        }
    }
}
