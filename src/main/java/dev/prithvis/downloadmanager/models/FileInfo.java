package dev.prithvis.downloadmanager.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class FileInfo {
    private SimpleIntegerProperty index;
    private SimpleStringProperty name;
    private SimpleStringProperty url;
    private SimpleStringProperty status;

    public FileInfo(int index,String name,String url,String status){
        this.index.set(index);
        this.name.set(name);
        this.url.set(url);
        this.status.set(status);
    }
}
