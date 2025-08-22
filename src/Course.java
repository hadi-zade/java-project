public class Course {
    private String courseId;
    private String title;
    private String unit;

    public Course(String courseId, String title, String unit) {
        this.courseId = courseId;
        this.title = title;
        this.unit = unit;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public String getUnit() {
        return unit;
    }
}