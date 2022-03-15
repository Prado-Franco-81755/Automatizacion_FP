package DespegarResultsPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;





public class DespegarResultsPage {
	@FindBy(id="firstHeading")
	  WebElement titulo;  
	@FindBy(xpath = "//li[@class='sub-nav-item -active']")
	  WebElement verificacionBanner;
	  
	  
	  private WebDriver driver = null;
	  
	  public DespegarResultsPage (WebDriver driver) {
		  this.driver = driver;
		  PageFactory.initElements(driver, this);		  
	  }
	  
	  public boolean tituloEsVisible() {
		  return this.titulo.isDisplayed();
	  }
	  
	  public boolean verificacionBannerBuscar() throws Exception{
		  Thread.sleep(3000);
		  this.verificacionBanner.isDisplayed();
		  return true;
	  }
}
