module com.example.projeto2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires com.google.gson;

    opens com.example.projeto2 to javafx.fxml;
    exports com.example.projeto2;
}