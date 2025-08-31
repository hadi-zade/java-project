import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);

    public void first() {
        while (true) {
            System.out.println("....[[[Welcome]]]....\n");
            System.out.println("Main Menu");
            System.out.println("1. Admin");
            System.out.println("2. Student");
            System.out.println("3. staff");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    adminLogin();
                    break;
                case "2":
                    studentMenu();
                    break;
                case "3":
                    staffMenu();
                    break;
                case "0":
                    System.out.println("!!End!!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Wrong option!");
            }
            System.out.println("......");
        }
    }

    private void adminLogin() {
        System.out.print("Enter username: ");
        String username = sc.nextLine().trim();

        System.out.print("Enter password: ");
        String password = sc.nextLine().trim();

        if (username.equals("admin") && password.equals("1234")) {
            System.out.println("Login successful! Welcome Admin.");
            adminMenu();
        } else {
            System.out.println("Login failed! Wrong username or password.");
        }
    }

    // منوی ادمین
    private void adminMenu() {
        while (true) {
            System.out.println("<Admin Menu>");
            System.out.println("1. Add staff");
            System.out.println("2. Show staff list"); // گزینه جدید
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("staff Name: ");
                    String name = sc.nextLine();
                    System.out.print("staff ID: ");
                    String id = sc.nextLine();
                    System.out.print("staff email: ");
                    String email = sc.nextLine();
                    System.out.print("staff nationalId: ");
                    String nationalId = sc.nextLine();
                    System.out.print("staff phoneNumber: ");
                    String phoneNumber = sc.nextLine();
                    System.out.print("staff birthDayt: ");
                    String birthDayt = sc.nextLine();

                    Staff s = new Staff(name, id, email, nationalId, phoneNumber, birthDayt);
                    System.out.println("***staff added***:");
                    s.showInfo();
                    FileManager.saveStaff(s);
                    System.out.println("***staff saved to person.txt***");
                    break;

                case "2": // گزینه جدید
                    FileManager.listStaff();
                    break;

                case "0":
                    return;
                default:
                    System.out.println("Wrong option!");
            }
            System.out.println("------");
        }
    }

    public void studentMenu() {
        while (true) {
            System.out.println("<Student Menu>");
            System.out.println("1. Add Student");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Student Name: ");
                    String name = sc.nextLine();
                    System.out.print("Student ID: ");
                    String id = sc.nextLine();
                    System.out.print("Student email: ");
                    String email = sc.nextLine();
                    System.out.print("Student nationalId: ");
                    String nationalId = sc.nextLine();
                    System.out.print("Student phoneNumber: ");
                    String phoneNumber = sc.nextLine();
                    System.out.print("Student brithDayte: ");
                    String brithDayte = sc.nextLine();
                    System.out.print("Student Major: ");
                    String major = sc.nextLine();
                    System.out.print("Student Department:");
                    String department = sc.nextLine();
                    System.out.print("Student Faculty:");
                    String faculty = sc.nextLine();




                    Student s = new Student(name, id, email, nationalId, phoneNumber, brithDayte, major, department, faculty);
                    System.out.println("*** Student added ***");
                    s.showInfo();
                    FileManager.saveStudent(s);
                    System.out.println("Student saved to student.txt");
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Wrong option!");
            }
            System.out.println("------");
        }
    }

    public void staffMenu() {
        while (true) {
            System.out.println("<Staff Menu>");
            System.out.println("1. Add professor");
            System.out.println("2. Add student");
            System.out.println("3. Show professor list"); // گزینه جدید
            System.out.println("4. Show student list");   // گزینه جدید
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("professor Name: ");
                    String name = sc.nextLine();
                    System.out.print("professor ID: ");
                    String id = sc.nextLine();
                    System.out.print("professor email: ");
                    String email = sc.nextLine();
                    System.out.print("professor nationalId: ");
                    String nationalId = sc.nextLine();
                    System.out.print("professor phoneNumber: ");
                    String phoneNumber = sc.nextLine();
                    System.out.print("professor birthDayt: ");
                    String birthDayt = sc.nextLine();
                    System.out.print("professor Department: ");
                    String department_P = sc.nextLine();



                    Professor p = new Professor(name, id, email, nationalId, phoneNumber, birthDayt, department_P);
                    System.out.println("professor added:");
                    p.showInfo();
                    FileManager.saveProfessor(p);
                    System.out.println("professor saved to professor.txt");
                    break;

                case "2":
                    System.out.print("student Name: ");
                    String nam = sc.nextLine();
                    System.out.print("student ID: ");
                    String Id = sc.nextLine();
                    System.out.print("student email: ");
                    String Email = sc.nextLine();
                    System.out.print("student nationalId: ");
                    String NationalId = sc.nextLine();
                    System.out.print("student phoneNumber: ");
                    String PhoneNumber = sc.nextLine();
                    System.out.print("student birthDayt: ");
                    String BirthDayt = sc.nextLine();
                    System.out.print("student Major: ");
                    String major = sc.nextLine();
                    System.out.print("student Department:");
                    String department = sc.nextLine();
                    System.out.print("student Faculty:");
                    String faculty = sc.nextLine();





                    Student s = new Student(nam, Id, Email, NationalId, PhoneNumber, BirthDayt, major, department, faculty);
                    System.out.println("student added:");
                    s.showInfo();
                    FileManager.saveStudent(s);
                    System.out.println("student saved to student.txt");
                    break;

                case "3": // گزینه جدید
                    FileManager.listProfessor();
                    break;

                case "4": // گزینه جدید
                    FileManager.listStudent();
                    break;

                case "0":
                    return;

                default:
                    System.out.println("Wrong option!");
            }
            System.out.println("------");
        }
    }

}