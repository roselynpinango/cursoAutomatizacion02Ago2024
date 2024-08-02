package pruebas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.PaginaAlerta;

public class PracticaM5bTest {
	String url = "https://demoqa.com/alerts";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		// options.addArguments("incognito");
		double zoom = 0.75;
		options.addArguments("--force-device-scale-factor=" + zoom);
		
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void alertaNotificacion() {
		PaginaAlerta pagina = new PaginaAlerta(driver);
		pagina.hacerClicEnNotificacion();
		
		// Manejo de alerta
		Alert alerta = driver.switchTo().alert();
		
		System.out.println("Texto de la alerta: " + alerta.getText());
		
		alerta.accept(); // Clic en Aceptar de la alerta
	}
	
	@Test
	public void alertaPrompt() {
		PaginaAlerta pagina = new PaginaAlerta(driver);
		pagina.hacerClicEnPrompt();
		
		Alert alerta = driver.switchTo().alert();
		alerta.sendKeys("Clase de Automatizacion");
		alerta.accept();
	}
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
}
