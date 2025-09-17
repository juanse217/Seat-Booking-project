package com.sebastian.service;

public class TakenSeatException extends RuntimeException{
    public TakenSeatException(String message){
        super(message);
    }
}
