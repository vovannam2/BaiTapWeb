package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConectionSQLServer {
	private final String serverName = "localhost";
	private final String dbName = "BanHang";
	private final String portNumber = "1433";
	private final String instance = "";// MSSQLSERVER LEAVE THIS ON
	private final String userID = "sa";
	private final String password = "220304";

	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;

		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}

	public static void main(String[] args) {

		
	}
}
