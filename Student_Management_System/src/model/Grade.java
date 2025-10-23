package model;

import java.util.Scanner;

public class Grade {
    private String subject;
    private double grade;
    public Grade(String subject, double grade) {
        this.subject = subject;
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        while (grade < 1 || grade > 10) {
            System.out.println("model.Grade out of range, change it (1-10)");
            Scanner sc = new Scanner(System.in);
            grade = sc.nextDouble();
        }
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "{ "+getSubject()+": "+getGrade()+" }; ";
    }
}
