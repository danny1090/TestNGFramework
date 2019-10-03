package com.syntax.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWriteDemo {

	@Test
	public void writeExcel() throws Exception {
		String xlPath="src/test/resources/testdata/OrangeHrmData.xlsx";
		FileInputStream fis=new FileInputStream(xlPath);
		//open workbook
		XSSFWorkbook wbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=wbook.getSheet("EmployeeDetails");
		//write to the excel
		sheet.getRow(0).createCell(4).setCellValue("Result");
		sheet.getRow(1).createCell(4).setCellValue("Pass");
		sheet.getRow(1).createCell(4).setCellValue("Fail");
		sheet.createRow(11).createCell(20).setCellValue("Messi");
		
		//write to excel
		FileOutputStream fos=new FileOutputStream(xlPath);
		wbook.write(fos);
		
		//close file
		fos.close();
		wbook.close();
		fis.close();
		
		
		
	}
}
