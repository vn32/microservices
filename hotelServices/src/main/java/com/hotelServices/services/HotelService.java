package com.hotelServices.services;

import com.hotelServices.entities.Hotel;

import java.util.List;

public interface HotelService {
    //create
    public Hotel create(Hotel hotel);

    //get all hotels
    public List<Hotel> getAllHotels();

    //get hotle by id
    public Hotel getHotelById(String hotelId);

}
