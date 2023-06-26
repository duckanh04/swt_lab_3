/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khang
 */
public class Boat {
    private String bcode;
    private String boat_name;
    private int seat;
    private int booked;
    private double rate;
    private String depart_place;

    
    public Boat() {
    }

    public Boat(String bcode, String boat_name, int seat, int booked, String depart_place, double rate) {
        this.bcode = bcode;
        this.boat_name = boat_name;
        this.seat = seat;
        this.booked = booked;
        this.depart_place = depart_place;
        this.rate = rate;
    }


    public String getBcode() {
        return bcode;
    }

    public String getBoat_name() {
        return boat_name;
    }

    public int getSeat() {
        return seat;
    }

    public int getBooked() {
        return booked;
    }

    public double getRate() {
        return rate;
    }

    public String getDepart_place() {
        return depart_place;
    }
    
    public int getAvailSeat(){
        return seat-booked;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public void setBoat_name(String boat_name) {
        this.boat_name = boat_name;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setDepart_place(String depart_place) {
        this.depart_place = depart_place;
    }

    @Override
    public String toString() {
        return String.format("%-5s | %9s | %5d | %6d | %11.1f | %12s | %10s ",bcode,boat_name,seat,booked,depart_place,rate,getAvailSeat());
    }
}
