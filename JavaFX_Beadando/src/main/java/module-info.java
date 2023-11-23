module com.example.javafx_beadando {
    requires javafx.controls;
    requires javafx.fxml;

   /* requires org.controlsfx.controls;
    requires com.dlsc.formsfx;*/
    requires java.sql;
    requires com.google.gson;
    //requires validatorfx;

    opens com.example.javafx_beadando to javafx.fxml;
    exports com.example.javafx_beadando;
}