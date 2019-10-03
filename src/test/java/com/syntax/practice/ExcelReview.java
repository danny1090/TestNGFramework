package com.syntax.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReview {

	@Test
	public void readExcel() throws IOException {
		String xlPath = "src/test/resources/testdata/OrangeHrmData.xlsx";
		FileInputStream fis = new FileInputStream(xlPath);
		//open workbook
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		//open specified sheet
		XSSFSheet sheet=workbook.getSheet("EmployeeDetails");
		//accessing value of specific cell
		String value = sheet.getRow(6).getCell(0).toString();
		System.out.println(value);
		//get number of rows and columns
		int rows=sheet.getPhysicalNumberOfRows();
		int cols=sheet.getRow(0).getLastCellNum();
		System.out.println("Number of rows and columns "+rows+" "+cols);
		//get value of each call 1 by 1
		Object[][] data=new Object[rows][cols];
		for(int a=1; a<rows; a++) {
			
			for(int b=1; b<cols; b++) {
				String values=sheet.getRow(a).getCell(b).toString();
				data[a-1][b]=values;
				
			}
		}
	}
}
