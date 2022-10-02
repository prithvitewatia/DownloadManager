package dev.prithvis.downloadmanager.models;

import javafx.beans.property.SimpleStringProperty;


public class FileInfo {
    private final SimpleStringProperty location=new SimpleStringProperty();
    private final SimpleStringProperty name=new SimpleStringProperty();
    private final SimpleStringProperty url=new SimpleStringProperty();
    private final SimpleStringProperty status=new SimpleStringProperty();
    private final SimpleStringProperty addedOn=new SimpleStringProperty();

    public String getLocation() {
        return location.get();
    }

    public SimpleStringProperty locationProperty() {
        return location;
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getUrl() {
        return url.get();
    }

    public SimpleStringProperty urlProperty() {
        return url;
    }

    public void setUrl(String url) {
        this.url.set(url);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getAddedOn() {
        return addedOn.get();
    }

    public SimpleStringProperty addedOnProperty() {
        return addedOn;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn.set(addedOn);
    }
}
