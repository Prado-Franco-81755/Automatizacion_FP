package ListadoWiki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ListadoWiki {
	
	@DataProvider(name = "Data Provider de Wiki")
	public Object[][] dpMethod(){
		return new Object[][] {{"Selenium"}, {"Java"},{"TestNG"}};
	}
	
	
	@Test(dataProvider = "Data Provider de Wiki", description = "Validar que las busquedas en Wikipedia funcionan")
	public void ValidarBusquedaWikipedia(String searchText) throws Exception{

		System.setProperty("webdriver.chrome.driver", "C:/ChromeDrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://wikipedia.org");
		WebElement searchInput = driver.findElement(By.id("searchInput"));		
		Assert.assertTrue(searchInput.isDisplayed(), "El elemento esta visible");
		searchInput.sendKeys(searchText);
		searchInput.submit();
		Thread.sleep(1500);
		driver.close();
	}
}
