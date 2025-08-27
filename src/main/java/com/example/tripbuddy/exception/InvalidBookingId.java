package com.example.tripbuddy.exception;

public class InvalidBookingId extends RuntimeException{

    public InvalidBookingId(String s){
        super(s);
    }
}
