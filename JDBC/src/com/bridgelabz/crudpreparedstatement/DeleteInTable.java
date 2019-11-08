package com.bridgelabz.crudpreparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteInTable {
	
	public  void deleteTheTable(String tableName, Connection connection){
		String query="delete from Student where idstudent=105";
		try {
			PreparedStatement stmt=connection.prepareStatement("delete from Student where idstudent=?");  
			stmt.setInt(1,5);  
			  
			int i=stmt.executeUpdate();  
			System.out.println(i+" records deleted");  
			
		}
		catch (SQLException e) {
			e.printStackTrace();

		}


	}

}