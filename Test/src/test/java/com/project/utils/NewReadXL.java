package com.project.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NewReadXL {

	public static Object[][] ReadFromExcelToObjectArray(String FilePath, String FileName, String SheetName)
			throws IOException {

		File file = new File(FilePath + "/" + FileName);
		FileInputStream inputStream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(inputStream);

		Sheet sheet = workbook.getSheet(SheetName);
		int rowcount = sheet.getLastRowNum();
		Object[][] data = new Object[rowcount][1];
		Hashtable<String, String> rec = null;
		Row keysRow = sheet.getRow(0);
		for (int r = 1; r < rowcount + 1; r++) {
			rec = new Hashtable<String, String>();
			Row dataRow = sheet.getRow(r); // current row as per loop
			for (int c = 0; c < dataRow.getLastCellNum(); c++) {
				String key = keysRow.getCell(c).getStringCellValue();
				String value = dataRow.getCell(c).getStringCellValue();
				rec.put(key, value);
			}
			data[r - 1][0] = rec;
		}
		workbook.close();
		inputStream.close();
		return data;
	}

	public static Object[][] getData() throws IOException {

		String ProjectPath = System.getProperty("user.dir");
		System.out.println(ProjectPath);
				
		String FilePath = ProjectPath + "src/test/java/com/project/testdata";
		String FileName = "Data.xlsx";
		String SheetName = "DataSet";

		return NewReadXL.ReadFromExcelToObjectArray(FilePath, FileName, SheetName);

	}

}
