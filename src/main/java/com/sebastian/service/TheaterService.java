package com.sebastian.service;

import com.sebastian.model.Seat;
import com.sebastian.model.SeatStatus;


public class TheaterService {
    private final int ROWS = 10;
    private final int COLUMNS = 6;
    private Seat[][] seats;

    public TheaterService(){
        seats = new Seat[ROWS][COLUMNS];

        for(int i = 0; i < seats.length; i++){
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = new Seat();
            }
        }
    }
    
    public SeatStatus getSeatStatus(int row, int column){

        if((row >ROWS || row < 1|| column < 1 ||column > COLUMNS) ){
            throw new SeatOutOfRangeException("The seat is out of range, can't book");
        }
        
        return seats[row-1][column-1].getStatus();
    }
    public void consult(){
        for (int i = 0; i < seats.length; i++) {
            System.out.println("- - - - - - - - - -");
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print("|" + seats[i][j].getStatus() + "|");
            }
            System.out.println();
        }
    }
  
    public void book(int row, int column){

        if((row >ROWS || row < 1|| column < 1 ||column > COLUMNS) ){
            throw new SeatOutOfRangeException("The seat is out of range, can't book");
        }

        Seat seat = seats[row-1][column-1];

        if(seat.getStatus().equals(SeatStatus.TAKEN)){
            throw new TakenSeatException("The seat's been already taken");
        }

        seat.bookSeat();
    }

    public void cancel(int row, int column){
        if((row >ROWS || row < 1|| column < 1 ||column > COLUMNS)){
            throw new SeatOutOfRangeException("The seat is out of range, can't cancel");
        }

        Seat seat = seats[row-1][column-1];

        if(seat.getStatus().equals(SeatStatus.FREE)){
            throw new FreeSeatException("The seat is free, can't cancel"); 
        }
        seat.cancelSeat();
    }

}
