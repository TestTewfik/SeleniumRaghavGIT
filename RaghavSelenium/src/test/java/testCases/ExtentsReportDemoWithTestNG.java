package testCases;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentsReportDemoWithTestNG {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;
	ExtentTest test;

	@BeforeSuite
	public void setUpExtent() {

		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);


	}

	@BeforeTest
	public void setUp() {

		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/main/resources/browsers/chromedriver");
		driver = new ChromeDriver();
	}

	@Test
	public void test1() throws IOException {
		// creates a toggle for the given test, adds all log events under it    
		test = extent.createTest("GoogleSearch Test one", "validate google search fonctionality");

		driver.get("https://www.google.com");
		test.pass("Entered navigation web");
		
		// log(Status, details)
		
		
			driver.findElement(By.id("lst-ib88")).sendKeys("Tewfik belattar");
			test.pass("Entering text in serch box");
		
			
			
		



		test.log(Status.INFO, "This step shows usage of log(status, details)");

		// info(details)
		test.info("This step shows usage of info(details)");

		// log with snapshot
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");

	}



	@AfterTest
	public void tearDown() {
		// calling flush writes everything to the log file
		driver.close();
		driver.quit();

		test.pass("close browser");
		test.log(Status.INFO, "closeing browser");
	}

	@AfterSuite
	public void tearDownFlush() {
		// calling flush writes everything to the log file
		extent.flush();
	}
}
