
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khang
 */
public class MyList {
    Node head,tail;
    private static final String  fname= "boat.txt";

    
    public MyList(){
        head=null;
        tail=null;
    }
    
    public boolean isEmpty(){
        return (head==null);
    }
    
    public Node getNodebyCode(String code,int x){
        Node tmp=head;
        
        if(x==1){ //boat
            while(tmp!=null && !tmp.boat.getBcode().equals(code)){
            tmp=tmp.left;
        }
        }else if(x==2){ //customer
            while(tmp!=null && !tmp.cus.getcCode().equals(code)){
            tmp=tmp.left;
        }
        }else if(x==3){ //booking customer code
            while(tmp!=null && !tmp.booking.getCcode().equals(code)){
            tmp=tmp.left;
        }
        }else if(x==4){ //booking boat code
            while(tmp!=null && !tmp.booking.getBcode().equals(code)){
            tmp=tmp.left;
        }
        }
        return tmp;
    }
    
    public void clear(){
        head=null;
        tail=null;
    }
    
    public void loadFileBoat(String fname) throws IOException { 
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String s;
        String[] a;
        String code;
        String name,place;
        int seat,booked;
        double rate;
        int avail;
        while (true) {
            s = br.readLine();
            if (s == null || s.trim().length() < 5) {
                break;
            }
            a = s.split("[|]");
            code = a[0].trim();
            name = a[1].trim();
            seat = Integer.parseInt(a[2].trim());
            booked = Integer.parseInt(a[3].trim());
            place=a[4].trim();
            rate = Double.parseDouble(a[5].trim());
            avail=Integer.parseInt(a[2].trim())-Integer.parseInt(a[3].trim());
            addTail(new Boat(code, name, seat, booked, place,rate));
        }
        fr.close();
        br.close();
    }
    
    public void loadFileCustomer(String fname) throws IOException { 
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String s;
        String[] a;
        String code;
        String name,phone;
        while (true) {
            s = br.readLine();
            if (s == null || s.trim().length() < 5) {
                break;
            }
            a = s.split("[|]");
            code=a[0].trim();
            name=a[1].trim();
            phone=a[2].trim();
            addToTailCus(new Customer(code, name, phone));
        }
        fr.close();
        br.close();
    }
    
    public void addTail(Boat boat){
        Node tmp = new Node(boat);
        if(isEmpty()){
            head=tmp;
            tail=tmp;
        }else{
            tail.left=tmp;
            tail=tmp;
        }
    }
    
