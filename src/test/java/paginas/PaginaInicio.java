package paginas;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	// Elementos web que voy a utilizar en la prueba
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement lnkSign;
	
	@FindBy(id="search_query_top")
	WebElement txtBuscador;
	
	// Constructor
	public PaginaInicio(WebDriver driver) {
		PageFactory.initElements(driver, this); // inicializa los elementos de esta pagina
	}
	
	// Acciones que necesito hacer sobre los elementos
	public void hacerClicEnSignIn() {
		lnkSign.click();
	}
	
	public void escribirPalabra(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void hacerBusqueda() {
		txtBuscador.sendKeys(Keys.ENTER);
	}
}
