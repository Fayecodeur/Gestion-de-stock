/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import util.DBConnection;

public class ProductDAO {

    // Ajouter un produit
   public boolean addProduct(Product product) {

    String sql = "INSERT INTO products " +
                 "(name, quantity_in, quantity_out, purchase_price, sale_price) " +
                 "VALUES (?, ?, ?, ?, ?)";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setString(1, product.getName());
        pst.setInt(2, product.getQuantityIn());
        pst.setInt(3, product.getQuantityOut());
        pst.setDouble(4, product.getPurchasePrice());
        pst.setDouble(5, product.getSalePrice());

        return pst.executeUpdate() > 0;

    } catch (SQLException e) {
        return false;
    }
}

    // Récupérer tous les produits
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Product p = new Product(
                   rs.getString("name"),
                   rs.getInt("quantity_in"),      
                   rs.getInt("quantity_out"),   
                   rs.getDouble("purchase_price"),
                   rs.getDouble("sale_price") 
                );
                products.add(p);
            }

        } catch (SQLException e) {
        }

        return products;
    }
}