    void insert(Boat x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = p;
            return;
        }
        Node f = null;
        Node q = head;
        while (q != null) {
            if (q.boat.getBcode().equals(x.getBcode())) {
                System.out.println("Insertion failed, duplicated key");
                return;
            } else if (q.boat.getBcode().compareToIgnoreCase(x.getBcode()) > 0) {
                f = q;
                q = q.left;
            } else {
                f = q;
                q = q.right;
            }
        }
        if (f.boat.getBcode().compareToIgnoreCase(x.getBcode()) > 0) {
            f.left = p;
        } else {
            f.right = p;
        }
    }
    
    
    public void deleteFromHead(){
        if(!isEmpty()){
        if(head==tail){
            head = null;
            tail = null;
        }else{
            Node tmp = head.left; 
            head.left = null; 
            head= tmp;
        }
    }
    }
    
    public void delete(String code, int x){
        Node prev =  null;
        Node tmp = head;
        
        if(x==1){
            while(tmp!=null && !tmp.boat.getBcode().equals(code)){
            prev=tmp;
            tmp=tmp.left;
        }
        }else if(x==2){
            while(tmp!=null && !tmp.cus.getcCode().equals(code)){
            prev=tmp;
            tmp=tmp.left;
        }
        }
        
        if(tmp!=null){
            if(tmp == head){
                deleteFromHead();
            }else{
                prev.left=tmp.left;
                tmp.left=null;
                if(tail==tmp){ 
                    tail=prev;
                }
            }
        }
        }
    
    public void sortByCode(){
        Node q=head;
        while(q != tail){
            Node minNode = q;
            Node p=q;
            while(p!=null){
                if(p.boat.getBcode().compareTo(minNode.boat.getBcode())<0){
                    minNode = p;
                }
                p=p.left;
            }
            
            if(q!=minNode){
                Boat tmp = q.boat;
                q.boat=minNode.boat;
                minNode.boat=tmp;
                        
            }
            q=q.left;
        }
    }
    
    public void sortByCodeBooking(){
        Node q=head;
        while(q != tail){
            Node minNode = q;
            Node p=q;
            while(p!=null){
                if(p.booking.getBcode().compareTo(minNode.booking.getBcode())<0){
                    minNode = p;
                }
                p=p.left;
            }
            
            if(q!=minNode){
                Booking tmp = q.booking;
                q.booking=minNode.booking;
                minNode.booking=tmp;
                        
            }
            q=q.left;
        }
        
        q=head;
        while(q != tail){
            if(q.booking.getCcode().equals(q.left.booking.getCcode())){
                if(q.booking.getCcode().compareTo(q.left.booking.getCcode())<0){
                    Booking tmp= q.booking;
                    q.booking=q.left.booking;
                    q.left.booking=tmp;
                }
            }
        }
    }
    
    
    public void deleteBefore(String code){
        int pos=0;
        int count=0;
        Node tmp=head;
        Node x=head;
        
        if(!head.boat.getBcode().equals(code)){
            
            while(tmp!=null){
            if(tmp.boat.getBcode().equals(code)){
                break;
            }
            tmp=tmp.left;
            count++;
        }
        
        while(x!=null){
            if(pos==(count-1)){
                delete(x.boat.getBcode(),1);
                break;
            }
            x=x.left;
            pos++;
        }
            
        }else{
            System.out.println("Nothing to delete");
        }
        
        }
        
    
    
    public void print(int x){
        if(isEmpty()){
            System.out.println("Nothing");
        }else{
            Node tmp=head;
            
            if(x==1){
                while(tmp!=null){
                System.out.println(tmp.boat);
                tmp=tmp.left;
            }
            }else if(x==2){
                while(tmp!=null){
                System.out.println(tmp.cus);
                tmp=tmp.left;            
            }
            }else if(x==3){
                while(tmp!=null){
                System.out.println(tmp.booking);
                tmp=tmp.left;     
            }
            
        }
    }
    }
    
    public void addToTailCus(Customer cus){
        Node tmp = new Node(cus);
        if(isEmpty()){
            head=tmp;
            tail=tmp;
        }else{
            tail.left=tmp;
            tail=tmp;
        }
    }
    
    public void addToTailBooking(Booking booking){
        Node tmp = new Node(booking);
        if(isEmpty()){
            head=tmp;
            tail=tmp;
        }else{
            tail.left=tmp;
            tail=tmp;
        }
    }

    
    void visit(Node p) {
        if (p != null) {
            System.out.println(p.boat + " ");
        }
    }

    void inorder(Node p) {
        if (p == null) {
            return;
        }
        inorder(p.left);
        visit(p);
        inorder(p.right);
    }

    void bfs(Node p) {
        if (p == null) {
            return;
        }
        MyQueue m = new MyQueue();
        m.enqueue(p);
        while (!m.isEmpty()) {
            Node q = (Node) m.dequeue();// get node
            if (q.left != null) { // if lever still hava node left
                m.enqueue(q.left);
            }
            if (q.right != null) { //if lever still hava node right
                m.enqueue(q.right);
            }
            visit(q);// traversal them
        }
    }

    void inorderTraverseToFile() throws IOException{
        FileWriter fw = new FileWriter(fname);
        inOrderFile(head, fw);
        fw.close();
    }
    
    void visit(Node p, FileWriter fw) throws IOException {

        fw.write(p.boat.getBcode() + " | " + p.boat.getBoat_name() + " | "
                + p.boat.getSeat() + " | " + p.boat.getBooked() + " | "
                + p.boat.getRate()+ p.boat.getDepart_place() + "\n");

    }
     void inOrderFile(Node p, FileWriter fw) throws IOException{
          if (p == null) {
            return;
        }
        inOrderFile(p.left, fw);
        visit(p, fw);
        inOrderFile(p.right, fw);
    }
    
    public static Node search(Node p, String bCode) {
        if (p == null) {
            return null;
        }
        if (p.boat.getBcode().equalsIgnoreCase(bCode)) {
            return p;
        } else if (p.boat.getBcode().compareToIgnoreCase(bCode) > 0) {
            return search(p.left, bCode);
        } else {
            return search(p.right, bCode);
        }
    }   
    public void deleByCopy(String bCode) {
        Node f, p;
        f = null;
        p = head;
        while (p != null) {
            if (p.boat.getBcode().equals(bCode)) {
                break;
            }
            f = p;
            if (bCode.compareTo(p.boat.getBcode()) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            System.out.println("Code not found"); // not found
        }
        // p is leaf node
        if (p.left == null && p.right == null) {
            if (f == null) // p=root
            {
                head = null;
            } else {
                if (p == f.left) {
                    f.left = null;
                }
                f.right = null;
            }
            return;
        }

        // p has left child only
        if (p.left != null && p.right == null) {
            if (f == null) // p=root
            {
                head = p.left;
            } else {
                if (p == f.left) {
                    f.left = p.left;
                }
                f.right = p.left;
            }
            return;
        }

        // p has right child only
        if (p.left == null && p.right != null) {
            if (f == null) // p=root
            {
                head = p.right;
            } else {
                if (p == f.left) {
                    f.left = p.right;
                }
                f.right = p.right;
            }
            return;
        }

        // p has both 2 children
        if (p.left != null && p.right != null) {// find the right most node
            Node q = p.left;
            Node frp, rp;
            frp = null;
            rp = q;
            while (rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
            // rp is the right most node on the left child
            p.boat = rp.boat;
            if (frp == null) // rp=q
            {
                p.left = q.left;
            } else {
                frp.right = rp.left;
            }
        }
    }
    void inOrder(ArrayList<Boat> t, Node p) {
        if (p == null) {
            return;
        }
        inOrder(t, p.left);
        t.add(p.boat);
        inOrder(t, p.right);
    }

    void bal() {
        ArrayList<Boat> t = new ArrayList<>();
        inOrder(t, head);
        clear();
        int n = t.size();
        balance(t, 0, n - 1);
    }
    void balance(ArrayList<Boat> t, int i, int j) {
        if (i > j) {
            return;
        }
        int k = (i + j) / 2;
        Boat x = t.get(k);
        insert(x);
        balance(t, i, k - 1);
        balance(t, k + 1, j);
    }
    public int countNode() {
        if (head == null) {
            return 0;
        } else {
            return getSize(head);
        }
    }

    int getSize(Node p) {
        int count = 1;
        if (p.left != null) {
            count += getSize(p.left);
        }
        if (p.right != null) {
            count += getSize(p.right);
        }
        return count;
    }
}
