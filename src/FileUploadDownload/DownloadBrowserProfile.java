package FileUploadDownload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadBrowserProfile {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sudhanya\\BrowserDrivers\\geckodriver.exe");

		//Save the file without showing pop up
		FirefoxProfile profile=new FirefoxProfile();
		Thread.sleep(1000);
		Thread.sleep(1000);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain");
		Thread.sleep(1000);
		profile.setPreference("browser.download.manager.showwhenStarting", false);
		Thread.sleep(1000);
		
		//Change the location of file to be downloaded
		profile.setPreference("browser.download.dir", "C:\\Downloads");
		profile.setPreference("browser.download.folderList", 2);
		
		FirefoxOptions options=new FirefoxOptions();
		options.setProfile(profile);	
		
		// objects and variables instantiation
		WebDriver driver = new FirefoxDriver(options);

		String appUrl = "http://demo.automationtesting.in/FileDownload.html";

		// launch the firefox browser and open the application url
		
		driver.get(appUrl);
		driver.manage().window().maximize();
		driver.findElement(By.id("textbox")).sendKeys("Testing");
		driver.findElement(By.id("createTxt")).click();
		driver.findElement(By.id("link-to-download")).click();
		
		
		
	}

}
