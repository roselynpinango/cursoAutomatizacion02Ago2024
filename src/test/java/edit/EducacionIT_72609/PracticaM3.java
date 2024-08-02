package edit.EducacionIT_72609;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utilidades.CapturaEvidencia;

public class PracticaM3 {
	String url = "http://www.automationpractice.pl";
	WebDriver driver;
	String directorioEvidencias = "..\\EducacionIT-72609\\Evidencias\\";
	File screen;
	String nombreDocumento = "Documento Evidencias - AutomationPractice.docx";
	String nombreImagen = "img.jpg";
	
	@BeforeSuite
	public void abrirNavegador() {
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		// Usualmente también se usa para precondiciones
	}
	
	@Test(priority = 100, description = "CP02 - Ir a Contactanos")
	public void irAContactanos() throws InvalidFormatException, IOException, InterruptedException {
		// Título de Documento
		CapturaEvidencia.escribirTituloEnDocumento(
				directorioEvidencias + nombreDocumento,
				"Documento de Evidencias - 23Jul2024",
				20);
		
		// Captura de Pantalla
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				directorioEvidencias + nombreImagen,
				directorioEvidencias + nombreDocumento,
				"Pantalla Inicial de la Prueba");
		
		// (3) Hacer clic en 'Contact us'
		driver.findElement(By.linkText("Contact us")).click();
		
		// Captura de Pantalla
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				directorioEvidencias + nombreImagen,
				directorioEvidencias + nombreDocumento,
				"Paso 1 - Después de hacer clic en Contact us");
		
		// (4)Completar el formulario
		Select lstSubject = new Select(driver.findElement(By.id("id_contact")));
		lstSubject.selectByVisibleText("Webmaster");
		
		driver.findElement(By.name("from")).sendKeys("correo01@gmail.com");
		driver.findElement(By.cssSelector("#id_order")).sendKeys("ABC-156");
		
		WebElement file = driver.findElement(By.xpath("//input[@id='fileUpload']"));
		file.sendKeys("C:\\addIntegerData.txt"); // Enviar la ruta del archivo que quiero adjuntar
		
		driver.findElement(By.tagName("textarea")).sendKeys("Mensaje de Contacto");
		
		// Captura de Pantalla
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				directorioEvidencias + nombreImagen,
				directorioEvidencias + nombreDocumento,
				"Paso 2 - Después de completar el formulario");
		
		// (5) Hacer clic en 'Send'
		driver.findElement(By.cssSelector("#submitMessage")).click();
		
		// Captura de Pantalla
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				directorioEvidencias + nombreImagen,
				directorioEvidencias + nombreDocumento,
				"Paso 3 - Al enviar el formulario de Contacto");
		
		// Chequear la URL y el titulo de la pagina despues de la prueba
		String urlEsperada = "http://www.automationpractice.pl/index.php?controller=contact";
		//String urlEsperada = "https://google.com";
		String urlActual = driver.getCurrentUrl();
		
		String tituloActual = driver.getTitle(); // Titulo de la Pagina
		
		Assert.assertEquals(urlActual, urlEsperada);
		
		// EXTRA: Soft Assert hace validaciones sin abortar el @Test en caso de falla
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(urlActual, urlEsperada); 
		
		// Otros métodos de comprobación de resultado esperado
		Assert.assertNotEquals("1", "2"); 
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		Assert.assertNull(null);
		Assert.assertNotNull(url);
	}
	
	@Test(priority = 200, description = "CP01 - Buscar palabra")
	public void buscarPalabra() throws IOException {
		// Capturar Pantalla #1
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(directorioEvidencias + "01_pantallaInicial.jpg"));
		
		// Buscar Pagina
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("skirt");
		
		// Capturar Pantalla #2
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(directorioEvidencias + "02_palabraABuscar.jpg"));
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Capturar Pantalla #3
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(directorioEvidencias + "03_resultadoBusqueda.jpg"));
	}
	
	@AfterSuite
	public void cerrarNavegador() {
		// Usualmente se añaden acciones (postcondiciones)
		
		driver.close();
	}
}
