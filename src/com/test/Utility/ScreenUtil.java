package com.test.Utility;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class ScreenUtil
{
public static String TakeScreenshot(WebDriver driver, String screenshotName) throws IOException {
	// String dateName = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	String strDate = formatter.format(date);

	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);

	// after execution, you could see a folder "FailedTestsScreenshots" under src
	// folder
	String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + strDate + ".png";
	File finalDestination = new File(destination);
	FileUtils.copyFile(source, finalDestination);
	return destination;
}
}