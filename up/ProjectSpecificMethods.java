package testNG.up;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethods {

	public ChromeDriver driver;
	public WebDriverWait wait;
	
	@Parameters({"url"})
	@BeforeMethod()
	public void start(String url) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();

		//Add chrome switch to disable notification - "**--disable-notifications**"
		options.addArguments("--disable-notifications");

		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./drivers3/chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);

	}
	
	@AfterMethod
	public void end() {
		driver.quit();	
	}
	
	@DataProvider(name="pin")
	public String[][] getdata() {
		String[][] array= new String[2][1];
		
		array[0][0]="600053";
		array[1][0]="000100";
		return array;
	}

}
