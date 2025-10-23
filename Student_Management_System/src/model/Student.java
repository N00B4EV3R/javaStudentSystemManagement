package model;
import java.util.*;

public class Student {
    private int ID;
    private String name;
    private String group;
    private List<Grade> grades;
    public Student(int ID, String name, String group, List<Grade> grades) {
        this.ID = ID;
        this.name = name;
        this.group = group;
        this.grades = grades;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public double avgGrade(){
        OptionalDouble average = grades
                .stream()
                .mapToDouble(Grade::getGrade)
                .average();
        return average.orElse(0);

    }

    @Override
    public String toString() {
        return getName() + " " + getGroup() + " " + getGrades();
    }
}
