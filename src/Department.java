import java.util.ArrayList;
import java.util.List;

// کلاس گروه آموزشی
public class Department {
    private String name;
    private List<Major> majors = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addMajor(Major major) {
        majors.add(major);
    }

    public void showInfo() {
        System.out.println("Department: " + name);
        for (Major m : majors) {
            m.showInfo();
        }
    }
}