package dev.prithvis.downloadmanager.config;

import dev.prithvis.downloadmanager.DownloadManager;
import dev.prithvis.downloadmanager.models.FileInfo;

import java.io.IOException;
import java.net.URL;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DownloadThread extends Thread{
    public FileInfo file;
    public DownloadManager downloadManager;
    public final System.Logger LOGGER=System.getLogger(this.getClass().getName());
    public DownloadThread(FileInfo file,DownloadManager downloadManager){
        this.downloadManager=downloadManager;
        this.file=file;
    }
    @Override
    public void run(){
        this.file.setStatus("DOWNLOADING");
        this.downloadManager.updateUI(file);
        try {
            Files.copy((new URL(this.file.getUrl()).openStream()), Paths.get(file.getLocation(), file.getName()));
            this.file.setStatus("DOWNLOADED");
            LOGGER.log(System.Logger.Level.INFO,String.format("%s downloaded at %s",
                    file.getName(),file.getLocation()));
        }catch (FileAlreadyExistsException fileAlreadyExistsException){
            this.file.setStatus("SKIPPED");
            LOGGER.log(System.Logger.Level.WARNING,String.format("%s already exists at %s.Skipping download"
                    ,file.getName(),file.getLocation()));
        }
        catch (IOException e) {
            this.file.setStatus("FAILED");
            LOGGER.log(System.Logger.Level.ERROR,String.format("Download of %s failed because of %s",
                    file.getName(),e.getMessage()));
            throw new RuntimeException(e);
        }
        this.downloadManager.updateUI(file);
        LOGGER.log(System.Logger.Level.INFO,String.format("Download of %s completed",
                file.getName()));
    }
}
