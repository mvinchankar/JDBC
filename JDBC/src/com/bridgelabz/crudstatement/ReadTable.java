package com.bridgelabz.crudstatement;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			Statement statment=connection.createStatement();
			ResultSet resultSet=statment.executeQuery(query);


			Document myPdfReport=new Document();
			PdfWriter.getInstance(myPdfReport, new FileOutputStream("/home/admin1/Documents/Table_Read.pdf"));
			myPdfReport.open();
			PdfPTable table = new PdfPTable(3);
			PdfPCell tableCell;
			while(resultSet.next()) {
				String id_student = resultSet.getString("idStudent");
				tableCell=new PdfPCell(new Phrase(id_student));
				table.addCell(tableCell);
				String student_name=resultSet.getString("Student_name");
				tableCell=new PdfPCell(new Phrase(student_name));
				table.addCell(tableCell);
				String student_address=resultSet.getString("Student_address");
				tableCell=new PdfPCell(new Phrase(student_address));
				table.addCell(tableCell);
				System.out.print(id_student+" "+student_name+" "+student_address+"\n");
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
