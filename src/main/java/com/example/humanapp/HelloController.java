package com.example.humanapp;

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

    @FXML
    protected void onSubmitButtonClick() {
        String id = idField.getText();
        String name = nameField.getText();
        String lastname = lastnameField.getText();

        if (id.isEmpty() || name.isEmpty() || lastname.isEmpty()) {
            resultLabel.setText("กรุณากรอกข้อมูลให้ครบถ้วน!");
        } else {
            resultLabel.setText("บันทึกสำเร็จ: " + id + " - " + name + " " + lastname);
        }
    }
}