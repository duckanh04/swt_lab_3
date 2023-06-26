/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khang
 */
public class Customer {
    
    private String cCode, cName, phone;

    public Customer() {
    }

    public Customer(String cCode, String cName, String phone) {
        this.cCode = cCode;
        this.cName = cName;
        this.phone = phone;
    }

    public String getcCode() {
        return cCode;
    }

    public String getcName() {
        return cName;
    }

    public String getPhone() {
        return phone;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("%5s | %4s | %5s ",cCode,cName,phone);
    }
}

