import java.util.ArrayList;
import java.util.List;

public class Department {
    private String code; // اضافه کردن کد
    private String name;
    private String facultyCode; // برای هماهنگی با FileManager
    private String facultyName;
    private List<Major> majors = new ArrayList<>();

    public Department(String code, String name, String facultyCode, String facultyName) {
        this.code = code;
        this.name = name;
        this.facultyCode = facultyCode;
        this.facultyName = facultyName;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public String getFacultyCode() { return facultyCode; }
    public String getFacultyName() { return facultyName; }

    public void addMajor(Major major) {
        majors.add(major);
    }

    public void showInfo() {
        System.out.println("Department: " + name + " (Code: " + code + ") | Faculty: " + facultyName);
        for (Major m : majors) {
            m.showInfo();
        }
    }
}
