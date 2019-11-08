package com.bridgelabz.crudpreparedstatement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateInTable {

  public  void insertIntoTable(String tableName, Connection connection){
		
		try {
			PreparedStatement statement=connection.prepareStatement("insert into Student values(?,?,?)");
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
			
			do{  
				System.out.println("Enter Student ID:");  
				String id_student=br.readLine();  
				System.out.println("Enter Student Name:");  
				String Student_name=br.readLine();  
				System.out.println("Enter City of Student:");  
				String Student_address=br.readLine();  
				  
				statement.setString(1,id_student);  
				statement.setString(2,Student_name);  
				statement.setString(3,Student_address);  
				int i=statement.executeUpdate();  
				System.out.println(i+" records affected");  
				System.out.println("Do you want to continue: yes/no");  
				String s=br.readLine();  
				if(s.startsWith("n")){  
				break;  
				}  
				}while(true);  
				  
				connection.close();  
		}
		catch (SQLException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		


	}

	
}
