module com.example.mozimusor {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.mozimusor to javafx.fxml;
    exports com.example.mozimusor;
}