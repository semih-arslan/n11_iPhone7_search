package n11_search;

import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class iPhone7 {
	 public static void main(String[] args) throws InterruptedException, IOException {
		 
		 File file = new File("D:\\\\Selenium\\chromedriver.exe");
		 System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		 WebDriver driver = new ChromeDriver();
		 		 
		 driver.get("https://www.n11.com/");
		 
		 WebElement giris= driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[2]/div[2]/div[2]/div/div/a[1]"));
		 giris.click();
		 		 
		 WebElement facebook= driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/div[1]/div/div[2]"));
		 facebook.click();
		 		 
		 Set <String> handles =driver.getWindowHandles();
		 Iterator<String> it = handles.iterator();

		 String parent = it.next();
		 String child = it.next();
		 
		 Thread.sleep(1000);

		 driver.switchTo().window(child);
		 Thread.sleep(3000);

		 WebElement email= driver.findElement(By.xpath("//*[@id=\"email\"]"));
		 email.sendKeys("testautomation5858@gmail.com");
		 Thread.sleep(1000);
		 
		 WebElement password= driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		 password.sendKeys("test.1234");
		 Thread.sleep(1000);
		 
		 WebElement girisButton= driver.findElement(By.xpath("//*[@id=\"u_0_0\"]"));
		 girisButton.click();
		 Thread.sleep(1000);
		 
		 driver.switchTo().window(parent);
		 
		 WebElement search_field= driver.findElement(By.xpath("//*[@id=\"searchData\"]"));
		 search_field.sendKeys("iphone7");
		 
		 WebElement searchButton= driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[2]/div[1]/a/span"));
		 searchButton.click();
		 Thread.sleep(3000);
		 
		 WebElement first_result= driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/section[1]/div[2]/ul/li[1]/div/div[1]/a/h3"));
		 String first_text=first_result.getText();
		 System.out.println(first_text);
		 first_result.click();
		 Thread.sleep(1000);
		 
		 WebElement detailed_result= driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/div[1]/div/h1"));
		 String detailed_text=detailed_result.getText();
		 System.out.println(detailed_text);
		 detailed_result.click();	 
		 Thread.sleep(1000);
		 		 
		 assertEquals(first_text, detailed_text);
		 
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileHandler.copy(scrFile, new File("D:\\\\Selenium\\n11_scrrenshot.png"));	 
		 Thread.sleep(1000);
		 
		 WebElement droplist= driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[2]/div[2]/div[2]/div[1]"));
		 Actions mouse = new Actions(driver);
		 mouse.moveToElement(droplist);
		 
		 WebElement logout= driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[2]/div[2]/div[2]/div[2]/div/a[8]"));
		 mouse.moveToElement(logout).click();
		 mouse.build();
		 mouse.perform();
		 Thread.sleep(1000);
		 
		 driver.quit();
	}
}