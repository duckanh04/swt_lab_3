//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example.Utils;
import org.example.Models.Candidate;
import org.example.Models.Experience;
import org.example.Models.Fresher;
import org.example.Models.Internship;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class Manager {
    public Manager() {
    }

    public static int menu() {
        System.out.println("1. Models.Experience");
        System.out.println("2. Models.Fresher");
        System.out.println("3. Models.Internship");
        System.out.println("4. Searching");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validation.checkInputIntLimit(1, 5);
        return choice;
    }

    public static void createCandidate(ArrayList<Candidate> candidates, int type) {
        while(true) {
            System.out.print("Enter id: ");
            String id = Validation.checkInputString();
            System.out.print("Enter first name: ");
            String firstName = Validation.checkInputString();
            System.out.print("Enter last name: ");
            String lastName = Validation.checkInputString();
            System.out.print("Enter birth date: ");
            int birthDate = Validation.checkInputIntLimit(1900, Calendar.getInstance().get(1));
            System.out.print("Enter address: ");
            String address = Validation.checkInputString();
            System.out.print("Enter phone: ");
            String phone = Validation.checkInputPhone();
            System.out.print("Enter email: ");
            String email = Validation.checkInputEmail();
            Candidate candidate = new Candidate(id, firstName, lastName, birthDate, address, phone, email, type);
            if (Validation.checkIdExist(candidates, id)) {
                switch (type) {
                    case 0:
                        createExperience(candidates, candidate);
                        break;
                    case 1:
                        createFresher(candidates, candidate);
                        break;
                    case 2:
                        createInternship(candidates, candidate);
                }

                System.out.print("Do you want to continue (Y/N): ");
                if (Validation.checkInputYN()) {
                    continue;
                }

                return;
            }

            return;
        }
    }

    public static void createExperience(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Enter year of experience: ");
        int yearExperience = Validation.checkInputExprience(candidate.getBirthDate());
        System.out.print("Enter professional skill: ");
        String professionalSkill = Validation.checkInputString();
        candidates.add(new Experience(yearExperience, professionalSkill, candidate.getId(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    public static void createFresher(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Enter graduation date: ");
        String graduationDate = Validation.checkInputString();
        System.out.print("Enter graduation rank: ");
        String graduationRank = Validation.checkInputGraduationRank();
        candidates.add(new Fresher(graduationDate, graduationRank, candidate.getId(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    public static void createInternship(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Enter major: ");
        String major = Validation.checkInputString();
        System.out.print("Enter semester: ");
        String semester = Validation.checkInputString();
        System.out.print("Enter university: ");
        String university = Validation.checkInputString();
        candidates.add(new Internship(major, semester, university, candidate.getId(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    public static void searchCandidate(ArrayList<Candidate> candidates) {
        printListNameCandidate(candidates);
        System.out.print("Enter andidate name (First name or Last name): ");
        String nameSearch = Validation.checkInputString();
        System.out.print("Enter type of candidate: ");
        int typeCandidate = Validation.checkInputIntLimit(0, 2);
        Iterator var3 = candidates.iterator();

        while(true) {
            Candidate candidate;
            do {
                if (!var3.hasNext()) {
                    return;
                }

                candidate = (Candidate)var3.next();
            } while((candidate.getTypeCandidate() != typeCandidate || !candidate.getFirstName().contains(nameSearch)) && !candidate.getLastName().contains(nameSearch));

            System.out.println(candidate.toString());
        }
    }

    public static void printListNameCandidate(ArrayList<Candidate> candidates) {
        System.err.println("Models.Experience Models.Candidate");
        Iterator var1 = candidates.iterator();

        Candidate candidate;
        while(var1.hasNext()) {
            candidate = (Candidate)var1.next();
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }

        System.err.println("Models.Fresher Models.Candidate");
        var1 = candidates.iterator();

        while(var1.hasNext()) {
            candidate = (Candidate)var1.next();
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }

        System.err.println("Models.Internship Models.Candidate");
        var1 = candidates.iterator();

        while(var1.hasNext()) {
            candidate = (Candidate)var1.next();
            if (candidate instanceof Internship) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }

    }
}
