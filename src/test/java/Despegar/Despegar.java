package Despegar;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Despegar {
	By locatoralojamientos = By.xpath("//a[@href='//www.despegar.com.ar/hoteles/']");
	By ciudadlocator = By.cssSelector("div.input-container>input[placeholder = 'Ingresá una ciudad, alojamiento o punto de interés']");
	By primercalendario = By.xpath("//div[@class='sbox5-box-dates-checkbox-container']//div[@class='sbox5-dates-input1']");
	By primerfecha = By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid'] [@data-month='2022-03']//div[@class='sbox5-monthgrid-datenumber-number'][text()='16']");
	By segundocalendario = By.xpath("//div[@class='sbox5-box-dates-ovr sbox5-dates-container']//div[@class='sbox5-dates-input2']");
	By segundafecha = By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid'][@data-month='2022-03']//div[@class='sbox5-monthgrid-datenumber-number'][text()='26']");
	By botonpasajeros = By.cssSelector(".sbox5-3-double-input");
	By aplicar = By.xpath("//button[@class='sbox5-box-button-ovr sbox5-3-btn -secondary -icon -lg']");
	
	@Test
	public void DespegarTrabajo() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:/ChromeDrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get("https://www.despegar.com.ar/");
		driver.findElement(locatoralojamientos).click();
		Thread.sleep(1500);
		WebElement searchInputOrigen = driver.findElement(ciudadlocator);
		searchInputOrigen.click();
		Assert.assertTrue(searchInputOrigen.isDisplayed(), "No se encontro titulo");
		searchInputOrigen.sendKeys( "Córdoba, Córdoba, Argenti");
		Thread.sleep(1000); 
		searchInputOrigen.sendKeys(Keys.ENTER);
		Thread.sleep(2500);
		WebElement primerfechacal = driver.findElement(primercalendario);
		primerfechacal.click();
		Thread.sleep(1500);
		WebElement primerfechaseleccionada = driver.findElement(primerfecha);
		primerfechaseleccionada.click();
		Thread.sleep(1500);
		WebElement segundafechacal = driver.findElement(segundocalendario);
		segundafechacal.click();
		Thread.sleep(1500);
		WebElement segundafechaseleccionada = driver.findElement(segundafecha);
		segundafechaseleccionada.click();
		Thread.sleep(2500);
		WebElement aplicarbtn = driver.findElement(aplicar);
		aplicarbtn.click();
		Thread.sleep(4500);
		driver.close();
		
	}
}
