module com.example.practicajavafx2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.practicajavafx2 to javafx.fxml;
    exports com.example.practicajavafx2;
}