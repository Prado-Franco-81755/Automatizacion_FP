package WikiTests2;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import WikiHomePage.WikiHomePage;
import WikiResultsPage.WikiResultsPage;
import Utils.BaseTest;



public class WikiTests2 {
  @Test(description = "Validar que las busquedas en Wikipedia funcionan")
  public void ValidarBusquedaWikipedia()throws Exception {
	  WebDriver driver = BaseTest.iniciarDriver("Chrome");
	  BaseTest.goToMainPage(driver);
	  WikiHomePage homePage = new WikiHomePage(driver);
	  Assert.assertTrue(homePage.searchInputEsVisible(), "El input no esta visible");
	  WikiResultsPage resultsPage = homePage.searchText("Selenium");
	  Assert.assertTrue(resultsPage.tituloEsVisible(), "El titulo no esta visible");
	  driver.close();
	  
  }
}
