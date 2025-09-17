package com.sebastian;

import com.sebastian.presentation.Menu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting system: ");
        Menu menu = new Menu(); 
        menu.showMenu();
        System.out.println("Closing system ");
    }
}