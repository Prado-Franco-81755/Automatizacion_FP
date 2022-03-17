package Despegar2;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import DespegarHomePage.DespegarHomePage;
import DespegarResultsPage.DespegarResultsPage;
import Utils.BaseTest;



public class Despegar2 {
	public WebDriver driver = null;
	
	@BeforeMethod
	public void setup() {
		driver = BaseTest.iniciarDriver("Chrome");
		BaseTest.goToMainPage2(driver);
	}
	
	
	@Test(description = "Validar que las busquedas en Despegar funcionan")
	  public void ValidarBusquedaWikipedia()throws Exception {
		  DespegarHomePage homePage = new DespegarHomePage(driver);
		  DespegarResultsPage homePage2 = new DespegarResultsPage(driver);
		  Assert.assertTrue(homePage.abrirAlojamiento(), "No es posible clickear");
		  //DespegarResultsPage resultsPage = homePage.searchText(" Córdoba, Córdoba, Argenti");
		  Assert.assertTrue(homePage.ingresarCiudad( "Córdoba, Córdoba, Argenti"), "No se clickeo la label");
		  Assert.assertTrue(homePage.seleccionCalendarioIda(), "No se selecciono calendario");
		  Assert.assertTrue(homePage.seleccionarPrimerFecha(), "No se puede seleccionar la primer fecha");
		  Assert.assertTrue(homePage.seleccionCalendarioVuelta(), "No se selecciono calendario vuelta");
		  Assert.assertTrue(homePage.seleccionarSegundaFecha(), "No se puede seleccionar segunda fecha");
		  Assert.assertTrue(homePage.seleccionarBuscar(), "No se selecciono el boton");
		  //Assert.assertTrue(homePage.searchInputEsVisible(), "El input no esta visible");
		  Assert.assertTrue(homePage2.verificacionBannerBuscar(), "El banner esta visible");
		  
		  //Assert.assertTrue(homePage2.tituloEsVisible(), "El titulo no esta visible");
	}
	
	@AfterMethod
	public void endSetup() {
		driver.close();
	}
}

