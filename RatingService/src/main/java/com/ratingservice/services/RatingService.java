package com.ratingservice.services;

import com.ratingservice.entities.Rating;

import java.util.List;
import java.util.Optional;

public interface RatingService {
    public Rating create(Rating rating);
    public List<Rating> getRatingByUserId(String userId);
    public List<Rating> getRatings();
    public List<Rating> getRatingByHotelId(String hotelId);
}
