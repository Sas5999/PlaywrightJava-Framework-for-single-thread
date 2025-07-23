package com.makemyjourney.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties props = new Properties();
//    static {
//        try {
//            InputStream input = ConfigReader.class.getResourceAsStream("/Users/pdgt/IdeaProjects/PlaywrightJavaTempFramework/src/main/resources/config.properties");
//            if (input == null) {
//                throw new RuntimeException("Config properties not found");
//            }
//            props.load(input);
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to load confir", e);
//        }

    static{ // Here reading the file where we will store the test data
        try {
            FileInputStream fis = new FileInputStream("/Users/pdgt/IdeaProjects/PlaywrightJavaTempFramework/src/main/resources/config.properties");
            if (fis == null){
                throw new RuntimeException("Config file is null");
            }

            props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) { // Simplifying the method to avoid overwriting
        return props.getProperty(key);
    }
}


