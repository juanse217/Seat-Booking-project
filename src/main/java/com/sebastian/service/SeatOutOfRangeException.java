package com.sebastian.service;

public class SeatOutOfRangeException extends RuntimeException{
    public SeatOutOfRangeException(String message){
        super(message); 
    }
}
