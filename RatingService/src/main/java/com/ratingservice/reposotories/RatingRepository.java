package com.ratingservice.reposotories;

import com.ratingservice.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface RatingRepository extends JpaRepository<Rating,String> {
    //custom finder methods
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);

}
