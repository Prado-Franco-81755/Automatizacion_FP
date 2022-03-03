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
		//La verdad profe, no se para que puse esto, pero siento que deberia agregar algo abajo
		//aunque no haga nada
		System.setProperty("webdriver.chrome.driver", "C:/ChromeDrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://wikipedia.org");
		WebElement searchInput = driver.findElement(By.id("searchInput"));		
		Assert.assertTrue(searchInput.isDisplayed(), "El elemento esta visible");
	}
}
