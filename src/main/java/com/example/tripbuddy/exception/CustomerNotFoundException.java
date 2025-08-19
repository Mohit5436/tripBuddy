package com.example.tripbuddy.exception;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String s){
        super(s);
    }
}
