package org.example.lab3_2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodsDAO {

    // Додавання нового товару
    public void addGoods(int id, String name, double price) {
        String sql = "INSERT INTO goods (id, name, price) VALUES (?, ?, ?)";
        try (Connection conn = Database_connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setDouble(3, price);
            stmt.executeUpdate();
            System.out.println("Goods added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Отримання товару за ID
    public void getGoodsById(int id) {
        String sql = "SELECT * FROM goods WHERE id = ?";
        try (Connection conn = Database_connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                        ", Price: " + rs.getDouble("price"));
            } else {
                System.out.println("Goods not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Оновлення інформації про товар
    public void updateGoods(int id, String name) {
        String sql = "UPDATE goods SET name = ? WHERE id = ?";
        try (Connection conn = Database_connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Goods updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Отримання всіх товарів
    public void getAllGoods() {
        String sql = "SELECT * FROM goods";
        try (Connection conn = Database_connection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                        ", Price: " + rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Видалення товару за ID
    public void deleteGoods(int id) {
        String sql = "DELETE FROM goods WHERE id = ?";
        try (Connection conn = Database_connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Goods deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
