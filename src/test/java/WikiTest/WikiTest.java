package WikiTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WikiTest {
	@Test(groups= {"grupo_1", "grupo_3"}, description = "Validar que las busquedas en Wikipedia funcionan")
	public void ValidarBusquedaWikipedia() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:/ChromeDrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://wikipedia.org");
		WebElement searchInput = driver.findElement(By.id("searchInput"));
		Assert.assertTrue(searchInput.isDisplayed());
		searchInput.sendKeys("Selenium");
		searchInput.submit();
		WebElement tituloResultado = driver.findElement(By.id("firstHeading"));
		System.out.println("Texto encontrado "+ tituloResultado.getText());
		Assert.assertTrue(tituloResultado.isDisplayed());
		driver.close();
	}
}
