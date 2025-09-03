import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {

    // ذخیره دانشجو
    public static void saveStudent(Student s) {
        try {
            FileWriter writer = new FileWriter("student.txt", true);
            writer.write(s.name + "," + s.id + "," + s.email + "," + s.nationalId + "," +
                    s.phoneNumber + "," + s.birthDate + "," + s.getMajor() + "," +
                    s.getDepartment() + "," + s.getFaculty() + "," +
                    s.getLevel() + "\n"); // اضافه کردن level
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // ذخیره استاد
    public static void saveProfessor(Professor p) {
        try {
            FileWriter writer = new FileWriter("professor.txt", true);
            writer.write(p.name + "," + p.id + "," + p.email + "," + p.nationalId + "," + p.phoneNumber + "," + p.birthDate + "," + p.getDepartment() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ذخیره کارمند
    public static void saveStaff(Staff s) {
        try {
            FileWriter writer = new FileWriter("staff.txt", true);
            writer.write(s.name + "," + s.id + "," + s.email + "," + s.nationalId + "," + s.phoneNumber + "," + s.birthDate + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // لیست دانشجویان
    public static void listStudent() {
        try {
            FileReader fr = new FileReader("student.txt");
            Scanner sc = new Scanner(fr);

            System.out.println("=== Student List ===");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");

                if (data.length == 10) { // الان ۱۰ فیلد داریم
                    System.out.println("Name: " + data[0] +
                            ", ID: " + data[1] +
                            ", Email: " + data[2] +
                            ", National ID: " + data[3] +
                            ", Phone: " + data[4] +
                            ", BirthDate: " + data[5] +
                            ", Major: " + data[6] +
                            ", Department: " + data[7] +
                            ", Faculty: " + data[8] +
                            ", Level: " + data[9]);
                }
            }

            sc.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("No students found or error reading file.");
        }
    }


    // لیست استادها
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
                            ", BirthDate: " + data[5] +
                            ", Department: " + data[6]);
                }
            }

            sc.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("No professors found or error reading file.");
        }
    }

    // لیست کارمندها
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

    // ذخیره درس
    public static void saveCourse(Course c) {
        try {
            FileWriter writer = new FileWriter("course.txt", true);
            writer.write(c.getCourseId() + "," + c.getTitle() + "," + c.getUnit() + "\n");
            writer.close();
            System.out.println("Course saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving course: " + e.getMessage());
        }
    }

    // لیست دروس
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

    // جستجوی دانشجو بر اساس ID
    public static void searchStudent(String studentId) {
        try {
            FileReader fr = new FileReader("student.txt");
            Scanner sc = new Scanner(fr);

            boolean found = false;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");
                if (data.length == 10 && data[1].equals(studentId)) {
                    System.out.println("Student found:");
                    System.out.println("Name: " + data[0] +
                            ", ID: " + data[1] +
                            ", Email: " + data[2] +
                            ", National ID: " + data[3] +
                            ", Phone: " + data[4] +
                            ", BirthDate: " + data[5] +
                            ", Major: " + data[6] +
                            ", Department: " + data[7] +
                            ", Faculty: " + data[8] +
                            ", Level: " + data[9]);
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


    public static void saveFaculty(Faculty f) {
        try {
            FileWriter writer = new FileWriter("faculties.txt", true);
            writer.write(f.getCode() + "," + f.getName() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving faculty: " + e.getMessage());
        }
    }

    public static void listFaculty() {
        try {
            FileReader fr = new FileReader("faculties.txt");
            Scanner sc = new Scanner(fr);

            System.out.println("=== Faculty List ===");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");
                if (data.length == 2) {
                    System.out.println("Code: " + data[0] + ", Name: " + data[1]);
                }
            }

            sc.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("No faculties found or error reading file.");
        }
    }

    public static void saveDepartment(Department d) {
        try {
            // 1️⃣ بررسی وجود دانشکده در faculties.txt
            boolean facultyExists = false;
            Scanner facultyScanner = new Scanner(new FileReader("faculties.txt"));
            while (facultyScanner.hasNextLine()) {
                String line = facultyScanner.nextLine();
                String[] data = line.split(",");
                if (data.length >= 2 && data[0].equals(d.getFacultyCode()) && data[1].equals(d.getFacultyName())) {
                    facultyExists = true;
                    break;
                }
            }
            facultyScanner.close();

            // 2️⃣ اگر دانشکده موجود نبود، اضافه کن
            if (!facultyExists) {
                FileWriter facultyWriter = new FileWriter("faculties.txt", true);
                facultyWriter.write(d.getFacultyCode() + "," + d.getFacultyName() + "\n");
                facultyWriter.close();
                System.out.println("Faculty added to faculties.txt because it did not exist.");
            }

            // 3️⃣ اضافه کردن دپارتمان به فایل departments.txt
            FileWriter writer = new FileWriter("departments.txt", true);
            writer.write(d.getCode() + "," + d.getName() + "," + d.getFacultyCode() + "," + d.getFacultyName() + "\n");
            writer.close();
            System.out.println("Department saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving department: " + e.getMessage());
        }
    }


    public static void listDepartment() {
        try {
            FileReader fr = new FileReader("departments.txt");
            Scanner sc = new Scanner(fr);

            System.out.println("=== Department List ===");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");
                if (data.length == 4) {
                    System.out.println("Code: " + data[0] +
                            ", Name: " + data[1] +
                            ", Faculty Code: " + data[2] +
                            ", Faculty Name: " + data[3]);
                }
            }

            sc.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("No departments found or error reading file.");
        }
    }

    public static void saveMajor(Major m) {
        try {
            // 1️⃣ بررسی وجود دانشکده
            boolean facultyExists = false;
            Scanner facultyScanner = new Scanner(new FileReader("faculties.txt"));
            while (facultyScanner.hasNextLine()) {
                String line = facultyScanner.nextLine();
                String[] data = line.split(",");
                if (data.length >= 2 && data[0].equals(m.getFacultyCode()) && data[1].equals(m.getFacultyName())) {
                    facultyExists = true;
                    break;
                }
            }
            facultyScanner.close();

            if (!facultyExists) {
                FileWriter facultyWriter = new FileWriter("faculties.txt", true);
                facultyWriter.write(m.getFacultyCode() + "," + m.getFacultyName() + "\n");
                facultyWriter.close();
                System.out.println("Faculty added to faculties.txt because it did not exist.");
            }

            // 2️⃣ بررسی وجود دپارتمان
            boolean departmentExists = false;
            Scanner deptScanner = new Scanner(new FileReader("departments.txt"));
            while (deptScanner.hasNextLine()) {
                String line = deptScanner.nextLine();
                String[] data = line.split(",");
                if (data.length >= 4 && data[0].equals(m.getDepartmentCode()) && data[1].equals(m.getDepartmentName())) {
                    departmentExists = true;
                    break;
                }
            }
            deptScanner.close();

            if (!departmentExists) {
                FileWriter deptWriter = new FileWriter("departments.txt", true);
                deptWriter.write(m.getDepartmentCode() + "," + m.getDepartmentName() + "," + m.getFacultyCode() + "," + m.getFacultyName() + "\n");
                deptWriter.close();
                System.out.println("Department added to departments.txt because it did not exist.");
            }

            // 3️⃣ ذخیره رشته تحصیلی در majors.txt
            FileWriter writer = new FileWriter("majors.txt", true);
            writer.write(m.getCode() + "," + m.getName() + "," +
                    m.getDepartmentCode() + "," + m.getDepartmentName() + "," +
                    m.getFacultyCode() + "," + m.getFacultyName() + "," +
                    m.getLevel() + "\n");
            writer.close();
            System.out.println("Major saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving major: " + e.getMessage());
        }
    }



    public static void listMajor() {
        try {
            FileReader fr = new FileReader("majors.txt");
            Scanner sc = new Scanner(fr);

            System.out.println("=== Major List ===");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");
                if (data.length == 7) { // اکنون 7 فیلد داریم
                    System.out.println("Code: " + data[0] +
                            ", Name: " + data[1] +
                            ", Department Code: " + data[2] +
                            ", Department Name: " + data[3] +
                            ", Faculty Code: " + data[4] +
                            ", Faculty Name: " + data[5] +
                            ", Level: " + data[6]);
                }
            }

            sc.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("No majors found or error reading file.");
        }
    }

    public static void updateStudent(String studentId) {
        Scanner input = new Scanner(System.in);

        try {
            Scanner sc = new Scanner(new FileReader("student.txt"));
            String allText = ""; // نگهداری کل متن فایل
            boolean found = false;

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");

                if (data.length == 10 && data[1].equals(studentId)) {
                    System.out.println("Student found:");
                    System.out.println("Name: " + data[0]);
                    System.out.println("Current Email: " + data[2]);
                    System.out.println("Current Phone: " + data[4]);

                    System.out.print("Enter new Email: ");
                    String newEmail = input.nextLine();
                    System.out.print("Enter new Phone: ");
                    String newPhone = input.nextLine();

                    data[2] = newEmail; // جایگزینی ایمیل
                    data[4] = newPhone; // جایگزینی شماره تلفن

                    System.out.println("✅ Student updated successfully!");
                    found = true;
                }

                // بازسازی خط ساده با join کردن رشته‌ها
                allText += String.join(",", data) + "\n";
            }

            sc.close();

            if (found) {
                FileWriter writer = new FileWriter("student.txt"); // بازنویسی فایل
                writer.write(allText);
                writer.close();
            } else {
                System.out.println("No student found with ID: " + studentId);
            }

        } catch (IOException e) {
            System.out.println("Error reading/writing file.");
        }
    }

    public static boolean checkMajorCombination(String facultyName, String departmentName, String majorName, DegreeLevel level) {
        try (Scanner sc = new Scanner(new FileReader("majors.txt"))) { // try-with-resources برای بستن خودکار
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                if (data.length >= 7 &&
                        data[5].equals(facultyName) &&     // Faculty Name
                        data[3].equals(departmentName) &&  // Department Name
                        data[1].equals(majorName) &&       // Major Name
                        data[6].equalsIgnoreCase(level.name())) // 👈 استفاده از enum
                {
                    return true; // ترکیب معتبر است
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // ترکیب وجود ندارد
    }

    // بررسی وجود دپارتمان در فایل departments.txt
    public static boolean checkDepartmentExists(String departmentName) {
        try (Scanner sc = new Scanner(new FileReader("departments.txt"))) {
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                if (data.length >= 2 && data[1].equals(departmentName)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }




}
