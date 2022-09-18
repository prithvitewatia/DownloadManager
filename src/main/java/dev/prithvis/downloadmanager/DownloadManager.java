package dev.prithvis.downloadmanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DownloadManager {
    @FXML
    private TextField urlTextField;
    @FXML
    void downloadButtonClicked(ActionEvent event) {
        String urlTextField=this.urlTextField.getText();

    }
    
}
