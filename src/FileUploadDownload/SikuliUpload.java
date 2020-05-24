package FileUploadDownload;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliUpload {

	private static Object time_in_seconds;

	public static void main(String[] args) throws InterruptedException, FindFailed {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\sudhanya\\BrowserDrivers\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		
		WebElement Image=driver.findElement(By.id("imagesrc"));		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",Image);
		
		String imagepath1="C:\\Users\\sudhanya\\eclipse-workspace\\SikuliImagePath\\textbox.PNG";
		String imagepath2="C:\\Users\\sudhanya\\eclipse-workspace\\SikuliImagePath\\open.PNG";
		String filepath="C:\\Users\\sudhanya\\eclipse-workspace\\SikuliDataPath\\";
		System.out.println(ImagePath.setBundlePath("C:\\Users\\sudhanya\\eclipse-workspace\\SikuliImagePath\\textbox.PNG"));
		
		Screen s=new Screen();
		Pattern textbox=new Pattern(imagepath1);
		Thread.sleep(1000);
		Thread.sleep(1000);
		
		Pattern openbutton=new Pattern(imagepath2);
		Thread.sleep(1000);
		Thread.sleep(1000);
		   
		s.wait(textbox,30);
		s.type(textbox,filepath+"importData.csv");
		s.click(openbutton);

	}

}
