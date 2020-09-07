package smarte_automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Script {
	
	public static void main(String[] args) throws InterruptedException {
				
		System.setProperty("webdriver.chrome.driver", "D:\\Eclipse-workspace\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Open Flipkart website
		String URL = "https://www.flipkart.com/";
		driver.get(URL);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Actions action = new Actions(driver);
		 action.sendKeys(Keys.ESCAPE);
		
		//Search for Samsung Mobiles
		Actions act = new Actions(driver);
		WebElement search = driver.findElement(By.xpath("//*input[@title='Search for products, brands and more']"));
		search.sendKeys("samsung mobiles");
		  act.moveToElement(search).build().perform();//taking mouse
		  WebElement mobiles = driver.findElement(By.xpath("//*[@id='menu-electronics-tab-0-content']/ul[1]/li[1]/a"));
		  Thread.sleep(2000);
		  mobiles.click();//clicking on mobiles
		  Thread.sleep(2000);
		  
		  //Applying filter
		  Select oSelect  = new Select(driver.findElement(By.xpath("//*[@id='price_range']/li[2]/a/span[1]")));
		  oSelect.selectByValue("10000"); // on price with range “Min” to “10000”
		  
		  List<WebElement> oCheckBox = driver.findElements(By.id("RAM"));
		  int iSize = oCheckBox.size();
		  for(int i=0; i < iSize ; i++ ){		  
		  String sValue = oCheckBox.get(i).getAttribute("title");		  
		  if (sValue.equalsIgnoreCase("2 GB")){		  
		  oCheckBox.get(i).click();		  // RAM as 2GB
		  break;
		  }
		  }
	
		  WebElement brand = driver.findElement(By.xpath("//*[@id='Processor Brand']/div{1]"));
		  brand.click(); 
		  List<WebElement> bCheckBox = driver.findElements(By.xpath("//*[@id='Processor Brand']/div{1]"));
		  int iNo = oCheckBox.size();
		  for(int i=0; i < iNo ; i++ ){		  
		  String sValue = bCheckBox.get(i).getAttribute("title");		  
		  if (sValue.equalsIgnoreCase("Snapdragon")){		  
		  oCheckBox.get(i).click();		  // PROCESSOR BRAND as Snapdragon

		  break;
		  
		  //
		 
		  
		//driver.quit();
		
	}

}
