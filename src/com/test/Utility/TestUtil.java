package com.test.Utility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class TestUtil
{
private static XSSFWorkbook workbook;
private static XSSFSheet sheet;
private static ArrayList<Object[]> mydata=new ArrayList<Object[]>();
public static  ArrayList<Object[]> getTestDataExcel() throws Exception 
{   
	String FilePath="C:\\Users\\sudhanya\\eclipse-workspace\\ExampleLogin\\src\\com\\testdata\\DataProviderTestng.xlsx";
	String SheetName="Sheet1";
    try 
   {
   FileInputStream file = new FileInputStream(FilePath);
   workbook = new XSSFWorkbook(file);
   sheet = workbook.getSheet(SheetName);
   int rowcount=sheet.getLastRowNum();
   for(int i=0;i<=rowcount;i++)
   {
	   	  String fullname=sheet.getRow(i).getCell(0).toString();
	   	  System.out.println(fullname);
		  String email=sheet.getRow(i).getCell(1).toString();
		  System.out.println(email);
		  String phone=sheet.getRow(i).getCell(2).toString();
		  System.out.println(phone);
		  String gender=sheet.getRow(i).getCell(3).toString();
		  System.out.println(gender);
		  String country=sheet.getRow(i).getCell(4).toString();
		  System.out.println(country);   
		  Object[] ob={fullname,email,phone,gender,country};
		  mydata.add(ob);
   }	  
   }
    catch (FileNotFoundException e)
    {
    	System.out.println("Could not read the Excel sheet");
    	e.printStackTrace();
    }

    catch (IOException e)
    {
    	System.out.println("Could not read the Excel sheet");
    	e.printStackTrace();
    }
	return mydata;
}
}