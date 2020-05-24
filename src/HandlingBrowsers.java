import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingBrowsers 
{
	 public static void main(String[] args) throws InterruptedException {
         
  	   System.setProperty("webdriver.gecko.driver", "C:\\Users\\sudhanya\\BrowserDrivers\\geckodriver.exe");

  	   // objects and variables instantiation 	  
  	   FirefoxDriver driver = new FirefoxDriver();
  	   
         String appUrl = "http://demo.automationtesting.in/Windows.html";
            
         // launch the firefox browser and open the application url
          driver.get(appUrl);
            
         // maximize the browser window
          driver.manage().window().maximize();
          Thread.sleep(1000);
          driver.findElement(By.linkText("click")).click();
          Thread.sleep(1000);
          Thread.sleep(1000);
         System.out.println(driver.getTitle());
         Set <String> windid= driver.getWindowHandles();
         System.out.println(windid);
         for(String i:windid)
         {
        	 System.out.println(driver.switchTo().window(i).getTitle());
        	 if(driver.switchTo().window(i).getTitle().equals("Sakinalium | Home"))
        	 {
        		 System.out.println("closed");
        		 driver.close();
             }
        	 else
        		 System.out.println("not closed");
         }
}
}
