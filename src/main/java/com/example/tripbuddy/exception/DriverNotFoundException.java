package com.example.tripbuddy.exception;



public class DriverNotFoundException extends RuntimeException{

    public DriverNotFoundException(String message){
        super(message);
    }

}

