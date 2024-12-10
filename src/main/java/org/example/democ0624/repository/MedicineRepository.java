package org.example.democ0624.repository;

import org.example.democ0624.model.Medicine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicineRepository implements IMedicineRepository {
    private ConectDatabase conectDatabase;

    public MedicineRepository() {
        this.conectDatabase = new ConectDatabase();
    }

    @Override
    public List<Medicine> getAll() {
        List<Medicine> medicines = new ArrayList<>();
        String query = "SELECT * FROM medicines";
        try (Connection connection = conectDatabase.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                medicines.add(new Medicine(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("manufacturer"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("stock")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicines;
    }

    @Override
    public Medicine getById(int id) {
        String query = "SELECT * FROM medicines WHERE id = ?";
        try (Connection connection = conectDatabase.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Medicine(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("manufacturer"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("stock")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Medicine medicine) {
        String query = "INSERT INTO medicines (name, manufacturer, price, stock) VALUES (?, ?, ?, ?)";
        try (Connection connection = conectDatabase.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, medicine.getName());
            statement.setString(2, medicine.getManufacturer());
            statement.setDouble(3, medicine.getPrice());
            statement.setInt(4, medicine.getStock());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Medicine medicine) {
        String query = "UPDATE medicines SET name = ?, manufacturer = ?, price = ?, stock = ? WHERE id = ?";
        try (Connection connection = conectDatabase.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, medicine.getName());
            statement.setString(2, medicine.getManufacturer());
            statement.setDouble(3, medicine.getPrice());
            statement.setInt(4, medicine.getStock());
            statement.setInt(5, medicine.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM medicines WHERE id = ?";
        try (Connection connection = conectDatabase.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}