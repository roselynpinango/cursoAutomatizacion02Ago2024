package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaAlerta {
	// Elementos Web
	@FindBy(css="#alertButton")
	WebElement btnNotificacion;
	
	@FindBy(xpath="//button[@id='promtButton']")
	WebElement btnPrompt;
	
	// Constructor
	public PaginaAlerta(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Acciones
	public void hacerClicEnNotificacion() {
		btnNotificacion.click();
	}
	
	public void hacerClicEnPrompt() {
		btnPrompt.click();
	}
}
