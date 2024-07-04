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

public class scroll {
	WebDriver driver;
	
	@BeforeTest
	public void visit() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test
	public void scroll_dw() throws InterruptedException {
		
		driver.findElement(By.id("gh-ac")).sendKeys("Shoes");
		driver.findElement(By.id("gh-btn")).click();
		WebElement rs = driver.findElement(By.cssSelector(".srp-results"));
		WebDriverWait rswait =  new WebDriverWait(driver,Duration.ofSeconds(30));
		rswait.until(ExpectedConditions.visibilityOf(rs));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement resultsContainer = driver.findElement(By.cssSelector(".srp-results"));
        js.executeScript("arguments[0].scrollIntoView(true);", resultsContainer);
		Thread.sleep(2000);
		WebElement topOfPage = driver.findElement(By.tagName("header"));
		js.executeScript("arguments[0].scrollIntoView(true)", topOfPage);
		Thread.sleep(2000);
		driver.findElement(By.id("gh-ac")).clear();
	}
	@AfterTest
	public void close() {
		driver.quit();
	}

}
