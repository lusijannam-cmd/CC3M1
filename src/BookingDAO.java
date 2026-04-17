import java.sql.*;
import java.util.ArrayList;

public class BookingDAO {
    public void save(Booking b) {
        String sql = "INSERT INTO bookings (user_name, exhibit_name, booking_date, booking_time, pax, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getUserName());
            ps.setString(2, b.getExhibitName());
            ps.setString(3, b.getDate());
            ps.setString(4, b.getTime());
            ps.setInt(5, b.getPax());
            ps.setString(6, b.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Booking> getAll() {
        ArrayList<Booking> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM bookings")) {
            while (rs.next()) {
                list.add(new Booking.Builder().setId(rs.getInt("id")).setUserName(rs.getString("user_name"))
                        .setExhibitName(rs.getString("exhibit_name")).setDate(rs.getString("booking_date"))
                        .setTime(rs.getString("booking_time")).setPax(rs.getInt("pax"))
                        .setStatus(rs.getString("status")).build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateStatus(int id, String status) {
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement("UPDATE bookings SET status = ? WHERE id = ?")) {
            ps.setString(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}