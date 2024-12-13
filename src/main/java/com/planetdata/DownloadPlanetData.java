package com.planetdata;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadPlanetData {

    public static void downloadPlanetJsonFile() throws IOException {
        String fileUrl = "https://gist.githubusercontent.com/joelbirchler/66cf8045fcbb6515557347c05d789b4a/raw/9a196385b44d4288431eef74896c0512bad3defe/exoplanets";
        String outputFilePath = "exoplanet-catalogue.json";

        URL url = new URL(fileUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Read the data from the URL
        try (InputStream inputStream = connection.getInputStream();
                FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("Planet Data downloaded successfully: " + outputFilePath);
        } finally {
            connection.disconnect();
        }
    }

}
