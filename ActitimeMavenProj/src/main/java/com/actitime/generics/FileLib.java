package com.actitime.generics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This is the generic class for data driver testing
 * @author sandeep
 *
 */
public class FileLib {
	/**
	 *
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyValue(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/data/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	/**
	 *
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws IOException
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 */
	public String getExcelValue(String sheetname,int rownum,int cellnum) throws IOException, EncryptedDocumentException, InvalidFormatException{
		FileInputStream fis=new FileInputStream("./src/test/resources/data/TestScript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).toString();
		return value;
	}
}