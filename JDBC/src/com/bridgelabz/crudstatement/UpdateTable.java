package com.bridgelabz.crudstatement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTable {


	public  void updateTheTable(String tableName, Connection connection){
		try {
			Statement statement=connection.createStatement();
			int count=statement.executeUpdate("UPDATE Student SET student_name='Raj Krishna Jha' where IdStudent ='5'");
			if(count>0) {
				System.out.println("Records Updated");
			}
			else {
				System.out.println("Records not updated");
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();

		}
		

	}
	
	
}