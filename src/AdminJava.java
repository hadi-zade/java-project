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

        addStaff.setOnAction(e -> openAddStaffForm(stage));
        showStaff.setOnAction(e -> showStaffList(stage));
        back.setOnAction(e -> start(stage));

        VBox vbox = new VBox(15, addStaff, showStaff, back);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom, #6a11cb, #2575fc);");

        stage.setScene(new Scene(vbox, 500, 400));
    }

    // ===== Add Staff Form =====
    private void openAddStaffForm(Stage stage) {
        Label title = new Label("Add New Staff");
        title.setStyle("-fx-font-size: 20px; -fx-text-fill: white; -fx-font-weight: bold;");

        TextField nameField = new TextField(); nameField.setPromptText("Full Name");
        TextField idField = new TextField(); idField.setPromptText("Staff ID");
        TextField nationalIdField = new TextField(); nationalIdField.setPromptText("National ID"); // جدید
        TextField birthDateField = new TextField(); birthDateField.setPromptText("Birth Date"); // جدید
        TextField emailField = new TextField(); emailField.setPromptText("Email");
        TextField phoneField = new TextField(); phoneField.setPromptText("Phone Number");

        Button saveBtn = new Button("Save Staff");
        Button backBtn = new Button("Back");

        String btnStyle = "-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #6a11cb, #2575fc); "
                + "-fx-background-radius: 20; -fx-padding: 8 15 8 15;";

        saveBtn.setStyle(btnStyle); backBtn.setStyle(btnStyle);

        saveBtn.setOnAction(e -> {
            String name = nameField.getText().trim();
            String id = idField.getText().trim();
            String nationalId = nationalIdField.getText().trim();
            String birthDate = birthDateField.getText().trim();
            String email = emailField.getText().trim();
            String phone = phoneField.getText().trim();

            if(name.isEmpty() || id.isEmpty() || nationalId.isEmpty() || birthDate.isEmpty() || email.isEmpty() || phone.isEmpty()){
                new Alert(Alert.AlertType.WARNING, "Fill all fields!").showAndWait();
                return;
            }

            try(FileWriter fw = new FileWriter("staff2.txt", true)){
                fw.write(name + "," + id + "," + nationalId + "," + birthDate + "," + email + "," + phone + "\n");
            } catch(IOException ex){
                new Alert(Alert.AlertType.ERROR, "Error saving staff!").showAndWait();
                return;
            }

            new Alert(Alert.AlertType.INFORMATION, "Staff saved!").showAndWait();
            nameField.clear(); idField.clear(); nationalIdField.clear(); birthDateField.clear();
            emailField.clear(); phoneField.clear();
        });

        backBtn.setOnAction(e -> openAdminMenu(stage));

        VBox vbox = new VBox(12, title, nameField, idField, nationalIdField, birthDateField, emailField, phoneField, saveBtn, backBtn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom right, #2575fc, #6a11cb); -fx-padding: 20;");

        stage.setScene(new Scene(vbox, 500, 450));
    }

    private void showStaffList(Stage stage) {
        TableView<List<String>> table = new TableView<>();
        TableColumn<List<String>, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(0)));
        TableColumn<List<String>, String> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(1)));
        TableColumn<List<String>, String> nationalIdCol = new TableColumn<>("National ID"); // جدید
        nationalIdCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(2)));
        TableColumn<List<String>, String> birthDateCol = new TableColumn<>("Birth Date"); // جدید
        birthDateCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(3)));
        TableColumn<List<String>, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(4)));
        TableColumn<List<String>, String> phoneCol = new TableColumn<>("Phone");
        phoneCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(5)));
        table.getColumns().addAll(nameCol,idCol,nationalIdCol,birthDateCol,emailCol,phoneCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        try (Scanner sc = new Scanner(new File("staff2.txt"))) {
            while(sc.hasNextLine()){
                String[] arr = sc.nextLine().split(",");
                if(arr.length>=6) table.getItems().add(Arrays.asList(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]));
            }
        } catch(IOException e){}

        Button backBtn = new Button("Back");
        backBtn.setStyle("-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #43cea2, #185a9d); "
                + "-fx-background-radius: 20; -fx-padding: 8 15 8 15;");
        backBtn.setOnAction(e -> openAdminMenu(stage));

        VBox vbox = new VBox(15, table, backBtn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom, #6a11cb, #2575fc); -fx-padding: 15;");
        stage.setScene(new Scene(vbox, 700, 450));
    }

    // ===== Student Menu =====
    private void openStudentMenu(Stage stage) {
        Button addStudent = new Button("Add Student");
        Button back = new Button("Back");

        String btnStyle = "-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #ff758c, #ff7eb3); "
                + "-fx-background-radius: 20; -fx-padding: 8 15 8 15;";
        addStudent.setStyle(btnStyle); back.setStyle(btnStyle);

        addStudent.setOnAction(e -> openAddStaffLikeForm(stage,"student.txt","Student"));
        back.setOnAction(e -> start(stage));

        VBox vbox = new VBox(15, addStudent, back);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom, #2575fc, #6a11cb);");
        stage.setScene(new Scene(vbox, 500, 400));
    }

    // ===== Staff Menu =====
    private void openStaffMenu(Stage stage) {
        Button addProfessorBtn = new Button("Add Professor");
        Button addStudentBtn = new Button("Add Student");
        Button showProfessorsBtn = new Button("Show Professor List");
        Button showStudentsBtn = new Button("Show Student List");
        Button searchStudentBtn = new Button("Search Student");
        Button backBtn = new Button("Back");

        String btnStyle = "-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #43cea2, #185a9d); "
                + "-fx-background-radius: 20; -fx-padding: 8 15 8 15;";

        addProfessorBtn.setStyle(btnStyle); addStudentBtn.setStyle(btnStyle);
        showProfessorsBtn.setStyle(btnStyle); showStudentsBtn.setStyle(btnStyle);
        searchStudentBtn.setStyle(btnStyle); backBtn.setStyle(btnStyle);

        addProfessorBtn.setOnAction(e -> openAddStaffLikeForm(stage,"professor.txt","Professor"));
        addStudentBtn.setOnAction(e -> openAddStaffLikeForm(stage,"student.txt","Student"));
        showProfessorsBtn.setOnAction(e -> showPersonList(stage,"professor.txt","Professor List"));
        showStudentsBtn.setOnAction(e -> showPersonList(stage,"student.txt","Student List"));
        searchStudentBtn.setOnAction(e -> searchStudentById(stage));
        backBtn.setOnAction(e -> start(stage));

        VBox vbox = new VBox(12, addProfessorBtn, addStudentBtn, showProfessorsBtn,
                showStudentsBtn, searchStudentBtn, backBtn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom right, #185a9d, #43cea2); -fx-padding: 20;");
        stage.setScene(new Scene(vbox, 500, 450));
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

    // ===== Add Staff/Student/Professor Form =====
    private void openAddStaffLikeForm(Stage stage,String filename,String titleStr){
        Label title = new Label("Add New " + titleStr);
        title.setStyle("-fx-font-size: 20px; -fx-text-fill: white; -fx-font-weight: bold;");

        TextField name = new TextField(); name.setPromptText("Full Name");
        TextField id = new TextField(); id.setPromptText("ID");
        TextField nationalId = new TextField(); nationalId.setPromptText("National ID"); // جدید
        TextField birthDate = new TextField(); birthDate.setPromptText("Birth Date"); // جدید
        TextField email = new TextField(); email.setPromptText("Email");
        TextField phone = new TextField(); phone.setPromptText("Phone Number");

        Button save = new Button("Save " + titleStr);
        Button back = new Button("Back");

        String btnStyle = "-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #6a11cb, #2575fc); -fx-background-radius: 20; -fx-padding: 8 15 8 15;";
        save.setStyle(btnStyle); back.setStyle(btnStyle);

        save.setOnAction(e -> {
            if(name.getText().isEmpty() || id.getText().isEmpty() || nationalId.getText().isEmpty() || birthDate.getText().isEmpty() || email.getText().isEmpty() || phone.getText().isEmpty()){
                new Alert(Alert.AlertType.WARNING,"Fill all fields!").showAndWait(); return;
            }
            try(FileWriter fw = new FileWriter(filename,true)){
                fw.write(name.getText()+","+id.getText()+","+nationalId.getText()+","+birthDate.getText()+","+email.getText()+","+phone.getText()+"\n");
            } catch(IOException ex){ new Alert(Alert.AlertType.ERROR,"Error saving!").showAndWait(); return; }
            new Alert(Alert.AlertType.INFORMATION,titleStr+" saved!").showAndWait();
            name.clear(); id.clear(); nationalId.clear(); birthDate.clear(); email.clear(); phone.clear();
        });

        back.setOnAction(e -> openStaffMenu(stage));

        VBox vbox = new VBox(12,title,name,id,nationalId,birthDate,email,phone,save,back);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom right, #2575fc, #6a11cb); -fx-padding: 20;");
        stage.setScene(new Scene(vbox,500,450));
    }

    // ===== Show Person List Table =====
    private void showPersonList(Stage stage, String filename, String titleStr){
        TableView<List<String>> table = new TableView<>();
        TableColumn<List<String>, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(0)));
        TableColumn<List<String>, String> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(1)));
        TableColumn<List<String>, String> nationalIdCol = new TableColumn<>("کد ملی"); // جدید
        nationalIdCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(2)));
        TableColumn<List<String>, String> birthDateCol = new TableColumn<>("تاریخ تولد"); // جدید
        birthDateCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(3)));
        TableColumn<List<String>, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(4)));
        TableColumn<List<String>, String> phoneCol = new TableColumn<>("Phone");
        phoneCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(5)));
        table.getColumns().addAll(nameCol,idCol,nationalIdCol,birthDateCol,emailCol,phoneCol);
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
        stage.setScene(new Scene(vbox, 700, 450));
    }

    // ===== Search Student by ID =====
    private void searchStudentById(Stage stage){
        Label title = new Label("Search Student by ID");
        title.setStyle("-fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight: bold;");
        TextField idField = new TextField();
        idField.setPromptText("Enter Student ID");

        Button searchBtn = new Button("Search");
        Button backBtn = new Button("Back");

        String btnStyle = "-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #ff758c, #ff7eb3); "
                + "-fx-background-radius: 20; -fx-padding: 8 15 8 15;";
        searchBtn.setStyle(btnStyle);
        backBtn.setStyle(btnStyle);

        Label result = new Label();
        result.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");

        searchBtn.setOnAction(e -> {
            String id = idField.getText().trim();
            if(id.isEmpty()){
                result.setText("Please enter Student ID!");
                return;
            }
            boolean found = false;
            try(Scanner sc = new Scanner(new File("student.txt"))){
                while(sc.hasNextLine()){
                    String[] arr = sc.nextLine().split(",");
                    if(arr.length>=6 && arr[1].equals(id)){
                        result.setText("Found: Name="+arr[0]+", ID="+arr[1]+
                                ", کد ملی="+arr[2]+", تاریخ تولد="+arr[3]+
                                ", Email="+arr[4]+", Phone="+arr[5]);
                        found = true;
                        break;
                    }
                }
            } catch(IOException ex){
                result.setText("Error reading file!");
                return;
            }
            if(!found) result.setText("Student not found!");
        });

        backBtn.setOnAction(e -> openStaffMenu(stage));

        VBox vbox = new VBox(12, title, idField, searchBtn, result, backBtn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom right, #6a11cb, #2575fc); -fx-padding: 20;");
        stage.setScene(new Scene(vbox, 600, 400));
    }

    // ===== Add Course Form =====
    private void openAddCourseForm(Stage stage) {
        Label title = new Label("Add New Course");
        title.setStyle("-fx-font-size: 20px; -fx-text-fill: white; -fx-font-weight: bold;");

        TextField courseName = new TextField(); courseName.setPromptText("Course Name");
        TextField courseCode = new TextField(); courseCode.setPromptText("Course Code");
        TextField unit = new TextField(); unit.setPromptText("Units");

        Button saveBtn = new Button("Save Course");
        Button backBtn = new Button("Back");

        String btnStyle = "-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #ff758c, #ff7eb3); "
                + "-fx-background-radius: 20; -fx-padding: 8 15 8 15;";
        saveBtn.setStyle(btnStyle);
        backBtn.setStyle(btnStyle);

        saveBtn.setOnAction(e -> {
            if(courseName.getText().isEmpty() || courseCode.getText().isEmpty() || unit.getText().isEmpty()){
                new Alert(Alert.AlertType.WARNING,"Fill all fields!").showAndWait();
                return;
            }
            try(FileWriter fw = new FileWriter("courses.txt",true)){
                fw.write(courseName.getText()+","+courseCode.getText()+","+unit.getText()+"\n");
            } catch(IOException ex){
                new Alert(Alert.AlertType.ERROR,"Error saving course!").showAndWait();
                return;
            }
            new Alert(Alert.AlertType.INFORMATION,"Course saved!").showAndWait();
            courseName.clear(); courseCode.clear(); unit.clear();
        });

        backBtn.setOnAction(e -> openProfessorMenu(stage));

        VBox vbox = new VBox(12, title, courseName, courseCode, unit, saveBtn, backBtn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom, #ff7eb3, #ff758c); -fx-padding: 20;");
        stage.setScene(new Scene(vbox, 500, 400));
    }

    // ===== Show Course Table =====
    private void showCourseTable(Stage stage) {
        TableView<List<String>> table = new TableView<>();
        TableColumn<List<String>, String> nameCol = new TableColumn<>("Course Name");
        nameCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(0)));
        TableColumn<List<String>, String> codeCol = new TableColumn<>("Course Code");
        codeCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(1)));
        TableColumn<List<String>, String> unitCol = new TableColumn<>("Units");
        unitCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(2)));
        table.getColumns().addAll(nameCol,codeCol,unitCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        try(Scanner sc = new Scanner(new File("courses.txt"))){
            while(sc.hasNextLine()){
                String[] arr = sc.nextLine().split(",");
                if(arr.length>=3) table.getItems().add(Arrays.asList(arr[0],arr[1],arr[2]));
            }
        } catch(IOException e){}

        Button backBtn = new Button("Back");
        backBtn.setStyle("-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #185a9d, #43cea2); "
                + "-fx-background-radius: 20; -fx-padding: 8 15 8 15;");
        backBtn.setOnAction(e -> openProfessorMenu(stage));

        VBox vbox = new VBox(15, table, backBtn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom, #2575fc, #6a11cb); -fx-padding: 15;");
        stage.setScene(new Scene(vbox, 600, 400));
    }

    public static void main(String[] args) {
        launch(args);
    }
}

