import java.util.ArrayList;
import java.util.List;

// کلاس دانشکده
public class Faculty {
    private String name;
    private List<Department> departments = new ArrayList<>();

    public Faculty(String name) {
        this.name = name;
    }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    public void showInfo() {
        System.out.println("Faculty: " + name);
        for (Department d : departments) {
            d.showInfo();
        }
    }
}