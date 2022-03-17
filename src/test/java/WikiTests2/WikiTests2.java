package WikiTests2;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import WikiHomePage.WikiHomePage;
import WikiResultsPage.WikiResultsPage;
import Utils.BaseTest;

public class WikiTests2 {	
	public WebDriver driver = null;
	
 @BeforeMethod(alwaysRun=true)
	public void setup(ITestContext context) {
	 	String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
	 	String navegador = navegadorTestSuite != null ? navegadorTestSuite : "Chrome";
		driver = BaseTest.iniciarDriver(navegador);
		driver.manage().window().maximize();
		BaseTest.goToMainPage(driver);
	}	
		
  @Test(groups= {"grupo_1", "grupo_3", "grupo_4"}, description = "Validar que las busquedas en Wikipedia funcionan")
  public void ValidarBusquedaWikipedia()throws Exception {	  
	  WikiHomePage homePage = new WikiHomePage(driver);
	  Assert.assertTrue(homePage.searchInputEsVisible(), "El input no esta visible");
	  WikiResultsPage resultsPage = homePage.searchText("Selenium");	  
	  Assert.assertTrue(resultsPage.tituloEsVisible(), "El titulo no esta visible");
  }
  
  @AfterMethod(alwaysRun=true)
  public void endSetup() {
	  if (driver != null) {
			driver.close();
		}
  }
}
