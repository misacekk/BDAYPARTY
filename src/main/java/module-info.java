module com.example.bdayparty {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.bdayparty to javafx.fxml, javafx.base;
    exports com.example.bdayparty;
}