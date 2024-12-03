import java.sql.*;

public class MedicineModel {
    private Connection connection;

    public MedicineModel() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PharmacyDB", "root", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Medicine getMedicineById(int id) {
        try {
            String query = "SELECT * FROM Medicines WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Medicine(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("manufacturer"),
                        rs.getDouble("price"),
                        rs.getInt("stock")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateMedicineStock(int id, int newStock) {
        try {
            String query = "UPDATE Medicines SET stock = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, newStock);
            stmt.setInt(2, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

