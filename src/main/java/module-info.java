module dev.prithvis.downloadmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens dev.prithvis.downloadmanager to javafx.fxml;
    exports dev.prithvis.downloadmanager;
}