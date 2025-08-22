import java.util.ArrayList;

public class Professor extends Person {
    private ArrayList<Course> courses = new ArrayList<>();

    public Professor(String name, String id, String email, String nationalId, String phoneNumber, String birthDate) {

        super(name, id, email, nationalId, phoneNumber, birthDate);
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