package listeners;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class TestNGListenerDemo {
	
	WebDriver driver;
	@Test
	public void test1() {
		System.out.println("I am inside Test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("I am inside Test 2");
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectPath+"/src/main/resources/browsers/geckodriver");
		driver = new FirefoxDriver();
		
		driver.get("http://www.google.com");
		driver.findElement(By.id("lst-ib")).sendKeys("Tewfik belattar");
		driver.findElement(By.id("abcv")).sendKeys("Tewfik belattar");
		
		//driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		


		driver.close();
		driver.quit();

		

	}
	
	@Test
	public void test3() {
		System.out.println("I am inside Test 3");
		throw new SkipException("This test is skipped :");
	}
	
	

}
