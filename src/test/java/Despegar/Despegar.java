package Despegar;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Despegar {
	By locatoralojamientos = By.xpath("//a[@href='//www.despegar.com.ar/hoteles/']");
	By ciudadlocator = By.cssSelector("div.input-container>input[placeholder = 'Ingresá una ciudad, alojamiento o punto de interés']");
	By primercalendario = By.xpath("//div[@class='sbox5-box-dates-checkbox-container']//div[@class='sbox5-dates-input1']");
	By primerfecha = By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid'][@data-month='2022-03']//div[@class='sbox5-monthgrid-datenumber-number'][text()='16']");
	By segundocalendario = By.xpath("//div[@class='sbox5-box-dates-ovr sbox5-dates-container']//div[@class='sbox5-dates-input2']");
	By segundafecha = By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid'][@data-month='2022-03']//div[@class='sbox5-monthgrid-datenumber-number'][text()='26']");
	By botonpasajeros = By.cssSelector(".sbox5-3-double-input");
	By aplicar = By.xpath("//button[@class='sbox5-box-button-ovr sbox5-3-btn -secondary -icon -lg']");
	By verificacion = By.xpath("//li[@class='sub-nav-item -active']");

	
	@Test
	public void DespegarTrabajo() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:/ChromeDrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get("https://www.despegar.com.ar/");
		driver.findElement(locatoralojamientos).click();		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ciudadlocator));		
		WebElement searchInputOrigen = driver.findElement(ciudadlocator);
		searchInputOrigen.click();
		Assert.assertTrue(searchInputOrigen.isDisplayed(), "No se encontro titulo");
		searchInputOrigen.sendKeys( "Córdoba, Córdoba, Argenti");
		Thread.sleep(1500);
		searchInputOrigen.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(primercalendario));	
		WebElement primerfechacal = driver.findElement(primercalendario);
		primerfechacal.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(primerfecha));	
		WebElement primerfechaseleccionada = driver.findElement(primerfecha);
		primerfechaseleccionada.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(segundocalendario));
		WebElement segundafechacal = driver.findElement(segundocalendario);
		segundafechacal.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(segundafecha));
		WebElement segundafechaseleccionada = driver.findElement(segundafecha);
		segundafechaseleccionada.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(aplicar));
		WebElement aplicarbtn = driver.findElement(aplicar);
		aplicarbtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(verificacion));
		WebElement verificacionBanner =driver.findElement(verificacion);
		Assert.assertTrue(verificacionBanner.isDisplayed(), "El banner no se encontro");
		wait.until(ExpectedConditions.visibilityOfElementLocated(verificacion));
		driver.close();
		
	}
}
