import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {

    public static void saveStudent(Student s) {
        try {
            FileWriter writer = new FileWriter("student.txt", true);
            writer.write(s.name + "," + s.id + "," + s.email + "," + s.nationalId + "," + s.phoneNumber + "," + s.birthDate +","+ s.getDepartment()+ "," + s.getFaculty()+"\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void saveProfessor(Professor p) {
        try {
            FileWriter writer = new FileWriter("professor.txt", true);
            writer.write(p.name + "," + p.id + "," + p.email + "," + p.nationalId + "," + p.phoneNumber + "," + p.birthDate +","+ p.getDepartment()+ "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void saveStaff(Staff s) {
        try {
            FileWriter writer = new FileWriter("staff.txt", true);
            writer.write(s.name + "," + s.id + "," + s.email + "," + s.nationalId + "," + s.phoneNumber + "," + s.birthDate + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // لیست دانش‌آموزان
    public static void listStudent() {
        try {
            FileReader fr = new FileReader("student.txt");
            Scanner sc = new Scanner(fr);

            System.out.println("=== Student List ===");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");

                if (data.length == 8) {
                    System.out.println("Name: " + data[0] +
                            ", ID: " + data[1] +
                            ", Email: " + data[2] +
                            ", National ID: " + data[3] +
                            ", Phone: " + data[4] +
                            ", BirthDate: " + data[5]+
                            ", Department: "+data[6] +
                            ", Faculty: " +data[7]);
                }
            }

            sc.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("No students found or error reading file.");
        }
    }

    public static void listProfessor() {
        try {
            FileReader fr = new FileReader("professor.txt");
            Scanner sc = new Scanner(fr);

            System.out.println("=== Professor List ===");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");

                if (data.length == 7) {
                    System.out.println("Name: " + data[0] +
                            ", ID: " + data[1] +
                            ", Email: " + data[2] +
                            ", National ID: " + data[3] +
                            ", Phone: " + data[4] +
                            ", BirthDate: " + data[5]+
                            ", Department: "+data[6]);
                }
            }

            sc.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("No professors found or error reading file.");
        }
    }

    //  لیست کارمندها
    public static void listStaff() {
        try {
            FileReader fr = new FileReader("staff.txt");
            Scanner sc = new Scanner(fr);

            System.out.println("=== Staff List ===");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");

                if (data.length == 6) {
                    System.out.println("Name: " + data[0] +
                            ", ID: " + data[1] +
                            ", Email: " + data[2] +
                            ", National ID: " + data[3] +
                            ", Phone: " + data[4] +
                            ", BirthDate: " + data[5]);
                }
            }

            sc.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("No staff found or error reading file.");
        }
    }

    public static void saveCourse(Course c) {
        try {
            FileWriter writer = new FileWriter("course.txt", true); // اضافه کردن به فایل
            writer.write(c.getCourseId() + "," + c.getTitle() + "," + c.getUnit() + "\n");
            writer.close();
            System.out.println("Course saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving course: " + e.getMessage());
        }
    }

    //  متد نمایش لیست دروس (مبتدی با Scanner)
    public static void listCourse() {
        try {
            FileReader fr = new FileReader("course.txt");
            Scanner sc = new Scanner(fr);

            System.out.println("=== Course List ===");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");
                if (data.length == 3) {
                    System.out.println("Course ID: " + data[0] +
                            ", Title: " + data[1] +
                            ", Units: " + data[2]);
                }
            }

            sc.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("No courses found or error reading file.");
        }
    }
    public static void searchStudent(String studentId) {
        try {
            FileReader fr = new FileReader("student.txt");
            Scanner sc = new Scanner(fr);

            boolean found = false;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");
                System.out.println("Checking ID: [" + data[1] + "]");
                if (data.length == 8 && data[1].equals(studentId)) {
                    System.out.println("Student found:");
                    System.out.println("Name: " + data[0] +
                            ", ID: " + data[1] +
                            ", Email: " + data[2] +
                            ", National ID: " + data[3] +
                            ", Phone: " + data[4] +
                            ", BirthDate: " + data[5]+
                            ", Department: "+data[6] +
                            ", Faculty: " +data[7]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("No student found with ID: " + studentId);
            }

            sc.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error reading student file.");
        }
    }

}