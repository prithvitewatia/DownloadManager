package dev.prithvis.downloadmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class MainDownload extends Application {
    public final System.Logger LOGGER= System.getLogger(this.getClass().getName());
    @Override
    public void start(Stage stage) throws IOException {
        ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/download-manager.fxml"),resourceBundle);
        Parent root = loader.load();
        LOGGER.log(System.Logger.Level.INFO,"Started application");
        Scene scene = new Scene(root,800,600);
        stage.setTitle("Download Manager");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}