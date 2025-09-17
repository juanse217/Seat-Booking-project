package com.sebastian.model;

public class Seat {
    private SeatStatus status; 

    public Seat(){
        status = SeatStatus.FREE;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void bookSeat() {
        status = SeatStatus.TAKEN;
    }

    public void cancelSeat() {
        status = SeatStatus.FREE;
    }
}
