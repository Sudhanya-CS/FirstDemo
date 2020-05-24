package FileUploadDownload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassess {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\sudhanya\\BrowserDrivers\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		 Thread.sleep(1000);
		 Thread.sleep(1000);
		 
		//Mouse Hover
		Actions actions = new Actions(driver);
        WebElement menuOption1 = driver.findElement(By.id("menu_pim_viewPimModule"));  
        WebElement menuOption2=driver.findElement(By.id("menu_pim_Configuration"));
        WebElement menuOption3=driver.findElement(By.id("menu_admin_pimCsvImport"));
        Thread.sleep(1000);
        Thread.sleep(1000);
        Thread.sleep(1000);
        
        actions.moveToElement(menuOption1).perform();
        Thread.sleep(1000);
        Thread.sleep(1000);
        
        actions.moveToElement(menuOption2).perform();
        Thread.sleep(1000);
        Thread.sleep(1000);
        
        actions.moveToElement(menuOption3).click().build().perform();
        Thread.sleep(1000);
        Thread.sleep(1000);
      	}

}
