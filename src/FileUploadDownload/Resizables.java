package FileUploadDownload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Resizables 
{
	public static void main(String[] args) 
	{
	System.setProperty("webdriver.gecko.driver","C:\\Users\\sudhanya\\BrowserDrivers\\geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	driver.get("http://demo.automationtesting.in/Resizable.html");
	driver.manage().window().maximize();
	
	WebElement resize=driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div/div/div[3]"));
	Actions acct=new Actions(driver);
	acct.moveToElement(resize).dragAndDropBy(resize, 400, 400).build().perform();	
	System.out.println("done");	
}
}