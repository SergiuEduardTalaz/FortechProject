package persistence;

import business.entities.Hotel;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelDaoPostgresImpl implements HotelDao {
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * from persons");
            while (rs.next()) {
                String cnp = rs.getString("cnp");
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String address = rs.getString(4);
                String phone = rs.getString(5);
                String email = rs.getString(6);
                //String cnp, String firstName, String lastName, String address, String phone, String email)
                Hotel hotel = new Hotel(cnp, firstName, lastName, address, phone, email);
                hotels.add(hotel);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(connection);
        }
        return hotels;
    }

    @Override
    public void updateValues(String cnp, String adress) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement("update hotels set adress = ? where cnp = ?");
            statement.setString(1, adress);
            statement.setString(2, cnp);
            int noOfUpdates = statement.executeUpdate();
            System.out.println("Number of updated records = " + noOfUpdates);
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
    }
}
