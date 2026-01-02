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
        String sql = "INSERT INTO products(name, quantityIn, quantityOut, purchasePrice, salePrice) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, product.getName());
            pst.setInt(2, product.getQuantityIn());
            pst.setInt(3, product.getQuantityOut());
            pst.setDouble(4, product.getPurchasePrice());
            pst.setDouble(5, product.getSalePrice());

            int rows = pst.executeUpdate();
            return rows > 0;

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
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("quantityIn"),
                    rs.getInt("quantityOut"),
                    rs.getDouble("purchasePrice"),
                    rs.getDouble("salePrice")
                );
                products.add(p);
            }

        } catch (SQLException e) {
        }

        return products;
    }
}

