import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private ArrayList<Course> courses = new ArrayList<>();
    private String major;
    private String department;
    private String faculty;
    // رشته اصلی
    public Student(String name, String id, String email, String nationalId, String phoneNumber, String birthDate, String major, String department, String faculty) {

        super(name, id, email, nationalId, phoneNumber, birthDate);

        this.courses = new ArrayList<>();
        this.major = major;
        this.department=department;
        this.faculty=faculty;
    }

    public void addCourse(Course course) {

        courses.add(course);
    }

    public void showCourses() {
        System.out.println("Courses of " + name + ":");
        for (Course c : courses) {
            System.out.println("- " + c.getTitle());
        }
    }
}