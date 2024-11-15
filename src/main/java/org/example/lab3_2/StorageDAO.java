package org.example.lab3_2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StorageDAO {

    // Додавання нового запису до таблиці storage
    public void addStorage(int id, String location, String storageNumber) {
        String sql = "INSERT INTO storage (id, location, storage_number) VALUES (?, ?, ?)";
        try (Connection conn = Database_connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, location);
            pstmt.setString(3, storageNumber);
            pstmt.executeUpdate();
            System.out.println("Storage added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Отримання всіх записів із таблиці storage
    public void getAllStorage() {
        String sql = "SELECT * FROM storage";
        try (Connection conn = Database_connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Location: " + rs.getString("location") +
                        ", Storage Number: " + rs.getString("storage_number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Оновлення запису в таблиці storage за ID
    public void updateStorage(int id, String newLocation) {
        String sql = "UPDATE storage SET location = ?, storage_number = ? WHERE id = ?";
        try (Connection conn = Database_connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newLocation);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Storage updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Видалення запису з таблиці storage за ID
    public void deleteStorage(int id) {
        String sql = "DELETE FROM storage WHERE id = ?";
        try (Connection conn = Database_connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Storage deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
