import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String code; // اضافه کردن کد
    private String name;
    private List<Department> departments = new ArrayList<>();

    public Faculty(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() { return code; }
    public String getName() { return name; }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    public void showInfo() {
        System.out.println("Faculty: " + name + " (Code: " + code + ")");
        for (Department d : departments) {
            d.showInfo();
        }
    }
}
