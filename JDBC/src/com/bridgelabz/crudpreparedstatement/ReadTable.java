package com.bridgelabz.crudpreparedstatement;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ReadTable {
	
	public  void generateMySqlPDFReport(String tableName, Connection connection){
		String query="SELECT *FROM "+tableName;
		try {
			PreparedStatement statment=connection.prepareStatement(query);
			ResultSet resultSet=statment.executeQuery();


			Document myPdfReport=new Document();
			PdfWriter.getInstance(myPdfReport, new FileOutputStream("/home/admin1/Documents/Table_Read_1.pdf"));
			myPdfReport.open();
			PdfPTable table = new PdfPTable(3);
			PdfPCell tableCell;
			while(resultSet.next()) {
				String id_student = resultSet.getString("idstudent");
				tableCell=new PdfPCell(new Phrase(id_student));
				table.addCell(tableCell);
				String Student_name=resultSet.getString("Student_name");
				tableCell=new PdfPCell(new Phrase(Student_name));
				table.addCell(tableCell);
				String Student_address=resultSet.getString("Student_address");
				tableCell=new PdfPCell(new Phrase(Student_address));
				table.addCell(tableCell);
				System.out.print(id_student+" "+Student_name+" "+Student_address+"\n");
			}

			myPdfReport.add(table);
			myPdfReport.close();
			statment.close();
			resultSet.close();
			connection.close();

		}
		catch (SQLException  | DocumentException  | FileNotFoundException e) {
			e.printStackTrace();

		}
		


	}


}