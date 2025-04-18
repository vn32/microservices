package com.hotelServices.services.Impl;

import com.hotelServices.entities.Hotel;
import com.hotelServices.exceptions.ResourceNotFoundException;
import com.hotelServices.repositories.HotelRepository;
import com.hotelServices.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository repository;

    @Override
    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return repository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return repository.findAll();
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        return repository.findById(hotelId).orElseThrow(() ->new ResourceNotFoundException("Hotel not found with id " + hotelId));
    }
}
