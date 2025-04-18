package com.hotelServices.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Hotel not found in hotel service");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
