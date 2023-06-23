//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example.Models;

public class Fresher extends Candidate {
    private String graduationDate;
    private String graduationRank;

    public Fresher() {
    }

    public Fresher(String graduationDate, String graduationRank, String id, String firstName, String lastName, int birthDate, String address, String phone, String email, int typeCandidate) {
        super(id, firstName, lastName, birthDate, address, phone, email, typeCandidate);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
    }

    public String getGraduationDate() {
        return this.graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return this.graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }
}
