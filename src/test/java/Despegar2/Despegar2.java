package Despegar2;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import DespegarHomePage.DespegarHomePage;
//import DespegarResultsPage.DespegarResultsPage;
import Utils.BaseTest;


public class Despegar2 {
	@Test(description = "Validar que las busquedas en Despegar funcionan")
	  public void ValidarBusquedaWikipedia()throws Exception {
		  WebDriver driver = BaseTest.iniciarDriver("Chrome");
		  BaseTest.goToMainPage2(driver);
		  DespegarHomePage homePage = new DespegarHomePage(driver);
		  Assert.assertTrue(homePage.abrirAlojamiento(), "No es posible clickear");
		  //Assert.assertTrue(homePage.abrirLabel(), "No se clickeo la label");
		  Assert.assertTrue(homePage.ingresarCiudad( "Córdoba, Córdoba, Argenti"), "No se clickeo la label");
		  Assert.assertTrue(homePage.seleccionCal(), "No se selecciono calendario");
		  Assert.assertTrue(homePage.seleccionarPrimerFecha(), "No se puede seleccionar la primer fecha");
		  //Assert.assertTrue(homePage.searchInputEsVisible(), "El input no esta visible");
		  //DespegarResultsPage resultsPage = homePage.searchText("Córdoba, Córdoba, Argenti");
		  //Assert.assertTrue(resultsPage.tituloEsVisible(), "El titulo no esta visible");
		  //driver.close();
	}
}

