package com.fowobi.networking.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class PropertyReader {

    public static String getPropertyValue(String propertyKey) throws Exception {
        FileReader reader = new FileReader("/home/tostos/Documents/code/properties/simpleVpnServer.properties");

        Properties properties = new Properties();
        properties.load(reader);

        return properties.getProperty(propertyKey);
    }

    public static void main(String[] args) throws Exception {
        PropertyReader pr = new PropertyReader();

        System.out.println(pr.getPropertyValue("secret.key"));
    }
}
