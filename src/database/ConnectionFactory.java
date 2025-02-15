package database;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author joao
 */
public class ConnectionFactory {
    // Base de dados
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String dbName = "efa0124_08_joao_gestor_empresa";
    // remote (url, username, password)
	private final String server = "62.28.39.135";
	private final String username = "efa0124";
    private final String password = "123.Abc";
    private final String url = "jdbc:mysql://" + server + ":3306/" + dbName;
    // local (local, user, pass)
    private final String localhost = "localhost";
    private final String user = "root";
    private final String pass = "123";
    private final String local = "jdbc:mysql://" + localhost + ":3306/" + dbName;
    
    
    public Connection getConn() {
    
        Connection conn = null;
        
        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(local, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
