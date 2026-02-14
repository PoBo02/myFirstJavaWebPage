package DTO.model.ultis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;

public class ConnectDB {

    private String hostName;
    private String port;
    private String dbName;
    private String userName;
    private String password;;

    public ConnectDB() {
            this.hostName = "localhost";
            this.port = "1433";
            this.dbName ="ProductIntro";
            this.userName = "sa";
            this.password ="12345";
    }

    public ConnectDB(ServletContext sc) {
        this.hostName = sc.getInitParameter("hostAddress");

        this.port = sc.getInitParameter("port");
        this.dbName = sc.getInitParameter("dbName");
        this.userName = sc.getInitParameter("userName");
        this.password = sc.getInitParameter("userPass");
    }
    public String getUrlString() {
        String fm = "jdbc:sqlserver://%s:%s;databaseName=%s;user=%s;password=%s";
        return String.format(fm, hostName, port, dbName, userName, password);
    }
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(getUrlString());
    }

}
