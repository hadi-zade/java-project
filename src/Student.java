import java.util.ArrayList;

public class Student extends Person {
    private ArrayList<Course> courses = new ArrayList<>();
    private String major;
    private String department;
    private String faculty;
    private DegreeLevel level; // اضافه کردن level

    // کانستراکتور جدید با level
    public Student(String name, String id, String email, String nationalId, String phoneNumber,
                   String birthDate, String major, String department, String faculty, DegreeLevel level) {
        super(name, id, email, nationalId, phoneNumber, birthDate);
        this.courses = new ArrayList<>();
        this.major = major;
        this.department = department;
        this.faculty = faculty;
        this.level = level; // مقداردهی level
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public String getFaculty() {
        return faculty;
    }

    public String getDepartment() {
        return department;
    }

    public String getMajor() {
        return major;
    }

    public DegreeLevel getLevel() {
        return level;
    }

    public void showCourses() {
        System.out.println("Courses of " + name + ":");
        for (Course c : courses) {
            System.out.println("- " + c.getTitle());
        }
    }
}
