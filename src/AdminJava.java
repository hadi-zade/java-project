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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        TextField emailField = new TextField(); emailField.setPromptText("Email");
        TextField phoneField = new TextField(); phoneField.setPromptText("Phone Number");
        TextField deptField = new TextField(); deptField.setPromptText("Department");

        Button saveBtn = new Button("Save Staff");
        Button backBtn = new Button("Back");

        String btnStyle = "-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #6a11cb, #2575fc); "
                + "-fx-background-radius: 20; -fx-padding: 8 15 8 15;";

        saveBtn.setStyle(btnStyle); backBtn.setStyle(btnStyle);

        saveBtn.setOnAction(e -> {
            String name = nameField.getText().trim();
            String id = idField.getText().trim();
            String email = emailField.getText().trim();
            String phone = phoneField.getText().trim();
            String dept = deptField.getText().trim();

            if(name.isEmpty() || id.isEmpty() || email.isEmpty() || phone.isEmpty() || dept.isEmpty()){
                new Alert(Alert.AlertType.WARNING, "Fill all fields!").showAndWait();
                return;
            }

            try(FileWriter fw = new FileWriter("staff2.txt", true)){
                fw.write(name + "," + id + "," + email + "," + phone + "," + dept + "\n");
            } catch(IOException ex){
                new Alert(Alert.AlertType.ERROR, "Error saving staff!").showAndWait();
                return;
            }

            new Alert(Alert.AlertType.INFORMATION, "Staff saved!").showAndWait();
            nameField.clear(); idField.clear(); emailField.clear(); phoneField.clear(); deptField.clear();
        });

        backBtn.setOnAction(e -> openAdminMenu(stage));

        VBox vbox = new VBox(12, title, nameField, idField, emailField, phoneField, deptField, saveBtn, backBtn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom right, #2575fc, #6a11cb); -fx-padding: 20;");

        stage.setScene(new Scene(vbox, 500, 450));
    }

    private void showStaffList(Stage stage) {
        TextArea ta = new TextArea(); ta.setEditable(false);
        try(Scanner sc = new Scanner(new File("staff2.txt"))){
            while(sc.hasNextLine()) ta.appendText(sc.nextLine() + "\n");
        } catch(IOException e){ ta.setText("No staff found."); }
        Button back = new Button("Back"); back.setOnAction(e -> openAdminMenu(stage));

        VBox vbox = new VBox(10, ta, back); vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom, #6a11cb, #2575fc); -fx-padding: 15;");
        stage.setScene(new Scene(vbox, 500, 400));
    }

    // ===== Student Menu =====
    private void openStudentMenu(Stage stage) {
        Button addStudent = new Button("Add Student");
        Button back = new Button("Back");

        String btnStyle = "-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #ff758c, #ff7eb3); "
                + "-fx-background-radius: 20; -fx-padding: 8 15 8 15;";
        addStudent.setStyle(btnStyle); back.setStyle(btnStyle);

        addStudent.setOnAction(e -> openAddStudentForm(stage));
        back.setOnAction(e -> start(stage));

        VBox vbox = new VBox(15, addStudent, back);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom, #2575fc, #6a11cb);");
        stage.setScene(new Scene(vbox, 500, 400));
    }

    // ===== Staff Menu =====
    private void openStaffMenu(Stage stage) {
        Button addProfessor = new Button("Add Professor");
        Button addStudent = new Button("Add Student");
        Button showProfessors = new Button("Show Professor List");
        Button showStudents = new Button("Show Student List");
        Button searchStudent = new Button("Search Student");
        Button back = new Button("Back");

        String btnStyle = "-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #43cea2, #185a9d); "
                + "-fx-background-radius: 20; -fx-padding: 8 15 8 15;";

        addProfessor.setStyle(btnStyle); addStudent.setStyle(btnStyle); showProfessors.setStyle(btnStyle);
        showStudents.setStyle(btnStyle); searchStudent.setStyle(btnStyle); back.setStyle(btnStyle);

        addProfessor.setOnAction(e -> openAddProfessorForm(stage));
        addStudent.setOnAction(e -> openAddStudentForm(stage));
        showProfessors.setOnAction(e -> showProfessorList(stage));
        showStudents.setOnAction(e -> showStudentList(stage));
        searchStudent.setOnAction(e -> searchStudentById(stage));
        back.setOnAction(e -> start(stage));

        VBox vbox = new VBox(12, addProfessor, addStudent, showProfessors, showStudents, searchStudent, back);
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

    // ===== Add Professor, Add Student Forms =====
    private void openAddProfessorForm(Stage stage){ openAddStaffLikeForm(stage,"professor.txt","Professor"); }
    private void openAddStudentForm(Stage stage){ openAddStaffLikeForm(stage,"student.txt","Student"); }
    private void openAddStaffLikeForm(Stage stage,String filename,String titleStr){
        Label title = new Label("Add New " + titleStr); title.setStyle("-fx-font-size: 20px; -fx-text-fill: white; -fx-font-weight: bold;");
        TextField name = new TextField(); name.setPromptText("Full Name");
        TextField id = new TextField(); id.setPromptText("ID");
        TextField email = new TextField(); email.setPromptText("Email");
        TextField phone = new TextField(); phone.setPromptText("Phone Number");
        TextField dept = new TextField(); dept.setPromptText("Department");

        Button save = new Button("Save " + titleStr);
        Button back = new Button("Back");
        String btnStyle = "-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #6a11cb, #2575fc); -fx-background-radius: 20; -fx-padding: 8 15 8 15;";
        save.setStyle(btnStyle); back.setStyle(btnStyle);

        save.setOnAction(e -> {
            if(name.getText().isEmpty() || id.getText().isEmpty() || email.getText().isEmpty() || phone.getText().isEmpty() || dept.getText().isEmpty()){
                new Alert(Alert.AlertType.WARNING,"Fill all fields!").showAndWait(); return;
            }
            try(FileWriter fw = new FileWriter(filename,true)){
                fw.write(name.getText()+","+id.getText()+","+email.getText()+","+phone.getText()+","+dept.getText()+"\n");
            } catch(IOException ex){ new Alert(Alert.AlertType.ERROR,"Error saving!").showAndWait(); return; }
            new Alert(Alert.AlertType.INFORMATION,titleStr+" saved!").showAndWait();
            name.clear(); id.clear(); email.clear(); phone.clear(); dept.clear();
        });

        back.setOnAction(e -> openStaffMenu(stage));

        VBox vbox = new VBox(12,title,name,id,email,phone,dept,save,back);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom right, #2575fc, #6a11cb); -fx-padding: 20;");
        stage.setScene(new Scene(vbox,500,450));
    }

    // ===== Show Professor/Student List =====
    private void showProfessorList(Stage stage){ showPersonList(stage,"professor.txt"); }
    private void showStudentList(Stage stage){ showPersonList(stage,"student.txt"); }
    private void showPersonList(Stage stage,String filename){
        TextArea ta = new TextArea(); ta.setEditable(false);
        try(Scanner sc = new Scanner(new File(filename))){
            while(sc.hasNextLine()) ta.appendText(sc.nextLine()+"\n");
        } catch(IOException e){ ta.setText("No data found."); }
        Button back = new Button("Back"); back.setOnAction(e -> openStaffMenu(stage));
        VBox vbox = new VBox(10,ta,back); vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom, #43cea2, #185a9d); -fx-padding: 15;");
        stage.setScene(new Scene(vbox,500,400));
    }

    // ===== Search Student by ID =====
    private void searchStudentById(Stage stage){
        Label title = new Label("Search Student by ID");
        title.setStyle("-fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight: bold;");
        TextField idField = new TextField(); idField.setPromptText("Enter Student ID");
        TextArea result = new TextArea(); result.setEditable(false);
        Button search = new Button("Search"); Button back = new Button("Back");
        String btnStyle = "-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #6a11cb, #2575fc); "
                + "-fx-background-radius: 20; -fx-padding: 8 15 8 15;";
        search.setStyle(btnStyle); back.setStyle(btnStyle);

        search.setOnAction(e -> {
            String id = idField.getText().trim();
            if(id.isEmpty()){ new Alert(Alert.AlertType.WARNING,"Enter ID!").showAndWait(); return; }
            result.clear();
            boolean found=false;
            try(Scanner sc = new Scanner(new File("student.txt"))){
                while(sc.hasNextLine()){
                    String[] data = sc.nextLine().split(",");
                    if(data.length>=2 && data[1].equals(id)){ result.appendText(String.join(",",data)+"\n"); found=true; break;}
                }
            } catch(IOException ex){ result.setText("Error reading file."); }
            if(!found) result.setText("Student not found.");
        });

        back.setOnAction(e -> openStaffMenu(stage));
        VBox vbox = new VBox(10,title,idField,search,result,back); vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom right, #185a9d, #43cea2); -fx-padding: 20;");
        stage.setScene(new Scene(vbox,500,500));
    }

    // ===== Professor Courses =====
    private void openAddCourseForm(Stage stage) {
        Label title = new Label("Add New Course");
        title.setStyle("-fx-font-size: 20px; -fx-text-fill: white; -fx-font-weight: bold;");

        TextField courseIdField = new TextField(); courseIdField.setPromptText("Course ID");
        TextField titleField = new TextField(); titleField.setPromptText("Course Title");
        TextField unitField = new TextField(); unitField.setPromptText("Course Units");

        Button saveBtn = new Button("Save Course");
        Button backBtn = new Button("Back");

        String btnStyle = "-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #6a11cb, #2575fc); "
                + "-fx-background-radius: 20; -fx-padding: 8 15 8 15;";
        saveBtn.setStyle(btnStyle); backBtn.setStyle(btnStyle);

        saveBtn.setOnAction(e -> {
            if(courseIdField.getText().isEmpty() || titleField.getText().isEmpty() || unitField.getText().isEmpty()){
                new Alert(Alert.AlertType.WARNING,"Fill all fields!").showAndWait(); return;
            }
            try(FileWriter fw = new FileWriter("course.txt",true)){
                fw.write(courseIdField.getText()+","+titleField.getText()+","+unitField.getText()+"\n");
            } catch(IOException ex){ new Alert(Alert.AlertType.ERROR,"Error saving course!").showAndWait(); return; }
            new Alert(Alert.AlertType.INFORMATION,"Course saved!").showAndWait();
            courseIdField.clear(); titleField.clear(); unitField.clear();
        });

        backBtn.setOnAction(e -> openProfessorMenu(stage));
        VBox vbox = new VBox(12,title,courseIdField,titleField,unitField,saveBtn,backBtn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom right, #2575fc, #6a11cb); -fx-padding: 20;");
        stage.setScene(new Scene(vbox,500,400));
    }

    private void showCourseTable(Stage stage) {
        TableView<Course> table = new TableView<>();
        TableColumn<Course,String> idCol = new TableColumn<>("Course ID"); idCol.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        TableColumn<Course,String> titleCol = new TableColumn<>("Title"); titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        TableColumn<Course,String> unitCol = new TableColumn<>("Units"); unitCol.setCellValueFactory(new PropertyValueFactory<>("unit"));
        table.getColumns().addAll(idCol,titleCol,unitCol);
        ObservableList<Course> data = FXCollections.observableArrayList(getAllCourses());
        table.setItems(data);

        Button back = new Button("Back"); back.setStyle("-fx-font-size: 14px; -fx-text-fill: white; "
                + "-fx-background-color: linear-gradient(to right, #6a11cb, #2575fc); "
                + "-fx-background-radius: 20; -fx-padding: 8 15 8 15;");
        back.setOnAction(e -> openProfessorMenu(stage));

        VBox vbox = new VBox(15,table,back); vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom right, #2575fc, #6a11cb); -fx-padding: 15;");
        stage.setScene(new Scene(vbox,700,500));
    }

    private List<Course> getAllCourses(){
        List<Course> list = new ArrayList<>();
        try(Scanner sc = new Scanner(new File("course.txt"))){
            while(sc.hasNextLine()){
                String[] data = sc.nextLine().split(",");
                if(data.length>=3) list.add(new Course(data[0],data[1],data[2]));
            }
        } catch(IOException e){}
        return list;
    }

    public static class Course{
        private String courseId,title,unit;
        public Course(String courseId,String title,String unit){ this.courseId=courseId; this.title=title; this.unit=unit; }
        public String getCourseId(){ return courseId; }
        public String getTitle(){ return title; }
        public String getUnit(){ return unit; }
    }

    public static void main(String[] args) {
        launch(args);
    }
}