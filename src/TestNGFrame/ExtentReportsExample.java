package TestNGFrame;

import org.testng.ITestResult;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.test.Utility.ScreenUtil;
import com.test.Utility.TestUtil;

public class ExtentReportsExample 
{
	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeTest
	public void setup() 
	{
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");

		sparkReporter.config().setDocumentTitle("Automation Report"); // Title of Report
		sparkReporter.config().setReportName("Extent Report V4"); // Name of the report
		sparkReporter.config().setTheme(Theme.DARK);// Default Theme of Report

		extent = new ExtentReports(); // create object of ExtentReports
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application Name", "Registration Process");
		extent.setSystemInfo("User Name", "Sudhanya CS");
		extent.setSystemInfo("Envirnoment", "QA");
	}

	@AfterTest
	public void endreport()
	{
		extent.flush();
	}
		
	@Test(dataProvider = "getTestData")
	public void register(String fullname, String email, String phone, String gender, String Country)
			throws InterruptedException 
	{
		test = extent.createTest("Registration");
		Thread.sleep(1000);
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sudhanya\\BrowserDrivers\\geckodriver.exe");
		driver= new FirefoxDriver();
		Thread.sleep(1000);
		driver.manage().window().maximize();
		String appUrl = "http://demo.automationtesting.in/Register.html";
		driver.get(appUrl);
		Thread.sleep(1000);

		WebElement fname = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[1]/div[1]/input"));
		fname.clear();
		fname.sendKeys(fullname);
		Thread.sleep(1000);

		WebElement mail = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[3]/div[1]/input"));
		mail.clear();
		mail.sendKeys(email);
		Thread.sleep(1000);

		WebElement ophone = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[4]/div/input"));
		ophone.clear();
		ophone.sendKeys(phone);
		Thread.sleep(1000);

		if (gender.equals("Male"))
		{
			WebElement ogender = driver.findElement(By.name("radiooptions"));
			ogender.click();
			Thread.sleep(1000);
		}

		WebElement country = driver.findElement(By.xpath("//*[@id=\"countries\"]"));
		Select odrop = new Select(country);
		odrop.selectByVisibleText(Country);

		WebElement submit = driver.findElement(By.id("submitbtn"));
		submit.click();
	}

	@DataProvider
	public Iterator<Object[]> getTestData() throws Exception 
	{
		ArrayList<Object[]> testdata = TestUtil.getTestDataExcel();
		return testdata.iterator();
	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException 
	{
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			// MarkupHelper is used to display the output in different colors
			test.log(Status.FAIL, result.getName());
			test.log(Status.FAIL, result.getThrowable());

			// To capture screenshot path and store the path of the screenshot in the string
			// "screenshotPath"
			// We do pass the path captured by this method in to the extent reports using
			// "logger.addScreenCapture" method.

			String screenshotPath = ScreenUtil.TakeScreenshot(driver, result.getName());

			// To add it in the extent report
			test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));
		} 
		else if (result.getStatus() == ITestResult.SKIP)
		{
			test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " Test Case Skipped", ExtentColor.ORANGE));
			// test.log(Status.SKIP, result.getName());
		} 
		else if (result.getStatus() == ITestResult.SUCCESS) 
		{
			// test.log(Status.PASS, result.getName());

			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
		
	}
}
