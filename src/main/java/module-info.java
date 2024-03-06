module com.superheropug {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.superheropug to javafx.fxml;
    exports com.superheropug;
}
