package com.bridgelabz.crudstatement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTable {

	public  void deleteTheTable(String tableName, Connection connection){
		String query="delete from Student where idStudent=108";
		try {
			Statement statement=connection.createStatement();
			int count=statement.executeUpdate(query);
			
			if(count>0) {
				System.out.println("Records deleted");
			}
			else {
				System.out.println("Records not deleted");
			}
			
		
		}
		catch (SQLException e) {
			e.printStackTrace();

		}


	}
}
