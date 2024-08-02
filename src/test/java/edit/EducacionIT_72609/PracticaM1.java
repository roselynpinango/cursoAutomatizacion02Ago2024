package edit.EducacionIT_72609;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PracticaM1 {
	// Defino la URL que voy a utilizar para mi prueba
	String url = "http://www.automationpractice.pl/";

	// Pruebas que vamos a hacer
	@Test
	public void buscarPalabraEdge() {
		// (1) Definir qué navegador vamos a usar
		WebDriver navegador = new EdgeDriver();

		// (2) Abrir el navegador en la página de prueba
		navegador.get(url);

		// (3) Maximizar la ventana del navegador
		navegador.manage().window().maximize();
		navegador.manage().deleteAllCookies(); // Borra las cookies
		
		// (4) Localizar el campo de texto para buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));

		// (5) Escribir la palabra a buscar
		txtBuscador.sendKeys("dress");

		// (6) Localizar el botón (lupa)
		WebElement btnBuscar = navegador.findElement(By.name("submit_search"));

		// (7) Hacer clic en el botón (Lupa)
		btnBuscar.click();
		
		// (8) Cerrar el navegador
		//navegador.close();
	}
	
	@Test
	public void buscarPalabraFirefox() {
		// (1) Definir qué navegador vamos a usar
		WebDriver navegador = new FirefoxDriver();

		// (2) Abrir el navegador en la página de prueba
		navegador.get(url);

		// (3) Maximizar la ventana del navegador
		navegador.manage().window().maximize();
		navegador.manage().deleteAllCookies(); // Borra las cookies
		
		// (4) Localizar el campo de texto para buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));

		// (5) Escribir la palabra a buscar
		txtBuscador.sendKeys("dress");

		// (6) Simular que presionamos la tecla enter
		txtBuscador.sendKeys(Keys.ENTER);
		
		// (7) Cerrar el navegador
		//navegador.close();
	}
}
