import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DataDrivenwithApplication {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sudhanya\\BrowserDrivers\\geckodriver.exe");

		// objects and variables instantiation
		FirefoxDriver driver = new FirefoxDriver();

		String appUrl = "https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html?classic=true";

		// launch the firefox browser and open the application url
		driver.get(appUrl);
		driver.manage().window().maximize();

		// Read data from Excel file
		FileInputStream file = new FileInputStream("C:\\Users\\sudhanya\\eclipse-workspace\\Data\\InterestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		// Write the values to excel file
		FileOutputStream output = new FileOutputStream(
				"C:\\Users\\sudhanya\\eclipse-workspace\\Data\\InterestDataOutput.xlsx");
		XSSFWorkbook outworkbook = new XSSFWorkbook();
		XSSFSheet outsheet = outworkbook.createSheet("Data");

		// Rowcount
		int srowcount = sheet.getLastRowNum();
		System.out.println(srowcount);
		for (int i = 1; i < srowcount; i++) {
			XSSFRow orow = sheet.getRow(i);
			// Principal value

			int sprincipal = (int) orow.getCell(0).getNumericCellValue();
			System.out.println(sprincipal);
			// Rate
			double srate = orow.getCell(1).getNumericCellValue();
			System.out.println(srate);
			// Period
			int speriod = (int) orow.getCell(2).getNumericCellValue();
			System.out.println(speriod);
			// Tenure Period
			String stenureperiod = orow.getCell(3).getStringCellValue();
			System.out.println(stenureperiod);
			// Frequency
			String sfrequency = orow.getCell(4).getStringCellValue();
			System.out.println(sfrequency);
			// Expected Value
			double sexpected = (double) orow.getCell(5).getNumericCellValue();
			System.out.println(sexpected);

			// Input data into application
			WebElement oprincipal = driver.findElement(By.id("principal"));
			oprincipal.sendKeys(String.valueOf(sprincipal));

			WebElement orate = driver.findElement(By.id("interest"));
			orate.sendKeys(String.valueOf(srate));

			WebElement operiod = driver.findElement(By.id("tenure"));
			operiod.sendKeys(String.valueOf(speriod));

			Select odrop1 = new Select(driver.findElement(By.id("tenurePeriod")));
			odrop1.selectByVisibleText(stenureperiod);

			Select odrop2 = new Select(driver.findElement(By.id("frequency")));
			odrop2.selectByVisibleText(sfrequency);

			// Click calculate button
			WebElement obutton = driver.findElement(
					By.xpath(".//*[@src=\"https://img-d02.moneycontrol.co.in/images/mf_revamp/btn_calcutate.gif\"]"));
			obutton.click();

			WebElement otxt = driver.findElement(
					By.id("resp_matval"));
			double actual = Double.parseDouble(otxt.getText());

			if (sexpected == actual)
				System.out.println("Passed");
			else
				System.out.println("Failed");		
			System.out.println("Test Executed Successfully(Read)");
		
			outsheet.createRow(i).createCell(0).setCellValue(sexpected);
			outsheet.createRow(i).createCell(1).setCellValue(actual);
			System.out.println("Test Executed Successfully(Write)");				
			
			// Click on clear button
			WebElement oclear = driver.findElement(
					By.xpath(".//*[@src=\"https://img-d02.moneycontrol.co.in/images/mf_revamp/btn_clear.gif\"]"));
			oclear.click();
		}
		outworkbook.write(output);
		output.close();

	}
}