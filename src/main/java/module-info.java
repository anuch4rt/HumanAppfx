module com.example.humanapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.humanapp to javafx.fxml;
    exports com.example.humanapp;
}