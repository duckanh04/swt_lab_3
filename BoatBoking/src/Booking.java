/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khang
 */
public class Booking {
    private String bcode;
    private String ccode ;
    private int seat;

    public Booking() {
    }

    public Booking(String bcode, String ccode , int seat) {
        this.bcode = bcode;
        this.ccode  = ccode ;
        this.seat = seat;
    }

    public String getBcode() {
        return bcode ;
    }

    public String getCcode () {
        return ccode ;
    }

    public int getSeat() {
        return seat;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Booking{" + "bcode=" + bcode + ", ccode=" + ccode + ", seat=" + seat + '}';
    }
}
