
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khang
 */
public class Validation {
      private static Scanner sc= new Scanner(System.in);
    
    public static int checkInputInteger (String msg, int min, int max){
        int result;
        while(true){
            try{
                System.out.println(msg);
                result=Integer.parseInt(sc.nextLine());
                if(result<min || result>max){
                    System.out.println("Please enter an integer from "+min+" to "+max);
                }else{
                    break;
                }
            }catch(Exception e){
                System.out.println("Input must be a number integer");
            }
        }
        return result;
    }
    
    public static double checkInputDouble(String msg,double min,double max){
        double result;
        while(true){
            try{
                System.out.println(msg);
                result=Double.parseDouble(sc.nextLine());
                if(result<=min || result>max){
                    System.out.println("Please enter an integer from "+min+" to "+max);
                }else{
                    break;
                }
            }catch(Exception e){
                System.out.println("Input must be a number double");
            }
        }
        return result;
    }
    
    public static String checkInputString(String msg){
        String result;
        while(true){
            System.out.println(msg);
            result=sc.nextLine();
            if(result.trim().isEmpty()){
                System.out.println("Input must not be empty");
            }else{
                return result;
            }
        }
    }
    
    public static String checkInputYN(String msg){
        String result;
        while(true){
            System.out.println(msg);
            result=sc.nextLine();
            if(result.equalsIgnoreCase("Y")){
                break;
            }else if(result.equalsIgnoreCase("N")){
                break;
            }else{
                System.out.println("Input must only be 'y' or 'n'");
            }
        }
        return result;
    }
    public static String checkInputString1() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not Emtpty");
                System.out.println("Enter again");
            } else {
                return result;
            }
        }
    }
}
