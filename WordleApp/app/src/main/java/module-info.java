module com.application {
    requires javafx.controls;
    requires javafx.fxml;

    requires transitive javafx.graphics;

    opens com.controllers to javafx.fxml;
    exports com.application;
}
