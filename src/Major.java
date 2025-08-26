// کلاس رشته تحصیلی
public class Major {
    private String name;
    private DegreeLevel level;

    public Major(String name, DegreeLevel level) {
        this.name = name;
        this.level = level;
    }

    public void showInfo() {
        System.out.println("Major: " + name + " (" + level + ")");
    }
}