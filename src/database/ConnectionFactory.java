package database;

import enums.DatabaseType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author joao
 */
public class ConnectionFactory {

    // MySQL Config
    private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_NAME = "efa0124_08_joao_gestor_empresa";
    
    // MYSQL_REMOTE
	private static final String REMOTE_SERVER = "62.28.39.135";
	private static final String REMOTE_USERNAME = "efa0124";
    private static final String REMOTE_PASSWORD = "123.Abc";
    private static final String REMOTE_URL = "jdbc:mysql://" + REMOTE_SERVER + ":3306/" + DB_NAME;
    
    // MYSQL_LOCAL
    private static final String LOCAL_SERVER = "localhost";
    private static final String LOCAL_USERNAME = "root";
    private static final String LOCAL_PASSWORD = "123";
    private static final String LOCAL_URL = "jdbc:mysql://" + LOCAL_SERVER + ":3306/" + DB_NAME;
    
    // SQLITE
    private static final String SQLITE_DRIVER = "org.sqlite.JDBC";
    private static final String SQLITE_URL = "jdbc:sqlite:database/" + DB_NAME + ".db";
    
    // Ligacao 
    private static DatabaseType currentType = DatabaseType.MYSQL_REMOTE;

    public Connection getConn() {
        try {
            switch (currentType) {
                case MYSQL_LOCAL:
                    return getMySQLConnection(LOCAL_URL, LOCAL_USERNAME, LOCAL_PASSWORD);
                case MYSQL_REMOTE:
                    return getMySQLConnection(REMOTE_URL, REMOTE_USERNAME, REMOTE_PASSWORD);
                case SQLITE:
                    return getSQLiteConnection();
                default:
                    throw new SQLException("Database type not configured");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Connection getMySQLConnection(String url, String username, String password) throws SQLException {
        try {
            Class.forName(MYSQL_DRIVER);
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL driver not found", e);
        }
    }

    private Connection getSQLiteConnection() throws SQLException {
        try {
            Class.forName(SQLITE_DRIVER);
            return DriverManager.getConnection(SQLITE_URL);
        } catch (ClassNotFoundException e) {
            throw new SQLException("SQLite driver not found", e);
        }
    }
    
    // Method to change database type
    public static void setDatabaseType(DatabaseType type) { currentType = type; }
    
    // Method to get current database type
    public static DatabaseType getCurrentType() { return currentType; }
}
