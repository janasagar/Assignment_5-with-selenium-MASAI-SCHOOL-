package test_suite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class jsexecutor {
	WebDriver driver;
	
	@BeforeTest
	public void visit() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com");
		
		driver.manage().window().maximize();
		Thread.sleep(4000);
	}
	@Test
	public void tst() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement el = driver.findElement(By.id("inputValEnter"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement sc_bt = driver.findElement(By.className("searchTextSpan"));
		js.executeScript("arguments[0].click();", el);
        js.executeScript("arguments[0].value='Shoes';", el);
        
        
        js.executeScript("arguments[0].click();", sc_bt);
        
        Thread.sleep(4000);
      
	}
	@AfterTest
	public void close() {
		driver.quit();
	}
}
