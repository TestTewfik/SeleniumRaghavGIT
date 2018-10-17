package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsBasicDemoJava {

	public static WebDriver driver = null;
	public static void main(String[] args) {

		// start reporters
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test1 = extent.createTest("GoogleSearch Test one", "validate google search fonctionality");


		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/main/resources/browsers/chromedriver");
		driver = new ChromeDriver();

		test1.log(Status.INFO, "starting test case");
		driver.get("http://www.google.com");
		test1.pass("Entered navigation web");


		driver.findElement(By.id("lst-ib")).sendKeys("Tewfik belattar");
		test1.pass("Entering text in serch box");

		driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		test1.pass("Entering ENTER Key");


		driver.close();
		driver.quit();

		test1.pass("close browser");
		test1.log(Status.INFO, "closeing browser");



		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test2 = extent.createTest("GoogleSearch Test two", "validate google search fonctionality");


		
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/main/resources/browsers/chromedriver");
		driver = new ChromeDriver();

		test2.log(Status.INFO, "starting test case");
		driver.get("http://www.google.com");
		test2.pass("Entered navigation web");


		driver.findElement(By.id("lst-ib")).sendKeys("Tewfik belattar");
		test2.fail("Entering text in serch box");

		driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		test2.pass("Entering ENTER Key");


		driver.close();
		driver.quit();

		test2.pass("close browser");
		test2.log(Status.INFO, "closeing browser");

		extent.flush();


	}

}
