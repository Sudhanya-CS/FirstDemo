import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
 
class Commands
{
/**
* @param args
*/
       public static void main(String[] args)
       {
              
    	   System.setProperty("webdriver.gecko.driver", "C:\\Users\\sudhanya\\BrowserDrivers\\geckodriver.exe");

    	   // objects and variables instantiation 	  
    	   FirefoxDriver driver = new FirefoxDriver();
    	   
           String appUrl = "https://accounts.google.com";
              
           // launch the firefox browser and open the application url
            driver.get(appUrl);
              
           // maximize the browser window
            driver.manage().window().maximize();
            // get title 
            String title=driver.getTitle();
            System.out.println("*****************************************************");
            System.out.println("TITLE:"+title);
            //get page source
            String page=driver.getPageSource();
            System.out.println("*****************************************************");
            System.out.println("PAGE:"+page); 
            //get current url
            String url=driver.getCurrentUrl();
            System.out.println("******************************************************");
            System.out.println("URL:"+url);
            System.out.println("******************************************************");
            
            //enter a valid username in the email textbox
            WebElement username = driver.findElement(By.id("identifierId"));
            username.clear();
            username.sendKeys("mercurytours");
            
            //Click on Next button
            WebElement NextButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/span/span"));
            NextButton.click();
            
          //Navigate backward
            driver.navigate().back();
            System.out.println("Navigated backward");
            //Navigate forward
            driver.navigate().forward();
            System.out.println("Navigated forward");
            //Refresh
            driver.navigate().refresh();
            System.out.println("Refreshed");
            //navigate to
            driver.navigate().to("https://facebook.com");
            System.out.println("Page loaded");	
            System.out.println("Test Ended Successfully");
            driver.quit();
            System.exit(0);
            
       }
}