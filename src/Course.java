public class Course {
    private String courseId;
    private String title;
    private int unit;

    public Course(String courseId, String title, int unit) {
        this.courseId = courseId;
        this.title = title;
        this.unit = unit;
    }

    public String getTitle() {

        return title;
    }
}