package dev.prithvis.downloadmanager;

import dev.prithvis.downloadmanager.config.DownloadThread;
import dev.prithvis.downloadmanager.models.FileInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DownloadManager {
    public final System.Logger LOGGER=System.getLogger(this.getClass().getName());
    @FXML
    private TableView<FileInfo> downloadTable;

    @FXML
    private TextField download_url_text_field;

    @FXML
    private TextField file_name_field;

    @FXML
    private TextField save_location_field;

    @FXML
    void downloadButtonClicked(ActionEvent event) {
        String urlTextField=this.download_url_text_field.getText().trim();
        String downloadLocation=this.save_location_field.getText().trim();
        String filename=this.file_name_field.getText().trim();
        String status="STARTED";
        String action="OPEN";
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("MMMM-dd-yyyy");
        LocalDate dateNow= LocalDate.now();
        String date= dateNow.format(dateTimeFormatter);
        FileInfo file=new FileInfo(downloadLocation,filename,urlTextField,status,action,date);
        LOGGER.log(System.Logger.Level.INFO,"Download file with info "+file+" started");
        DownloadThread thread=new DownloadThread(file,this);
        this.downloadTable.getItems().add(file);
        thread.start();
        this.download_url_text_field.setText("");
        this.file_name_field.setText("");
    }
    @FXML
    public void initialize(){
        TableColumn<FileInfo,String> location= (TableColumn<FileInfo, String>) this.downloadTable.getColumns().get(0);
        TableColumn<FileInfo,String> fileName= (TableColumn<FileInfo, String>) this.downloadTable.getColumns().get(1);
        TableColumn<FileInfo,String> downloadUrl= (TableColumn<FileInfo, String>) this.downloadTable.getColumns().get(2);
        TableColumn<FileInfo,String> status= (TableColumn<FileInfo, String>) this.downloadTable.getColumns().get(3);
        TableColumn<FileInfo,String> action= (TableColumn<FileInfo, String>) this.downloadTable.getColumns().get(4);
        TableColumn<FileInfo,String> addedOn= (TableColumn<FileInfo, String>) this.downloadTable.getColumns().get(5);

        location.setCellValueFactory(p -> p.getValue().locationProperty());
        fileName.setCellValueFactory(p -> p.getValue().nameProperty());
        downloadUrl.setCellValueFactory(p -> p.getValue().urlProperty());
        status.setCellValueFactory(p -> p.getValue().statusProperty());
        action.setCellValueFactory(p -> p.getValue().actionProperty());
        addedOn.setCellValueFactory(p -> p.getValue().addedOnProperty());

        downloadTable.getColumns().add(location);
        downloadTable.getColumns().add(fileName);
        downloadTable.getColumns().add(downloadUrl);
        downloadTable.getColumns().add(status);
        downloadTable.getColumns().add(action);
        downloadTable.getColumns().add(addedOn);
        LOGGER.log(System.Logger.Level.DEBUG,"Initialized table");
    }
    public void updateTable(){
        this.downloadTable.refresh();
    }
}
