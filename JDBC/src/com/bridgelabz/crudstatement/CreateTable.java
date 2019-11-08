package com.bridgelabz.crudstatement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public  void insertIntoTable(String tableName, Connection connection){
		String query="INSERT INTO " +tableName+" VALUES('5','Sanjeet','Hyderabad')";
		try {
			Statement statment=connection.createStatement();
			int count =statment.executeUpdate(query);
		}
		catch (SQLException e) {
			e.printStackTrace();

		}
		


	}
}
