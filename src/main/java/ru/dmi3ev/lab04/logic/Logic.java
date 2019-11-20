package ru.dmi3ev.lab04.logic;

import java.sql.*;
import java.lang.reflect.InvocationTargetException;


public class Logic {

    private static final String DEFAULT_CONSOLE_ENCODING = "consoleEncoding";
    private static final String CONSOLE_ENCODING_PROPERTY = "UTF-8";
    private static final String PROPERTIES_FILENAME = "application.properties";
    private static final String DB_URL_PROPERTY = "db.url";
    private static final String DB_USERNAME_PROPERTY = "db.username";
    private static final String DB_PASSWORD_PROPERTY = "db.password";

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/rps_lab2?characterEncoding=utf8&useSSL=false";
        String username = "root";
        String password ="root";


        return DriverManager.getConnection(url, username, password);
    }
}
