package headlesstTesting;

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
 
class FirefoxTest {
/**
* @param args
*/
       public static void main(String[] args) 
       {
    	   
    	   System.setProperty("webdriver.gecko.driver", "C:\\Users\\sudhanya\\BrowserDrivers\\geckodriver.exe");
    	   
           FirefoxOptions options=new FirefoxOptions();
           options.setHeadless(true);
           
    	  // objects and variables instantiation 	  
    	   FirefoxDriver driver = new FirefoxDriver(options);
    	   
           String appUrl = "https://accounts.google.com";
              
           // launch the firefox browser and open the application url
            driver.get(appUrl);
              
           // maximize the browser window
            driver.manage().window().maximize();
              
            // declare and initialize the variable to store the expected title of the webpage.
              String expectedTitle = "Sign in – Google accounts";
              System.out.println("Exp"+expectedTitle);
             // fetch the title of the web page and save it into a string variable
              String actualTitle = driver.getTitle();
              
              // compare the expected title of the page with the actual title of the page and print the result
              if (expectedTitle.equals(actualTitle))
              {
                     System.out.println("Verification Successful - The correct title is displayed on the web page.");
              }
             else
              {
            	 	 System.out.println("Act"+actualTitle);
                     System.out.println("Verification Failed - An incorrect title is displayed on the web page.");
              }
 
              // enter a valid username in the email textbox
              WebElement username = driver.findElement(By.id("identifierId"));
              username.clear();
              username.sendKeys("mercurytours");
              
              //Click on Next button
              WebElement NextButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/span/span"));
              NextButton.click();
              
             // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
              
              // enter a valid password in the password textbox
              //WebElement password = driver.findElement(By.name("password"));
             // password.clear();
             // password.sendKeys("password123");
              
            WebDriverWait wait=new WebDriverWait(driver, 20);  
            WebElement password;
            password= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input")));
            password.sendKeys("password123");
 
            //Click on Next button
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement NexttButton=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div[2]"));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", NexttButton);
             
            // close the web browser
              driver.close();
              System.out.println("Test script executed successfully.");
              
              // terminate the program
              System.exit(0);
       }
}