package com.example.exception;

public class EmployeeNotAvalibleException extends RuntimeException
{
    private static final long serialVersionUID = 1L;
 
    public EmployeeNotAvalibleException(String message) {
        super(message);
    }
}
