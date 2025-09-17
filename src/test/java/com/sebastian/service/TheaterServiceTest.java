package com.sebastian.service;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sebastian.model.Seat;

@ExtendWith(MockitoExtension.class)
public class TheaterServiceTest {
    @Mock
    private Seat seat;

    @InjectMocks
    private TheaterService service; 

    
    @Test
    void bookTest(){
        service.book(1, 1);
        verify(seat).bookSeat();
    }
}
