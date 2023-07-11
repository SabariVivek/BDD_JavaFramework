package com.bdd.utilities;

import java.util.Properties;

public class ConfigLoader {

    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader() {
        properties = PropertyLoader.propertyLoader("src/test/resources/properties/config.properties");
    }

    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBrowserType() {
        String prop = properties.getProperty("browser");
        if (prop != null) return prop.trim();
        else throw new RuntimeException("Property \"Browser\" is not specified in the config.properties file");
    }

    public String getURL() {
        String prop = properties.getProperty("url");
        if (prop != null) return prop.trim();
        else throw new RuntimeException("Property \"URL\" is not specified in the config.properties file");
    }
}