package com.sebastian.presentation;

import java.util.Scanner;

import com.sebastian.service.TheaterService;

public class Menu {
    private TheaterService service;
    private Scanner sc;

    public void showMenu(){
        service = new TheaterService();
        sc = new Scanner(System.in);

        int decision = 0;
        int row = 0; 
        int column = 0; 

        do{
            System.out.println("Select one option:\n1. Consult theater seats\n2. Book seat\n3.Cancel booked seat\n4. Exit");
            decision = sc.nextInt();
            sc.nextLine(); //buffer cleaning
            switch (decision) {
                case 1:
                    service.consult();
                    break;
                case 2:
                    System.out.println("Give me the row for booking");
                    row = Integer.valueOf(sc.nextLine());
                    System.out.println("Give me the column booking");
                    column = Integer.valueOf(sc.nextLine());
                    service.book(row, column);
                    break;
                case 3:
                    System.out.println("Give me the row cancel");
                    row = Integer.valueOf(sc.nextLine());
                    System.out.println("Give me the column cancel");
                    column = Integer.valueOf(sc.nextLine());
                    service.cancel(row, column);
                    break;

                case 4:
                    System.out.println("Exiting menu, bye!");
                    break;

                default:
                    break;
            }
        }while(decision != 4);
    }
}
