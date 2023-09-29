package com.airport.circulararrayqueue;

public class Flight {

    private int flightNumber;
    private String airLine;

    Flight(int flightNum, String airln){
        flightNumber = flightNum;
        airLine = airln;
    }

    public String toString(){
        return "Flight Number #" + flightNumber + " with " + airLine;
    }

}
