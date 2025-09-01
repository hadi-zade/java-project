public class Major {
    private String code;
    private String name;
    private String departmentCode;
    private String departmentName;
    private String facultyCode;
    private String facultyName;
    private DegreeLevel level;

    public Major(String code, String name, String departmentCode, String departmentName,
                 String facultyCode, String facultyName, DegreeLevel level) { // اضافه کردن level
        this.code = code;
        this.name = name;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.facultyCode = facultyCode;
        this.facultyName = facultyName;
        this.level = level; // مقداردهی level
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public String getDepartmentCode() { return departmentCode; }
    public String getDepartmentName() { return departmentName; }
    public String getFacultyCode() { return facultyCode; }
    public String getFacultyName() { return facultyName; }
    public DegreeLevel getLevel() { return level; }

    public void showInfo() {
        System.out.println("Major: " + name + " (Code: " + code + ", " + level +
                ") | Department: " + departmentName + " | Faculty: " + facultyName);
    }
}
