
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReaddatafromExcel
{
	private static final String Sheet1 = null;

	public static void main(String[] args) throws FileNotFoundException,IOException 
    {
 	   
		FileInputStream file= new FileInputStream("C:\\Users\\sudhanya\\eclipse-workspace\\Data\\DataSheet.xlsx");
		//HSSFWorkbook workbook=new HSSFWorkbook(file); 
			
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int rowcount=sheet.getLastRowNum();
		int colcount=sheet.getRow(0).getLastCellNum();
		for (int i=0;i<rowcount;i++)
		{
		for (int j=0;j<colcount;j++)
		{
			System.out.print("  "+sheet.getRow(i).getCell(j).toString());
			
		}
		System.out.println();
		System.out.println("*************************");
		}
		
		} 	   
}
