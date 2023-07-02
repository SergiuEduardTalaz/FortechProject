package persistence;

import business.entities.Hotel;

import java.util.List;

public interface HotelDao {
    List<Hotel> getAllHotels();

    void updateValues(String cnp, String adress);
}
