package com.ratingservice.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="Rating")
public class Rating {
    @Id
    @Column(name="rating_Id")
    private String ratingId;

    @Column(name="user_Id")
    private String userId;

    @Column(name="hotel_Id")
    private String hotelId;

    @Column(name="rating")
    private int rating;

    @Column(name="feedback")
    private String feedback;

    public Rating() {
        this.ratingId = UUID.randomUUID().toString();
    }

    public Rating(String ratingId, String userId, String hotelId, int rating, String feedback) {
        this.ratingId = ratingId;
        this.userId = userId;
        this.hotelId = hotelId;
        this.rating = rating;
        this.feedback = feedback;
    }

    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
