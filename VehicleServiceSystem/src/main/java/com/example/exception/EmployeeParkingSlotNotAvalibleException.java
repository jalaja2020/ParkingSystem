package com.example.exception;

public class EmployeeParkingSlotNotAvalibleException extends RuntimeException
{
    private static final long serialVersionUID = 1L;
 
    public EmployeeParkingSlotNotAvalibleException(String message) {
        super(message);
    }
}
