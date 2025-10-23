package service;

import model.*;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class StudentService {
    public StudentService(){}
    Random rand = new Random();
    public double getV(){
        return Math.round((1 + 9*rand.nextDouble())*100)/100.0;
    }
    private List<Student> students;
    public void addStudent(Student student)throws DuplicateIdException{
        if(students.stream().anyMatch(st -> student.getID() == st.getID()))
            throw new DuplicateIdException("Deja exista un student cu acest ID: " + student.getID());
    }
    public List<Student> findByName(String name){
        return students
                .stream()
                //.map(x -> x.getName().toLowerCase())
                .filter(st -> st.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Student> getTopStudents(int n){
        return students
                .stream()
                .sorted(Comparator.comparingDouble(Student::avgGrade).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    public double getAverageGradeForSubject(String subject){
        return students
                .stream()
                .flatMap(st -> st.getGrades().stream())
                .filter(x -> x.getSubject().equalsIgnoreCase(subject))
                .mapToDouble(Grade::getGrade)
                .average()
                .orElse(0);
    }

    public Map<String, List<Student>> groupByGroup(){
        return students
                .stream()
                .collect(Collectors.groupingBy(Student::getGroup));
    }

    public void loadDemoStudents(){
        List<String> subjects = randSub(subList,5);
        List<Grade> gr1 = List.of(
                new Grade(subjects.get(0),getV()),
                new Grade(subjects.get(1),getV()),
                new Grade(subjects.get(2),getV()),
                new Grade(subjects.get(3),getV()),
                new Grade(subjects.get(4),getV())
        );
        subjects = randSub(subList,5);
        List<Grade> gr2 = List.of(
                new Grade(subjects.get(0),getV()),
                new Grade(subjects.get(1),getV()),
                new Grade(subjects.get(2),getV()),
                new Grade(subjects.get(3),getV()),
                new Grade(subjects.get(4),getV())
        );
        subjects = randSub(subList,5);
        List<Grade> gr3 = List.of(
                new Grade(subjects.get(0),getV()),
                new Grade(subjects.get(1),getV()),
                new Grade(subjects.get(2),getV()),
                new Grade(subjects.get(3),getV()),
                new Grade(subjects.get(4),getV())
        );
        subjects = randSub(subList,5);
        List<Grade> gr4 = List.of(
                new Grade(subjects.get(0),getV()),
                new Grade(subjects.get(1),getV()),
                new Grade(subjects.get(2),getV()),
                new Grade(subjects.get(3),getV()),
                new Grade(subjects.get(4),getV())
        );
        subjects = randSub(subList,5);
        List<Grade> gr5 = List.of(
                new Grade(subjects.get(0),getV()),
                new Grade(subjects.get(1),getV()),
                new Grade(subjects.get(2),getV()),
                new Grade(subjects.get(3),getV()),
                new Grade(subjects.get(4),getV())
        );
        students = List.of(
                new Student(1,"Robert","G1",gr1),
                new Student(2,"Ana","T2",gr2),
                new Student(3,"Emanuel","G1",gr3),
                new Student(4,"Ionel","T2",gr4),
                new Student(5,"Ion","G1",gr5)
                );
    }

    public List<String> randSub(List<String> list, int k){
        return rand
                .ints(0,list.size())
                .distinct()
                .limit(k)
                .mapToObj(list::get)
                .collect(Collectors.toList());
    }
    List<String> subList = Arrays.asList("Java","PHP","C++","Python","C#","HTML","CSS","JS","Ruby","Swift","Kotlin","C");
}
