package com.sebastian;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sebastian.presentation.Menu;
import com.sebastian.service.TheaterService;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(TheaterService.class);
    public static void main(String[] args) {
        
        logger.info("Starting system");
        Menu menu = new Menu(); 
        menu.showMenu();
        logger.info("Closing system");
         
    }
}