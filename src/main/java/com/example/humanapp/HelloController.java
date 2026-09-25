package com.example.humanapp;

import Human.Student;
import Human.StudentPool;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField lastnameField;

    @FXML
    private Label resultLabel;


    private final StudentPool studentPool = new StudentPool();

    @FXML
    protected void onSubmitButtonClick() {

        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String lastname = lastnameField.getText().trim();


        if (id.isEmpty() || name.isEmpty() || lastname.isEmpty()) {
            resultLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #e74c3c;");
            resultLabel.setText(" กรุณากรอกข้อมูลให้ครบถ้วน");
            return;
        }


        Student newStudent = new Student(id, name, lastname, 0);


        studentPool.addStudent(newStudent);


        resultLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #27ae60;");
        resultLabel.setText(" บันทึกสำเร็จ: " + newStudent.getId() + " - " + newStudent.whatYourName());


        clearFields();


        studentPool.showStudent();
    }




    private void clearFields() {
        idField.clear();
        nameField.clear();
        lastnameField.clear();
        idField.requestFocus();
    }
}