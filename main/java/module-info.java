module com.example.midtermoop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.midtermoop to javafx.fxml;
    exports com.example.midtermoop;
}