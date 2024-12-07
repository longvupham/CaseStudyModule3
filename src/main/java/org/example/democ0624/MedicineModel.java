package org.example.democ0624;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicineModel {
    private Connection connection;

    public MedicineModel() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PharmacyDB", "root", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Medicine> getAllMedicines() {
        List<Medicine> medicines = new ArrayList<>();
        try {
            String query = "SELECT * FROM Medicines";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                medicines.add(new Medicine(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("manufacturer"),
                        rs.getDouble("price"),
                        rs.getInt("stock")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicines;
    }
}
