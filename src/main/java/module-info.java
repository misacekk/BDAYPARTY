module com.example.bdayparty {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.bdayparty to javafx.fxml;
    exports com.example.bdayparty;
}