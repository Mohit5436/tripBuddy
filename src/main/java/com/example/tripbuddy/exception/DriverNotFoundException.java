package com.example.tripbuddy.exception;

import com.example.tripbuddy.model.Driver;
import com.example.tripbuddy.repository.DriverRepository;

public class DriverNotFoundException extends RuntimeException{

    public DriverNotFoundException(String message){
        super(message);
    }

}

