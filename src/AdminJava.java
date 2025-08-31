import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class AdminJava extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("University Management System");

        Button adminBtn = new Button("Admin Menu");
        Button studentBtn = new Button("Student Menu");
        Button staffBtn = new Button("Staff Menu");
        Button professorBtn = new Button("Professor Menu");
        Button exitBtn = new Button("Exit");

        String buttonStyle = "-fx-font-size: 16px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #6a11cb, #2575fc); "
                + "-fx-background-radius: 20; -fx-padding: 10 20 10 20;";

        adminBtn.setStyle(buttonStyle);
        studentBtn.setStyle(buttonStyle);
        staffBtn.setStyle(buttonStyle);
        professorBtn.setStyle(buttonStyle);
        exitBtn.setStyle(buttonStyle);

        adminBtn.setOnAction(e -> openAdminMenu(primaryStage));
        studentBtn.setOnAction(e -> openStudentMenu(primaryStage));
        staffBtn.setOnAction(e -> openStaffMenu(primaryStage));
        professorBtn.setOnAction(e -> openProfessorMenu(primaryStage));
        exitBtn.setOnAction(e -> primaryStage.close());

        VBox vbox = new VBox(20, adminBtn, studentBtn, staffBtn, professorBtn, exitBtn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom, #2575fc, #6a11cb);");

        primaryStage.setScene(new Scene(vbox, 500, 450));
        primaryStage.show();
    }

    // ===== Admin Menu =====
    private void openAdminMenu(Stage stage) {
        Button addStaff = new Button("Add Staff");
        Button showStaff = new Button("Show Staff List");
        Button back = new Button("Back");

        String buttonStyle = "-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #43cea2, #185a9d); "
                + "-fx-background-radius: 20; -fx-padding: 8 15 8 15;";
        addStaff.setStyle(buttonStyle);
        showStaff.setStyle(buttonStyle);
        back.setStyle(buttonStyle);

        addStaff.setOnAction(e -> openAddStaffLikeForm(stage,"staff.txt","Staff"));
        showStaff.setOnAction(e -> showPersonList(stage,"staff.txt","Staff List"));
        back.setOnAction(e -> start(stage));

        VBox vbox = new VBox(15, addStaff, showStaff, back);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom, #6a11cb, #2575fc);");

        stage.setScene(new Scene(vbox, 500, 400));
    }

    // ===== Student Menu =====
    private void openStudentMenu(Stage stage) {
        Button addStudent = new Button("Add Student");
        Button showStudent = new Button("Show Student List");
        Button back = new Button("Back");

        String btnStyle = "-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #ff758c, #ff7eb3); "
                + "-fx-background-radius: 20; -fx-padding: 8 15 8 15;";
        addStudent.setStyle(btnStyle); showStudent.setStyle(btnStyle); back.setStyle(btnStyle);

        addStudent.setOnAction(e -> openAddStaffLikeForm(stage,"student.txt","Student"));
        showStudent.setOnAction(e -> showPersonList(stage,"student.txt","Student List"));
        back.setOnAction(e -> start(stage));

        VBox vbox = new VBox(15, addStudent, showStudent, back);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom, #2575fc, #6a11cb);");
        stage.setScene(new Scene(vbox, 500, 400));
    }

    // ===== Staff Menu (با Edit) =====
    private void openStaffMenu(Stage stage) {
        Button addProfessorBtn = new Button("Add Professor");
        Button addStudentBtn = new Button("Add Student");
        Button showProfessorsBtn = new Button("Show Professor List");
        Button showStudentsBtn = new Button("Show Student List");
        Button searchStudentBtn = new Button("Search Student");
        Button editStudentBtn = new Button("Edit Student");
        Button editProfessorBtn = new Button("Edit Professor");
        Button backBtn = new Button("Back");

        String btnStyle = "-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #43cea2, #185a9d); "
                + "-fx-background-radius: 20; -fx-padding: 8 15 8 15;";

        addProfessorBtn.setStyle(btnStyle);
        addStudentBtn.setStyle(btnStyle);
        showProfessorsBtn.setStyle(btnStyle);
        showStudentsBtn.setStyle(btnStyle);
        searchStudentBtn.setStyle(btnStyle);
        editStudentBtn.setStyle(btnStyle);
        editProfessorBtn.setStyle(btnStyle);
        backBtn.setStyle(btnStyle);

        addProfessorBtn.setOnAction(e -> openAddStaffLikeForm(stage,"professor.txt","Professor"));
        addStudentBtn.setOnAction(e -> openAddStaffLikeForm(stage,"student.txt","Student"));
        showProfessorsBtn.setOnAction(e -> showPersonList(stage,"professor.txt","Professor List"));
        showStudentsBtn.setOnAction(e -> showPersonList(stage,"student.txt","Student List"));
        searchStudentBtn.setOnAction(e -> searchStudentById(stage));
        editStudentBtn.setOnAction(e -> openEditPersonForm(stage,"student.txt","Student"));
        editProfessorBtn.setOnAction(e -> openEditPersonForm(stage,"professor.txt","Professor"));
        backBtn.setOnAction(e -> start(stage));

        VBox vbox = new VBox(12, addProfessorBtn, addStudentBtn, showProfessorsBtn,
                showStudentsBtn, searchStudentBtn, editStudentBtn, editProfessorBtn, backBtn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom right, #185a9d, #43cea2); -fx-padding: 20;");
        stage.setScene(new Scene(vbox, 500, 500));
    }

    // ===== Professor Menu =====
    private void openProfessorMenu(Stage stage) {
        Button addCourse = new Button("Add Course");
        Button showCourses = new Button("Show Courses");
        Button back = new Button("Back");

        String btnStyle = "-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #ff758c, #ff7eb3); "
                + "-fx-background-radius: 20; -fx-padding: 8 15 8 15;";

        addCourse.setStyle(btnStyle); showCourses.setStyle(btnStyle); back.setStyle(btnStyle);

        addCourse.setOnAction(e -> openAddCourseForm(stage));
        showCourses.setOnAction(e -> showCourseTable(stage));
        back.setOnAction(e -> start(stage));

        VBox vbox = new VBox(15, addCourse, showCourses, back);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom, #ff7eb3, #ff758c);");

        stage.setScene(new Scene(vbox, 500, 400));
    }

    // ===== Add Form for Student/Staff/Professor =====
    private void openAddStaffLikeForm(Stage stage, String filename, String titleStr){
        Label title = new Label("Add New " + titleStr);
        title.setStyle("-fx-font-size: 20px; -fx-text-fill: white; -fx-font-weight: bold;");

        TextField name = new TextField(); name.setPromptText("Full Name");
        TextField nationalId = new TextField(); nationalId.setPromptText("National ID");
        TextField userId = new TextField(); userId.setPromptText("User ID");
        TextField email = new TextField(); email.setPromptText("Email");
        TextField phone = new TextField(); phone.setPromptText("Phone Number");
        TextField birthDate = new TextField(); birthDate.setPromptText("Birth Date (YYYY-MM-DD)");

        Button save = new Button("Save " + titleStr);
        Button back = new Button("Back");

        String btnStyle = "-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #6a11cb, #2575fc); -fx-background-radius: 20; -fx-padding: 8 15 8 15;";
        save.setStyle(btnStyle); back.setStyle(btnStyle);

        save.setOnAction(e -> {
            if(name.getText().isEmpty() || nationalId.getText().isEmpty() || userId.getText().isEmpty()
                    || email.getText().isEmpty() || phone.getText().isEmpty() || birthDate.getText().isEmpty()){
                new Alert(Alert.AlertType.WARNING,"Fill all fields!").showAndWait(); return;
            }
            try(FileWriter fw = new FileWriter(filename,true)){
                fw.write(name.getText()+","+nationalId.getText()+","+userId.getText()+","+email.getText()+","+phone.getText()+","+birthDate.getText()+"\n");
            } catch(IOException ex){ new Alert(Alert.AlertType.ERROR,"Error saving!").showAndWait(); return; }
            new Alert(Alert.AlertType.INFORMATION,titleStr+" saved!").showAndWait();
            name.clear(); nationalId.clear(); userId.clear(); email.clear(); phone.clear(); birthDate.clear();
        });

        back.setOnAction(e -> openStaffMenu(stage));

        VBox vbox = new VBox(12,title,name,nationalId,userId,email,phone,birthDate,save,back);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom right, #2575fc, #6a11cb); -fx-padding: 20;");
        stage.setScene(new Scene(vbox,500,500));
    }

    // ===== Show Person List Table =====
    private void showPersonList(Stage stage, String filename, String titleStr){
        TableView<List<String>> table = new TableView<>();
        String[] headers = {"Full Name","National ID","User ID","Email","Phone","Birth Date"};
        for(int i=0;i<headers.length;i++){
            final int idx = i;
            TableColumn<List<String>, String> col = new TableColumn<>(headers[i]);
            col.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(idx)));
            table.getColumns().add(col);
        }
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        try (Scanner sc = new Scanner(new File(filename))) {
            while(sc.hasNextLine()){
                String[] arr = sc.nextLine().split(",");
                if(arr.length>=6) table.getItems().add(Arrays.asList(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]));
            }
        } catch(IOException e){}

        Button backBtn = new Button("Back");
        backBtn.setStyle("-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #43cea2, #185a9d); "
                + "-fx-background-radius: 20; -fx-padding: 8 15 8 15;");
        backBtn.setOnAction(e -> openStaffMenu(stage));

        VBox vbox = new VBox(15, table, backBtn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom right, #43cea2, #185a9d); -fx-padding: 15;");
        stage.setScene(new Scene(vbox, 700, 500));
    }

    // ===== Search Student by ID =====
    private void searchStudentById(Stage stage){
        Label title = new Label("Search Student by ID");
        title.setStyle("-fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight: bold;");

        TextField idField = new TextField(); idField.setPromptText("Enter Student ID");
        TableView<List<String>> resultTable = new TableView<>();

        String[] headers = {"Full Name","National ID","User ID","Email","Phone","Birth Date"};
        for(int i=0;i<headers.length;i++){
            final int idx = i;
            TableColumn<List<String>, String> col = new TableColumn<>(headers[i]);
            col.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(idx)));
            resultTable.getColumns().add(col);
        }
        resultTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Button searchBtn = new Button("Search");
        Button backBtn = new Button("Back");
        String btnStyle = "-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #43cea2, #185a9d); "
                + "-fx-background-radius: 20; -fx-padding: 8 15 8 15;";

        searchBtn.setStyle(btnStyle); backBtn.setStyle(btnStyle);

        searchBtn.setOnAction(e -> {
            resultTable.getItems().clear();
            String id = idField.getText().trim();
            if(id.isEmpty()){ new Alert(Alert.AlertType.WARNING,"Enter ID!").showAndWait(); return; }
            try (Scanner sc = new Scanner(new File("student.txt"))) {
                boolean found = false;
                while(sc.hasNextLine()){
                    String[] arr = sc.nextLine().split(",");
                    if(arr.length>=6 && arr[2].equals(id)){
                        resultTable.getItems().add(Arrays.asList(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]));
                        found = true; break;
                    }
                }
                if(!found) new Alert(Alert.AlertType.INFORMATION,"Student not found!").showAndWait();
            } catch(IOException ex){ new Alert(Alert.AlertType.ERROR,"Error reading file!").showAndWait(); }
        });

        backBtn.setOnAction(e -> openStaffMenu(stage));

        VBox vbox = new VBox(12, title, idField, searchBtn, resultTable, backBtn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom right, #43cea2, #185a9d); -fx-padding: 20;");
        stage.setScene(new Scene(vbox, 700, 500));
    }

    // ===== Edit Form for Student/Professor =====
    private void openEditPersonForm(Stage stage, String filename, String titleStr) {
        Label title = new Label("Edit " + titleStr + " Info");
        title.setStyle("-fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight: bold;");

        TextField idField = new TextField();
        idField.setPromptText(titleStr + " ID");

        TextField emailField = new TextField();
        emailField.setPromptText("New Email");

        TextField phoneField = new TextField();
        phoneField.setPromptText("New Phone");

        Button searchBtn = new Button("Search");
        Button saveBtn = new Button("Save Changes");
        Button backBtn = new Button("Back");

        String btnStyle = "-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #43cea2, #185a9d); "
                + "-fx-background-radius: 20; -fx-padding: 8 15 8 15;";
        searchBtn.setStyle(btnStyle); saveBtn.setStyle(btnStyle); backBtn.setStyle(btnStyle);

        final List<String>[] foundData = new List[1];

        searchBtn.setOnAction(e -> {
            foundData[0] = null;
            try (Scanner sc = new Scanner(new File(filename))) {
                while (sc.hasNextLine()) {
                    String[] arr = sc.nextLine().split(",");
                    if (arr.length >= 6 && arr[2].equals(idField.getText().trim())) {
                        foundData[0] = new ArrayList<>(Arrays.asList(arr));
                        emailField.setText(arr[3]);
                        phoneField.setText(arr[4]);
                        new Alert(Alert.AlertType.INFORMATION, titleStr + " found!").showAndWait();
                        return;
                    }
                }
                new Alert(Alert.AlertType.WARNING, titleStr + " not found!").showAndWait();
            } catch (IOException ex) {
                new Alert(Alert.AlertType.ERROR, "Error reading file!").showAndWait();
            }
        });

        saveBtn.setOnAction(e -> {
            if (foundData[0] == null) {
                new Alert(Alert.AlertType.WARNING, "Search first!").showAndWait();
                return;
            }
            // تغییر ایمیل و تلفن
            foundData[0].set(3, emailField.getText().trim());
            foundData[0].set(4, phoneField.getText().trim());

            // بازنویسی فایل
            List<String> lines = new ArrayList<>();
            try (Scanner sc = new Scanner(new File(filename))) {
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] arr = line.split(",");
                    if (arr.length >= 6 && arr[2].equals(idField.getText().trim())) {
                        lines.add(String.join(",", foundData[0]));
                    } else {
                        lines.add(line);
                    }
                }
            } catch (IOException ex) {
                new Alert(Alert.AlertType.ERROR, "Error reading file!").showAndWait();
                return;
            }

            try (FileWriter fw = new FileWriter(filename)) {
                for (String l : lines) fw.write(l + "\n");
            } catch (IOException ex) {
                new Alert(Alert.AlertType.ERROR, "Error saving file!").showAndWait();
                return;
            }
            new Alert(Alert.AlertType.INFORMATION, "Changes saved!").showAndWait();
            emailField.clear(); phoneField.clear(); idField.clear();
            foundData[0] = null;
        });

        backBtn.setOnAction(e -> openStaffMenu(stage));

        VBox vbox = new VBox(12, title, idField, searchBtn, emailField, phoneField, saveBtn, backBtn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom right, #43cea2, #185a9d); -fx-padding: 20;");
        stage.setScene(new Scene(vbox, 600, 400));
    }

    // ===== Professor Course Management =====
    private void openAddCourseForm(Stage stage){
        Label title = new Label("Add New Course");
        title.setStyle("-fx-font-size: 20px; -fx-text-fill: white; -fx-font-weight: bold;");

        TextField courseName = new TextField(); courseName.setPromptText("Course Name");
        TextField courseId = new TextField(); courseId.setPromptText("Course ID");

        Button saveBtn = new Button("Save Course");
        Button backBtn = new Button("Back");

        String btnStyle = "-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #ff758c, #ff7eb3); "
                + "-fx-background-radius: 20; -fx-padding: 8 15 8 15;";

        saveBtn.setStyle(btnStyle); backBtn.setStyle(btnStyle);

        saveBtn.setOnAction(e -> {
            if(courseName.getText().isEmpty() || courseId.getText().isEmpty()){
                new Alert(Alert.AlertType.WARNING,"Fill all fields!").showAndWait(); return;
            }
            try(FileWriter fw = new FileWriter("courses.txt",true)){
                fw.write(courseName.getText()+","+courseId.getText()+"\n");
            } catch(IOException ex){ new Alert(Alert.AlertType.ERROR,"Error saving course!").showAndWait(); return; }
            new Alert(Alert.AlertType.INFORMATION,"Course saved!").showAndWait();
            courseName.clear(); courseId.clear();
        });

        backBtn.setOnAction(e -> openProfessorMenu(stage));

        VBox vbox = new VBox(12,title,courseName,courseId,saveBtn,backBtn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom right, #ff7eb3, #ff758c); -fx-padding: 20;");
        stage.setScene(new Scene(vbox,500,400));
    }

    private void showCourseTable(Stage stage){
        TableView<List<String>> table = new TableView<>();
        TableColumn<List<String>, String> nameCol = new TableColumn<>("Course Name");
        nameCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(0)));
        TableColumn<List<String>, String> idCol = new TableColumn<>("Course ID");
        idCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(1)));
        table.getColumns().addAll(nameCol,idCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        try (Scanner sc = new Scanner(new File("courses.txt"))) {
            while(sc.hasNextLine()){
                String[] arr = sc.nextLine().split(",");
                if(arr.length>=2) table.getItems().add(Arrays.asList(arr[0],arr[1]));
            }
        } catch(IOException e){}

        Button backBtn = new Button("Back");
        backBtn.setStyle("-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #ff758c, #ff7eb3); "
                + "-fx-background-radius: 20; -fx-padding: 8 15 8 15;");
        backBtn.setOnAction(e -> openProfessorMenu(stage));

        VBox vbox = new VBox(15, table, backBtn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom right, #ff7eb3, #ff758c); -fx-padding: 15;");
        stage.setScene(new Scene(vbox, 600, 450));
    }

    public static void main(String[] args) {
        launch(args);
    }
}