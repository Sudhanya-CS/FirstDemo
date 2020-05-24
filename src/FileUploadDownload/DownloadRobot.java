package FileUploadDownload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class  DownloadRobot
{

	public static void main(String[] args) throws AWTException, InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sudhanya\\BrowserDrivers\\geckodriver.exe");

		// objects and variables instantiation
		FirefoxDriver driver = new FirefoxDriver();

		String appUrl = "http://demo.automationtesting.in/FileDownload.html";

		// launch the firefox browser and open the application url
		
		driver.get(appUrl);
		driver.manage().window().maximize();
		driver.findElement(By.id("textbox")).sendKeys("Testing");
		driver.findElement(By.id("createTxt")).click();
		driver.findElement(By.id("link-to-download")).click();
		
		Robot robot=new Robot();
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		File f=new File("C:\\Users\\sudhanya\\Downloads\\info.txt");
		if (f.exists())
		System.out.println("File Exists");	
		else
		System.out.println("File not exists");	
			
}
}
