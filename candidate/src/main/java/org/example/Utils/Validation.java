//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example.Utils;

import org.example.Models.Candidate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;

public class Validation {
    private static final Scanner in;
    private static final String PHONE_VALID = "^\\d{10}\\d*$";
    private static final String EMAIL_VALID = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";

    public Validation() {
    }

    public static int checkInputIntLimit(int min, int max) {
        while(true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result >= min && result <= max) {
                    return result;
                }

                throw new NumberFormatException();
            } catch (NumberFormatException var3) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputString() {
        while(true) {
            String result = in.nextLine().trim();
            if (!result.isEmpty()) {
                return result;
            }

            System.err.println("Not empty");
            System.out.print("Enter again: ");
        }
    }

    public static boolean checkInputYN() {
        while(true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }

            if (result.equalsIgnoreCase("N")) {
                return false;
            }

            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    public static String checkInputPhone() {
        while(true) {
            String result = checkInputString();
            if (result.matches("^\\d{10}\\d*$")) {
                return result;
            }

            System.err.println("Phone is number with minimum 10 characters");
            System.out.print("Enter again: ");
        }
    }

    public static String checkInputEmail() {
        while(true) {
            String result = checkInputString();
            if (result.matches("^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$")) {
                return result;
            }

            System.err.println("Email with format <account name>@<domain>");
            System.out.print("Enter again: ");
        }
    }

    public static String checkInputGraduationRank() {
        while(true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Excellence") || result.equalsIgnoreCase("Good") || result.equalsIgnoreCase("Fair") || result.equalsIgnoreCase("Poor")) {
                return result;
            }

            System.err.println("Please input string: Excellence, Good, Fair, Poor");
            System.out.print("Enter again: ");
        }
    }

    public static boolean checkIdExist(ArrayList<Candidate> candidates, String id) {
        Iterator var2 = candidates.iterator();

        Candidate candidate;
        do {
            if (!var2.hasNext()) {
                return true;
            }

            candidate = (Candidate)var2.next();
        } while(!candidate.getId().equalsIgnoreCase(id));

        System.err.println("Id exist.");
        return false;
    }

    public static int checkInputExprience(int birthDate) {
        int yearCurrent = Calendar.getInstance().get(1);
        int age = yearCurrent - birthDate;

        while(true) {
            int yearExperience = checkInputIntLimit(1, 100);
            if (yearExperience <= age) {
                return yearExperience;
            }

            System.err.println("Models.Experience must be smaller than age");
        }
    }

    static {
        in = new Scanner(System.in);
    }
}
