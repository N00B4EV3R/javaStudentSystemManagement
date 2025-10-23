import service.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService obj = new StudentService();
        obj.loadDemoStudents();
        obj.getTopStudents(5).forEach(System.out::println);
        obj.findByName("el").forEach(System.out::println);
        System.out.println(obj.getAverageGradeForSubject("Java"));
    }
}