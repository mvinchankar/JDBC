package com.bridgelabz.crudpreparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTable {

	public void updateTheTable(String tableName,Connection connection) {
    	try {
        	PreparedStatement statement=connection.prepareStatement("update Student set Student_name=? where idstudent=?");  
			statement.setString(1,"Pooja");
			statement.setString(2,"6");  
	    	int i=statement.executeUpdate();  
	    	System.out.println(i+" records updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}  
      
    }
}