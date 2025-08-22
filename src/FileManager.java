import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
            FileWriter writer = new FileWriter("professor.txt", true);
            writer.write(p.name + "," + p.id + "," + p.email + "," + p.nationalId + "," + p.phoneNumber + "," + p.birthDate + "\n");
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

    // ✅ لیست دانش‌آموزان
    public static void listStudent() {
        try {
            FileReader fr = new FileReader("student.txt");
            Scanner sc = new Scanner(fr);

            System.out.println("=== Student List ===");
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
            System.out.println("No students found or error reading file.");
        }
    }

    // ✅ لیست استادها
    public static void listProfessor() {
        try {
            FileReader fr = new FileReader("professor.txt");
            Scanner sc = new Scanner(fr);

            System.out.println("=== Professor List ===");
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
            System.out.println("No professors found or error reading file.");
        }
    }

    // ✅ لیست کارمندها
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
}
