package com.bvan.airbnb.manager;

import com.bvan.airbnb.persistence.api.PersistenceException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author bvanchuhov
 */
public enum DBManager {
    INSTANCE;

    private static final String CONFIG_NAME = "db_config.properties";

    private Connection connection;

    public Connection getConnection() throws PersistenceException {
        if (connection == null) {
            initConnection();
        }
        return connection;
    }

    private Properties getConfigProperties() {
        Properties properties = new Properties();

        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream(CONFIG_NAME)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

    private void initConnection() throws PersistenceException {
        Properties configProperties = getConfigProperties();

        try {
            Class.forName(configProperties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(
                    configProperties.getProperty("url"),
                    configProperties.getProperty("user"),
                    configProperties.getProperty("password"));
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }
}
