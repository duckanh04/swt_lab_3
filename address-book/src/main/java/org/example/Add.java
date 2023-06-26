package org.example;

import java.io.*;
import java.util.Scanner;

public class Add extends Main {
    static Scanner input = new Scanner(System.in);

    public static void add_contact() throws Exception {
        File file1 = new File(System.getProperty("user.dir") + "/src/main/java/org/example/contacts.txt");// we get the file
        BufferedReader reader1 = new BufferedReader(new FileReader(file1)); // we get reader for the file
        OutputStreamWriter writer1 = new OutputStreamWriter(
                new FileOutputStream(System.getProperty("user.dir") + "/src/main/java/org/example/contacts.txt", true), "UTF-8");
        BufferedWriter writer = new BufferedWriter(writer1);//this is a way to get a writer for th specific file
        boolean duplicate, valid;
        String currentLine1;
        String f1 = "";//I initialize the variables to avoid errors
        String f2 = "";
        String f5 = "";
        String f6 = "";
        String f8 = "";
        int f3 = -1;
        int f4 = -1;
        int f7 = -1;
        int f9 = -1;
        String str;
        System.out.println("Give Name: ");
        f1 = input.nextLine();
        System.out.println("Give Surname: ");
        f2 = input.nextLine();

        do {
            //this is a do-while loop in which I check for valid input (must me integer)
            // and I loop through the txt file again to check if input is duplicate
            duplicate = false;
            valid = true;
            System.out.println("Give Phone: ");

            try {
                f3 = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                valid = false;
                System.out.println("Phone must be number.");
            }

            duplicate = isPhoneDuplicate(reader1, duplicate, f3);        //Test 1

            reader1 = new BufferedReader(new FileReader(file1));
        } while (duplicate == true || valid == false);

        do {
            duplicate = false;
            valid = true;
            System.out.println("Give Mobile phone: ");
            //f4 = input.nextInt();
            try {
                f4 = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                //e.printStackTrace();
                System.out.println("Mobile phone must be number.");
                valid = false;
            }
            duplicate = isMobilePhoneDuplicated(reader1, duplicate, f4);      // Test 2

            reader1 = new BufferedReader(new FileReader(file1));
        } while (duplicate == true || valid == false);

        do {
            duplicate = false;
            System.out.println("Give E-mail: ");
            f5 = input.nextLine();

            duplicate = isMailDuplicated(reader1, duplicate, f5);       // Test 3

            reader1 = new BufferedReader(new FileReader(file1));
        } while (duplicate == true);

        System.out.println("Give Street: ");
        String tmp = input.nextLine();

        f6 = getAddress(tmp);           // Test 4

        System.out.println("Give street number: ");
        int intTmp = input.nextInt();
        f7 = getStreetNumber(f7, intTmp);       // Test 7

        System.out.println("Give town: ");
        f8 = input.nextLine();

        System.out.println("Give Zip code: ");
        String nextLine = input.nextLine();
        f9 = getZipCode(f9, nextLine);            // Test 6

        extracted(file1, f1, f2, f5, f6, f8, f3, f4, f7, f9);           // Test 5
        //input.close();
        //writer1.close();
        writer.close();
        reader1.close();
    }

    public static int getStreetNumber(int f7, int intTmp) {
        boolean valid;
        do {
            valid = true;
            try {
                f7 = intTmp;
            } catch (NumberFormatException e) {
                //e.printStackTrace();
                System.out.println("Street number must be a number.");
                valid = false;
            }
        } while (valid == false);
        return f7;
    }

    public static Integer getZipCode(int f9, String intTmp) throws NumberFormatException {
        boolean valid;
        valid = true;
        f9 = Integer.parseInt(intTmp);
        if (f9 <= 0)
            return null;
        return f9;
    }

    public static void extracted(File file1, String f1, String f2, String f5, String f6, String f8, int f3, int f4, int f7, int f9) throws IOException {
        String str;
        if (f1 == "" || f2 == "" || f5 == "" || f6 == "" || f8 == "" || f3 == -1 || f4 == -1 || f7 == -1 || f9 == -1) {//i check that all variables have a valid attribute assigned
            System.out.println("You gave false inputs, adding new contact wasn't successful: ");
        } else {//if everything is correct i build a string
            str = f1 + "," + f2 + "," + String.valueOf(f3) + "," + String.valueOf(f4) + "," + f5 + "," + f6 + "," + String.valueOf(f7) + "," + f8 + "," + String.valueOf(f9);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file1, true)));//with these code I add a line at the bottom of the file
            out.println(str);
            out.close();
        }
    }

    public static String getAddress(String tmp) {
        String f6;
        if (!tmp.isEmpty()) {
            f6 = tmp;
        } else throw new IllegalArgumentException("Empty");
        return f6;
    }

    public static boolean isMailDuplicated(BufferedReader reader1, boolean duplicate, String f5) throws IOException {
        String currentLine1;
        while ((currentLine1 = reader1.readLine()) != null) {//check for duplicate
            String[] words1 = currentLine1.split(",");
            if (words1[4].equals(f5)) {
                duplicate = true;
                System.out.println("E-mail must be unique among the contacts.");
            }
        }
        return duplicate;
    }

    public static boolean isMobilePhoneDuplicated(BufferedReader reader1, boolean duplicate, int f4) throws IOException {
        String currentLine1;
        while ((currentLine1 = reader1.readLine()) != null) {//check for duplicate
            String[] words1 = currentLine1.split(",");
            if (words1[3].equals(String.valueOf(f4))) {
                duplicate = true;
                System.out.println("Mobile Phone must be unique among the contacts.");
            }
        }
        return duplicate;
    }

    // Check 1
    public static boolean isPhoneDuplicate(BufferedReader reader1, boolean duplicate, int f3) throws IOException {
        String currentLine1;
        while ((currentLine1 = reader1.readLine()) != null) {//check for duplicate
            String[] words1 = currentLine1.split(",");
            if (words1[2].equals(String.valueOf(f3))) {
                duplicate = true;
                System.out.println("Phone must be unique among the contacts.");
            }
        }
        return duplicate;
    }

}