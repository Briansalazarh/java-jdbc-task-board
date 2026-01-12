package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    // Configuración estándar de MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/board_db?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "password"; // Genérico, se ve pro

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}