package Utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest {
	
	public static void goToMainPage(WebDriver driver) {
		driver.get("http://wikipedia.org");
	}
	
	public static void goToMainPage2(WebDriver driver) {
		driver.get("https://www.despegar.com.ar/");
	}
	

	
	public static WebDriver iniciarDriver(String browserName){
		WebDriver driver = null;
		switch(browserName){
			case "Chrome": {
				System.setProperty("webdriver.chrome.driver", "C:/ChromeDrivers/chromedriver.exe");
				System.out.println("Abro browser de chrome");
				driver = new ChromeDriver();
				break;
				}
			case "FIREFOX": {
				System.setProperty("webdriver.gecko.driver", "C:/ChromeDrivers/geckodriver.exe");
				System.out.println("Abro browser Firefox");
				driver = new FirefoxDriver();
				break;
				}
			default : {
				System.out.println("No se seleeciono ningun browser correcto, se le asignara Chrome");
				System.setProperty("webdriver.chrome.driver", "C:/ChromeDrivers/chromedriver.exe");
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