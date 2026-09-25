package com.example.humanapp;

import Human.Alumni;
import Human.Staff;
import Human.Student;
import Human.StudentPool;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField lastnameField;

    @FXML
    private Label extraLabel;

    @FXML
    private TextField extraField;

    @FXML
    private Label resultLabel;

    @FXML
    private TextArea displayArea;

    private final StudentPool studentPool = new StudentPool();

    @FXML
    public void initialize() {
        typeComboBox.getItems().addAll("Student", "Alumni", "Staff");
        typeComboBox.setValue("Student");
        typeComboBox.setOnAction(e -> updateExtraLabel());
        updateExtraLabel();
    }

    private void updateExtraLabel() {
        String selected = typeComboBox.getValue();
        if ("Student".equals(selected)) {
            extraLabel.setText("คะแนน (Score):");
            extraField.setPromptText("กรอกคะแนน");
        } else if ("Alumni".equals(selected)) {
            extraLabel.setText("เงินเดือน (Salary):");
            extraField.setPromptText("กรอกเงินเดือน");
        } else if ("Staff".equals(selected)) {
            extraLabel.setText("อายุงาน (Age):");
            extraField.setPromptText("กรอกอายุการทำงาน");
        }
    }

    @FXML
    protected void onSubmitButtonClick() {
        String selectedType = typeComboBox.getValue();
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String lastname = lastnameField.getText().trim();
        String extraValueStr = extraField.getText().trim();

        if (id.isEmpty() || name.isEmpty() || lastname.isEmpty() || extraValueStr.isEmpty()) {
            resultLabel.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #dc2626;");
            resultLabel.setText("กรุณากรอกข้อมูลให้ครบถ้วน");
            return;
        }

        int extraValue;
        try {
            extraValue = Integer.parseInt(extraValueStr);
        } catch (NumberFormatException e) {
            resultLabel.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #dc2626;");
            resultLabel.setText("ช่อง " + extraLabel.getText().replace(":", "") + " ต้องเป็นตัวเลขเท่านั้น");
            return;
        }

        String recordOutput = "";

        if ("Student".equalsIgnoreCase(selectedType)) {
            Student student = new Student(id, name, lastname, extraValue);
            studentPool.addStudent(student);
            recordOutput = String.format("[Student] รหัส: %s | ชื่อ: %s %s | คะแนน: %d | เกรด: %s | เบี้ยยังชีพ: %d บาท\n",
                    student.getId(), student.getName(), student.getLastname(),
                    student.getScore(), student.computeGrade(), student.giveReward());
        } else if ("Alumni".equalsIgnoreCase(selectedType)) {
            Alumni alumni = new Alumni(id, name, lastname, extraValue);
            recordOutput = String.format("[Alumni] รหัส: %s | ชื่อ: %s %s | เงินเดือน: %d บาท\n",
                    alumni.getId(), alumni.getName(), alumni.getLastname(), alumni.getSalary());
        } else if ("Staff".equalsIgnoreCase(selectedType)) {
            Staff staff = new Staff(id, name, lastname, extraValue);
            recordOutput = String.format("[Staff] รหัส: %s | ชื่อ: %s %s | อายุงาน: %d ปี\n",
                    staff.getId(), staff.getName(), staff.getLastname(), staff.getAge());
        }

        displayArea.appendText(recordOutput);

        resultLabel.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #0284c7;");
        resultLabel.setText("บันทึกข้อมูลสำเร็จ (" + selectedType + ")");

        clearFields();
    }

    private void clearFields() {
        idField.clear();
        nameField.clear();
        lastnameField.clear();
        extraField.clear();
        idField.requestFocus();
    }
}