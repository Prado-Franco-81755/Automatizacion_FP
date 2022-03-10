package Utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Reporter;

public class BaseTest {
	public static WebDriver iniciarDriver(String url, String browserName){
		WebDriver driver = null;
		switch(browserName){
			case "Chrome": {
				System.setProperty("webdriver.chrome.driver", "C:/ChromeDrivers/chromedriver.exe");
				System.out.println("Abro browser de chrome");
				driver = new ChromeDriver();
				break;
				}
			//case "FIREFOX": {
				//System.setProperty("webdriver.gecko.driver", "lugar donde esta");
				//System.out.println("Abro browser Firefox");
				//driver = new FirefoxDriver();
				//break;
				//}
			default : {
				System.out.println("No se seleeciono ningun browser correcto, se le asignara Chrome");
				System.setProperty("webdriver.chrome.driver", "lugar donde esta");
				System.out.println("Abro browser Chrome");
				driver = new ChromeDriver();
				break;
				}
			}
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return driver;
	}
}