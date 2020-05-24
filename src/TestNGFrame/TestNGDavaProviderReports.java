package TestNGFrame;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import com.test.Utility.TestUtil;
import java.util.ArrayList;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestNGDavaProviderReports
{
	@Test(dataProvider="getTestData")
	public void register(String fullname,String email,String phone,String gender,String Country) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sudhanya\\BrowserDrivers\\geckodriver.exe");	
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		String appUrl = "http://demo.automationtesting.in/Register.html";
		driver.get(appUrl);
		Thread.sleep(1000);
		
		WebElement fname=driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[1]/div[1]/input"));
		fname.clear();
		fname.sendKeys(fullname);
		Thread.sleep(1000);
		
		WebElement mail=driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[3]/div[1]/input"));
		mail.clear();
		mail.sendKeys(email);
		Thread.sleep(1000);
		
		WebElement ophone=driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[4]/div/input"));
		ophone.clear();
		ophone.sendKeys(phone);
		Thread.sleep(1000);
		
		if (gender.equals("Male"))
		{
		WebElement ogender=driver.findElement(By.name("radiooptions"));
		ogender.click();
		Thread.sleep(1000);
		}
		
		WebElement country=driver.findElement(By.xpath("//*[@id=\"countries\"]"));		
		Select odrop=new Select(country);
		odrop.selectByVisibleText(Country);
				
		WebElement submit=driver.findElement(By.id("submitbtn"));
		submit.click();
	}		
	
    @DataProvider    
    public Iterator<Object[]> getTestData() throws Exception 
    {
         ArrayList <Object[]> testdata = TestUtil.getTestDataExcel(); 
         return testdata.iterator();
	}
}
