/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khang
 */
public class Node {
    Customer cus;
    Boat boat;
    Booking booking;
    Node left;
    Node right;

    public Node(){
    }
    
    public Node(Boat boat,Node p){
        this.boat=boat;
        left = right = null;

    }
    
    public Node(Boat boat){
        this.boat=boat;
        left = right = null;
    }
    
    public Node(Customer cus){
        this.cus= cus;
        left = right = null;
    }
    
    public Node(Booking book){
        this.booking= book;
        left = right = null;
    }
    
}
