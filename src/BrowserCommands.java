import java.sql.Driver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserCommands
{
	public void main(String args[])
	
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sudhanya\\BrowserDrivers\\geckodriver.exe");
	}

	   // objects and variables instantiation 	  
	   FirefoxDriver driver = new FirefoxDriver();
}