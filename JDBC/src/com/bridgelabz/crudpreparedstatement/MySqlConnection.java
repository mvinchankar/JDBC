package com.bridgelabz.crudpreparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

	public static Connection getMySqlDBConnection() {
		String connectionURL = "jdbc:mysql://localhost:3306/demo";
		Connection connection=null;
        try {
			Class.forName("com.mysql.jdbc.Driver");
	        connection = DriverManager.getConnection(connectionURL, "root", "");
	        

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return connection;
	}
}