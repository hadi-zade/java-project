import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static void saveStudent(Student s) {
        try {
            FileWriter writer = new FileWriter("student.txt", true);
            writer.write(s.name + "," + s.id + "," + s.email + "," + s.nationalId + "," + s.phoneNumber + "," + s.birthDate + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void saveProfessor(Professor p) {
        try {
            FileWriter writer = new FileWriter("Professor.txt", true);
            writer.write(p.name + "," + p.id + p.email + "," + p.nationalId + "," + p.phoneNumber + "," + p.birthDate + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void saveStaff(Staff s) {
        try {
            FileWriter writer = new FileWriter("staf.txt", true);
            writer.write(s.name + "," + s.id + s.email + "," + s.nationalId + "," + s.phoneNumber + "," + s.birthDate + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}