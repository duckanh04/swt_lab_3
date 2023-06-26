
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khang
 */
public class Menu {
    public MyList t = new MyList();
    public MyList c= new MyList();
    public MyList b= new MyList();
    public void display() throws IOException{
        int choice1;
        int choice2;
        boolean exitLoop = false; // Thêm biến cờ để kiểm tra điều kiện dừng vòng lặp

        while(!exitLoop){
            System.out.println("0. Exit");
            System.out.println("1. Boat List");
            System.out.println("2. Customer List");
            System.out.println("3. Booking List");
            choice1=Validation.checkInputInteger("Enter your 1st choice: ", 0, 3);
            switch(choice1){
                case 0: {
                    exitLoop = true; // Đặt biến cờ thành true để thoát khỏi vòng lặp
                    break;
                }
                case 1:{
                    System.out.println("=====Boat Manage=====");
                    System.out.println("1.1 Load from file");
                    System.out.println("1.2 Input & insert data");
                    System.out.println("1.3 In-order traverse");
                    System.out.println("1.4 Breadth-first traverse");
                    System.out.println("1.5 In-order traverse to file");
                    System.out.println("1.6 Search by pcode");
                    System.out.println("1.7 Delete by pcode by copying");
                    System.out.println("1.8 Simply balancing");
                    System.out.println("1.9 Count number of boats");
                    choice2=Validation.checkInputInteger("Enter your 2nd choice: ", 1, 9);
                    switch(choice2){
                        case 1:{
                            loadBoat();
                            break;
                        }
                        case 2:{
                            inputBoat();
                            break;
                        }
                        case 3:{
                            inorderTraverse(t);
                            break;
                        }
                        case 4:{
                            bfTraverse(t);
                            break;
                        }
                        case 5:{
                            t.inorderTraverseToFile();
                            break;
                        }
                        case 6:{
                            searchBoat();
                            break;
                        }
                        case 7:{
                            deleteByCode(t);
                            break;
                        }
                        case 8:{
                            balance(t);
                            break;
                        }
                        case 9:{
                            countBook(t);
                            break;
                        }
                    }
                    break;
                }
                case 2:{
                    System.out.println("====Customer Manage====");
                    System.out.println("2.1 Load from file");
                    System.out.println("2.2 Inptut and add to the end");
                    System.out.println("2.3 Display data");
                    System.out.println("2.4 Save customer list to file");
                    System.out.println("2.5 Search by code");
                    System.out.println("2.6 Delete by code");
                    choice2=Validation.checkInputInteger("Enter your 2nd choice: ", 1, 6);
                    switch(choice2){
                        case 1:{
                            loadCustomer();
                            break;
                        }
                        case 2:{
                            inputCustomer();
                            c.print(2);
                            break;
                        }
                        case 3:{
                            System.out.println("Code  | Name | Phone");
                            System.out.println("---------------------");
                            c.print(2);
                            break;
                        }
                        case 4:{
                            break;
                        }
                        case 5:{
                            searchCustomer();
                            break;
                        }
                        case 6:{
                            deleteCustomer();
                            break;
                        }
                    }
                    break;
                }
                case 3:{
                    System.out.println("====Booking Management====");
                    System.out.println("3.1 Input and add if valid");
                    System.out.println("3.2 Display booking data");
                    System.out.println("3.3 Sort by bcode and ccode");
                    choice2= Validation.checkInputInteger("Enter your 2nd choice: ", 1, 3);
                    switch(choice2){
                        case 1:{
                            inputBooking();
                            break;
                        }
                        case 2:{
                            b.print(3);
                            break;
                        }
                        case 3:{
                            b.sortByCodeBooking();
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }
    
    public void loadBoat()throws IOException{
        String choice;
        String file;
        file=Validation.checkInputString("Enter file name (boat.txt): ");
        if(file.equals("boat.txt")){
            if(t.isEmpty()){
                t.loadFileBoat(file);
            }else{
                choice=Validation.checkInputYN("Do you want to clear the train list ? 'y' or 'n' ");
                if(choice.equals("n")){
                    t.loadFileBoat(file);
                }else{
                    t.clear();
                    t.loadFileBoat(file);
                }
            }
        }
    }
    
    public void loadCustomer()throws IOException{
        String choice;
        String file;
        file=Validation.checkInputString("Enter file name (customer.txt): ");
        if(file.equals("customer.txt")){
            if(c.isEmpty()){
                c.loadFileCustomer(file);
            }else{
                choice=Validation.checkInputYN("Do you want to clear the customer list ? 'y' or 'n' ");
                if(choice.equals("n")){
                    c.loadFileCustomer(file);
                }else{
                    c.clear();
                    c.loadFileCustomer(file);
                }
            }
        }
    }
    
    public void inputBoat(){
        String code;
        Node cond;
        while(true){
            code= Validation.checkInputString("Enter Boat code: ");
            cond=t.getNodebyCode(code,1);
        if(cond==null){
            break;
        }else{
            System.out.println("Boat code must not be duplicated");
        }
        }
        String name= Validation.checkInputString("Enter boat name: ");
        int seat= Validation.checkInputInteger("Enter Boat seat: ", 1, Integer.MAX_VALUE);
        
        int booked;
        while(true){
            booked= Validation.checkInputInteger("Enter booked: ", 0, Integer.MAX_VALUE);
            if(booked>seat){
                System.out.println("Booked must be < seats");
            }else{
                break;
            }
        }
        
        double rate= Validation.checkInputDouble("Enter depart rate: ", 0, Double.MAX_VALUE);
        String place=Validation.checkInputString("Enter depart place: ");
        t.insert(new Boat(code, name, seat, booked,place,rate));
        
    
    }
    
    public void searchBoat(){
        Node cond;
        String code;
        code=Validation.checkInputString("Enter Boat code to be searched: ");
        cond=t.getNodebyCode(code,1);
        if(cond==null){
            System.out.println("NOT FOUND");
        }else{
            System.out.println("FOUND");
        }
    }
    
    public void deleteBoat(){
        Node cond;
        String code;
        while(true){
            code=Validation.checkInputString("Enter boat code to be deleted: ");
            cond=t.getNodebyCode(code,1);
            if(cond==null){
                System.out.println("The code must exist in the boat list");
            }else{
                break;
            }
        }
        t.delete(code,1);
    }
    
    public void deleteBoatBefore(){
        Node cond;
        String code;
        while(true){
            code=Validation.checkInputString("Enter boat code : ");
            cond=t.getNodebyCode(code,1);
            if(cond==null){
                System.out.println("The code must exist in the boat list");
            }else{
                break;
            }
        }
        t.deleteBefore(code);
    }
    
    public void inputCustomer(){
        Node cond;
        String code;
        while(true){
            code= Validation.checkInputString("Enter customer code: ");
            cond=c.getNodebyCode(code, 2);
            if(cond==null){
                break;
            }else{
                System.out.println("Customer code must not be deplicated");
            }
        }
        String name;
        name= Validation.checkInputString("Enter customer name: ");
        String phone;
        phone= Validation.checkInputString("Enter customer phone");
        c.addToTailCus(new Customer(code, name, phone));
    }
    
    public void searchCustomer(){
        Node cond;
        String code;
        code=Validation.checkInputString("Enter customer code to be searched: ");
        cond=c.getNodebyCode(code,2);
        if(cond==null){
            System.out.println("NOT FOUND");
        }else{
            System.out.println("FOUND");
        }
    }
    
    public void deleteCustomer(){
        Node cond;
        String code;
        while(true){
            code=Validation.checkInputString("Enter customer to be deleted: ");
            cond=c.getNodebyCode(code,2);
            if(cond==null){
                System.out.println("The code must exist in the boat list");
            }else{
                break;
            }
        }
        t.delete(code,2);
    }
    
    public void inputBooking(){
        String bCode;
        String cCode;
        int seat;
        Node bCond;
        Node cCond;
        Node bBook;
        Node cBook;
        while(true){
            bCode=Validation.checkInputString("Enter boat code: ");
            cCode=Validation.checkInputString("Enter customer code: ");
            bCond=t.getNodebyCode(bCode, 1);
            cCond=c.getNodebyCode(cCode, 2);
            cBook=b.getNodebyCode(cCode, 3);
            bBook=b.getNodebyCode(bCode, 4);
            if(bCond==null || cCond==null){
                System.out.println("Customer and Boat code must exist");
            }else if(bBook!= null && cBook!= null){
                System.out.println("Both Customer and Boat code are found in the booking list");
            }else{
                if(bCond.boat.getAvailSeat()==0){
                    System.out.println("This boat is out of seats");
                }else{
                    while(true){
                        seat=Validation.checkInputInteger("How many seats do you want to book?", 0, Integer.MAX_VALUE);
                        if(bCond.boat.getAvailSeat()<=seat){
                            break;
                        }else{
                            System.out.println("Not enough availie seats");
                        }
                    }
                    break;
                }
            }
        }
        
        System.out.println("Booking is successfull !!");
    }
    
    public static void inorderTraverse(MyList bt) {
        bt.inorder(bt.head);
    }

    private void bfTraverse(MyList bt) {
        bt.bfs(bt.head);    }

    public void searchByCode(MyList bt) {
        System.out.println("Enter a code: ");
        String code = Validation.checkInputString1();
        Node n = MyList.search(bt.head, code);
        if (n == null) {
            System.out.println("Not found");
        } else {
            System.out.println(n.boat);
        }
    }

    private void deleteByCode(MyList bt) {
        System.out.println("Enter a code: ");
        String code = Validation.checkInputString1();
        bt.deleByCopy(code);    
    }

    private void balance(MyList bt) {
            bt.bal();    
    }

    private void countBook(MyList bt) {
        int node = bt.countNode();
        System.out.println("Number of books : " + node);
    }



}
