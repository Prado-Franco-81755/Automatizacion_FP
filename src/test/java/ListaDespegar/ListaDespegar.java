package ListaDespegar;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class ListaDespegar{
	By listado = By.xpath("//ul[@class='header-list-products']/li");
	
	

	@Test
	public void DespegarTrabajo() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:/ChromeDrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get("https://www.despegar.com.ar/");
		Thread.sleep(1000);
		List<WebElement> lista = driver.findElements(listado);
		for (WebElement elemento : lista) {
				Thread.sleep(2000);
				Assert.assertTrue(elemento.isDisplayed(), "No se puede cargar el elemento");
				//elemento.click();
				System.out.println(elemento.getText());
			
		}
	}
}