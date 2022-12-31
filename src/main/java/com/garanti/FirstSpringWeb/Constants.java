package com.garanti.FirstSpringWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Constants
{
    private static final String USER = "BILGE";

    private static final String PASSWORD = "12345";

    private static final String URL = "jdbc:oracle:thin:@localhost:1521";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        // gerekebilir
        Class.forName("oracle.jdbc.OracleDriver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}