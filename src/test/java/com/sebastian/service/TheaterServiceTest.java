package com.sebastian.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;


import com.sebastian.model.SeatStatus;

@ExtendWith(MockitoExtension.class)
public class TheaterServiceTest {
   
    private TheaterService service;

    @BeforeEach
    void start(){
        service = new TheaterService();
    }
    @Test
    void book_ValidSeat_ChangesStatusToTaken() {
        service.book(1, 1);
        // Add a getter or use reflection to check seat status
       
        assertEquals(SeatStatus.TAKEN, service.getSeatStatus(1, 1));
    }

    @Test
    void book_InvalidSeat_ThrowsSeatOutOfRangeException(){
        SeatOutOfRangeException ex = assertThrows(SeatOutOfRangeException.class, () -> {
            service.book(0, 1);
        });

        assertThrows(SeatOutOfRangeException.class, () -> {
            service.book(1, 0);
        });

        assertThrows(SeatOutOfRangeException.class, () -> {
            service.book(11, 1);
        });

        assertThrows(SeatOutOfRangeException.class, () -> {
            service.book(1, 7);
        });
        assertTrue(ex.getMessage().equals("The seat is out of range, can't book"));
    }


    @Test
    void cancel_ValidSeat_ChangesSTatutsToFree(){
        service.book(1, 1);

        service.cancel(1, 1);

        assertEquals(SeatStatus.FREE, service.getSeatStatus(1, 1));
    }

    @Test
    void cancel_InvalidSeat_ThrowsSeatOutOfRangeException(){
        SeatOutOfRangeException ex = assertThrows(SeatOutOfRangeException.class, () -> {
            service.cancel(0, 1);
        });

        assertThrows(SeatOutOfRangeException.class, () -> {
            service.cancel(1, 0);
        });

        assertThrows(SeatOutOfRangeException.class, () -> {
            service.cancel(11, 1);
        });

        assertThrows(SeatOutOfRangeException.class, () -> {
            service.cancel(1, 7);
        });

        assertTrue(ex.getMessage().equals("The seat is out of range, can't cancel"));
    }

    @Test
    void cancel_FreeSeat_ThrowsFreeSeatException(){
        FreeSeatException ex = assertThrows(FreeSeatException.class, ()->{
            service.cancel(1, 1);
        });

        assertTrue(ex.getMessage().equals("The seat is free, can't cancel"));
    }
}
