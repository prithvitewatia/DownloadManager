package dev.prithvis.downloadmanager.config;

import java.io.*;
import java.util.Properties;

public class AppConfig {
    private static Properties appProperties;
    private static String defaultDownloadPath;
    public static System.Logger LOGGER;
    public static void getAppConfigurations(){
        String fileName="application.properties";
        FileInputStream fileInputStream;
        try {
            fileInputStream=new FileInputStream(fileName);
            appProperties=new Properties();
            appProperties.load(fileInputStream);
            LOGGER.log(System.Logger.Level.INFO,"Successfully loaded application.properties");
            defaultDownloadPath=System.getenv("HOME")+ File.separator+appProperties.getProperty("DOWNLOAD_PATH");
            LOGGER.log(System.Logger.Level.DEBUG,"Default download path is set to "+defaultDownloadPath);
        } catch (IOException ioException){
            LOGGER.log(System.Logger.Level.ERROR,ioException);
        }
    }
    public static String getDefaultDownloadPath() {
        return defaultDownloadPath;
    }

    public static void setDefaultDownloadPath(String defaultDownloadPath) {
        AppConfig.defaultDownloadPath = defaultDownloadPath;
    }
    public static void saveAppConfigurations(){
        appProperties.put("DOWNLOAD_PATH",defaultDownloadPath);
    }
}
