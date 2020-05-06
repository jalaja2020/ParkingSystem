package com.example.exception;

public class ParkingSpotNotAvalibleException extends RuntimeException
{
    private static final long serialVersionUID = 1L;
 
    public ParkingSpotNotAvalibleException(String message) {
        super(message);
    }
}
