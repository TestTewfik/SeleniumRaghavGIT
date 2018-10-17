package testCases;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test1_GoogleSearch  {

	
	static String projectPath;
	static WebDriver driver;
	
	public static void main(String[] args) {
		googleSearch();
		LogginFile.log.info("is Test1_googleClasse");

	}
	
	public static void googleSearch() {
		projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/main/resources/browsers/chromedriver");
		driver = new ChromeDriver();
		//driver.manage().deleteAllCookies();
	//	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		
		
		driver.findElement(By.id("lst-ib")).sendKeys("Tewfik belattar");
		driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		
	}

}
