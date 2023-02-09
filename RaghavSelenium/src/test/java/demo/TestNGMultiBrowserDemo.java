package demo;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class TestNGMultiBrowserDemo {


	
	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");

//	WebDriver driver = null;
//	String projectPath = System.getProperty("user.dir");
	
	@Parameters("browserName")
	@BeforeTest
	public void setUp(String browserName) {
		System.out.println("Browser name is :" + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {	
			System.setProperty("webdriver.chrome.driver", projectPath+"/src/main/resources/browsers/chromedriver");
			driver = new ChromeDriver();

		} else  if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", projectPath+"/src/main/resources/browsers/geckodriver");
			driver = new FirefoxDriver();
		}

	}

	@Test
	public void test1() throws Exception {
		driver.get("https:google.com");
		Thread.sleep(6000);

	}

	
	@AfterTest
	public void tearDown() {

		driver.close();
	}

}
