/*
*Zachary Zawodny
* Circular Array Queue
*
*
* */

package com.airport.circulararrayqueue;

import java.util.ArrayList;

public class AirportDriver {

    public static ArrayList<ArrayQueue<Flight>> airport = new ArrayList<>();

    public static ArrayQueue<Flight> runway1 = new ArrayQueue<>(3);
    public static ArrayQueue<Flight> runway2 = new ArrayQueue<>(4);

    public static boolean runwayTurn = true;

    public static void main(String[] args){

        airport.add(runway1);
        airport.add(runway2);

        runway1.enqueue(new Flight(451, "American Airlines Airlines"));
        runway1.enqueue(new Flight(1561, "United Airlines Airlines"));
        runway1.enqueue(new Flight(3134, "United Airlines Airlines"));

        runway2.enqueue(new Flight(1134, "Southwest Airlines Airlines"));
        runway2.enqueue(new Flight(1351, "American Airlines Airlines"));
        runway2.enqueue(new Flight(1134, "United Airlines Airlines"));
        runway1.enqueue(new Flight(1234, "Southwest Airlines Airlines"));

        Runway();

    }

    public static void Runway(){

        int takeoffs = runway1.length() + runway2.length();
        System.out.println("Loading Airplane queues...");
        System.out.println("Planes are ready for take off!");


        for (int i = 0; i < takeoffs; i++ ){
            System.out.println("Currently waiting in runways:");
            System.out.println("Runway:1 " + runway1.toString());
            System.out.println("Runway:2 " + runway2.toString() + "\n");
            if (runwayTurn == true && !runway1.isEmpty()) {
                System.out.println(runway1.dequeue() + " Is Taking Off on runway 1 \n");
                runwayTurn = false;
            } else {
                System.out.println(runway2.dequeue() + " Is Taking Off on runway 2 \n");
                runwayTurn = true;
            }
        }

    }


}
