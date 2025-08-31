import java.util.ArrayList;

public class Professor extends Person {
    private ArrayList<Course> courses = new ArrayList<>();
    private String department;

    public Professor(String name, String id, String email, String nationalId, String phoneNumber, String birthDate, String department) {

        super(name, id, email, nationalId, phoneNumber, birthDate);

        this.courses = new ArrayList<>();
        this.department = department;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void showCourses() {
        System.out.println("Courses taught by " + name + ":");
        for (Course c : courses) {
            System.out.println("- " + c.getTitle());
        }
    }
}