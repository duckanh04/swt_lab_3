//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example.Models;

public class Internship extends Candidate {
    private String major;
    private String semester;
    private String university;

    public Internship() {
    }

    public Internship(String major, String semester, String university, String id, String firstName, String lastName, int birthDate, String address, String phone, String email, int typeCandidate) {
        super(id, firstName, lastName, birthDate, address, phone, email, typeCandidate);
        this.major = major;
        this.semester = semester;
        this.university = university;
    }

    public String getMajor() {
        return this.major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return this.semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversity() {
        return this.university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
