package DespegarHomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DespegarResultsPage.DespegarResultsPage;



public class DespegarHomePage {
	@FindBy(id="searchInputOrigen")
	  WebElement searchInputOrigen;
	@FindBy(xpath = "//a[@href='//www.despegar.com.ar/hoteles/']")
	  WebElement hote;	
	@FindBy(css = "div.input-container>input[placeholder = 'Ingresá una ciudad, alojamiento o punto de interés']")
	  WebElement searchInputOr;
	@FindBy(xpath = "//div[@class='sbox5-box-dates-checkbox-container']//div[@class='sbox5-dates-input1']")
	  WebElement primerfechacal;
	@FindBy(xpath = "//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid'  or @class='sbox5-monthgrid sbox5-compact-view'][@data-month='2022-03']//*[@class='sbox5-monthgrid-datenumber-number'][text()='16']")
	  WebElement primerfechaseleccionada;
	@FindBy(xpath = "//div[@class='sbox5-box-dates-ovr sbox5-dates-container']//div[@class='sbox5-dates-input2']")
	  WebElement segundafechacal;
	@FindBy(xpath = "//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid'  or @class='sbox5-monthgrid sbox5-compact-view'][@data-month='2022-03']//*[@class='sbox5-monthgrid-datenumber-number'][text()='26']")
	  WebElement segundafechaseleccionada;
	@FindBy(xpath = "//button[@class='sbox5-box-button-ovr sbox5-3-btn -secondary -icon -lg']")
	  WebElement aplicarbtn;
	  
	  private WebDriver driver = null ;
	  
	  public DespegarHomePage (WebDriver driver) {
		  this.driver = driver;
		  PageFactory.initElements(driver, this);		  
	  }
	  
	  public boolean searchInputEsVisible() {
		  return this.searchInputOrigen.isDisplayed();
	  }
	  
	  
	  public boolean abrirAlojamiento() {
		  this.hote.click();
		  return this.hote.isDisplayed();
	  }
	  
	  public boolean abrirLabel() {
		  this.searchInputOr.click();
		  return this.searchInputOr.isSelected();
	  }
	  
	  public boolean ingresarCiudad(String text) throws Exception{
		  this.searchInputOr.click();
		  Thread.sleep(1500);
		  this.searchInputOr.sendKeys( "Córdoba, Córdoba, Argenti");
		  Thread.sleep(1500);
		  this.searchInputOr.sendKeys(Keys.ENTER);
		  return true;
	  }
	  
	  public boolean seleccionCal() throws Exception{
		  Thread.sleep(1500);
		  this.primerfechacal.click();
		  return this.primerfechacal.isDisplayed();
	  }
	  
	  public boolean seleccionarPrimerFecha() throws Exception{
		  Thread.sleep(1500);
		  this.primerfechaseleccionada.click();
		  return this.primerfechaseleccionada.isDisplayed();
	  }
	  
	  public DespegarResultsPage searchText(String text){
		  		
		  WebDriverWait wait = new WebDriverWait(driver, 20);
		  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.input-container>input[placeholder = 'Ingresá una ciudad, alojamiento o punto de interés']")));
			//Assert.assertTrue(searchInputOrigen.isDisplayed(), "No se encontro titulo");
		  	searchInputOr.sendKeys( "Córdoba, Córdoba, Argenti");
			//Thread.sleep(1500);
			searchInputOrigen.sendKeys(Keys.ENTER);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sbox5-box-dates-checkbox-container']//div[@class='sbox5-dates-input1']")));	
			
			//primerfechacal.click();
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid'  or @class='sbox5-monthgrid sbox5-compact-view'][@data-month='2022-03']//*[@class='sbox5-monthgrid-datenumber-number'][text()='16']")));	
			
			//primerfechaseleccionada.click();
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sbox5-box-dates-ovr sbox5-dates-container']//div[@class='sbox5-dates-input2']")));
			
			//segundafechacal.click();
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid'  or @class='sbox5-monthgrid sbox5-compact-view'][@data-month='2022-03']//*[@class='sbox5-monthgrid-datenumber-number'][text()='26']")));
			
			//segundafechaseleccionada.click();
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='sbox5-box-button-ovr sbox5-3-btn -secondary -icon -lg']")));
			
			//aplicarbtn.click();
			return new DespegarResultsPage(this.driver);

	  }
}
