package FileUploadDownload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderExamples 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\sudhanya\\BrowserDrivers\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://demo.automationtesting.in/Slider.html");
		driver.manage().window().maximize();
		
		WebElement slider=driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div/a"));
		Actions acct=new Actions(driver);
		acct.moveToElement(slider).dragAndDropBy(slider, 200, 0).build().perform();	
		System.out.println("done");		
	}

}
