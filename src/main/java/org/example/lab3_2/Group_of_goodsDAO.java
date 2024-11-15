package org.example.lab3_2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Group_of_goodsDAO {

    // Додавання нової групи товарів
    public void addGroupOfGoods(int id, String name, String packagingType) {
        String sql = "INSERT INTO group_of_goods (id, name, packaging_type) VALUES (?, ?, ?)";
        try (Connection conn = Database_connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, packagingType);
            stmt.executeUpdate();
            System.out.println("Group of goods added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Отримання всіх груп товарів
    public void getAllGroupsOfGoods() {
        String sql = "SELECT * FROM group_of_goods";
        try (Connection conn = Database_connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                        ", Packaging Type: " + rs.getString("packaging_type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Отримання групи товарів за ID
    public void getGroupOfGoodsById(int id) {
        String sql = "SELECT * FROM group_of_goods WHERE id = ?";
        try (Connection conn = Database_connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                        ", Packaging Type: " + rs.getString("packaging_type"));
            } else {
                System.out.println("Group of goods not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Оновлення інформації про групу товарів
    public void updateGroupOfGoods(int id, String newName, String newPackagingType) {
        String sql = "UPDATE group_of_goods SET name = ?, packaging_type = ? WHERE id = ?";
        try (Connection conn = Database_connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newName);
            stmt.setString(2, newPackagingType);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            System.out.println("Group of goods updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Видалення групи товарів за ID
    public void deleteGroupOfGoods(int id) {
        String sql = "DELETE FROM group_of_goods WHERE id = ?";
        try (Connection conn = Database_connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Group of goods deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
