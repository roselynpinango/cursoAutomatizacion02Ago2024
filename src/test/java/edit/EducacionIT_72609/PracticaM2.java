package edit.EducacionIT_72609;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class PracticaM2 {
	String url = "http://www.automationpractice.pl";
	
	@Test
	public void registrarUsuario() {
		// (1) Definir el navegador
		WebDriver driver = new EdgeDriver();
		
		// (2) Abrir el navegador en la página de prueba
		//driver.get(url);
		driver.navigate().to(url);
		driver.manage().window().maximize();
		
		// (3) Hacer clic en el enlace "Sign in"
		WebElement lnkSign = driver.findElement(By.partialLinkText("Sign"));
		lnkSign.click();
		
		// (4) Escribir el correo
		WebElement txtEmail = driver.findElement(By.cssSelector("#email_create"));
		txtEmail.sendKeys("correo16Jul2024@gmail.com");
				
		// (5) Hacer clic en el botón "Create An Account"
		WebElement btnCreate = driver.findElement(By.xpath("//button[@id='SubmitCreate']"));
		btnCreate.click();
		
		// Se introduce una espera para evitar que el script falle por demora
		WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(15));
		espera.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
		
		// (6) Completar el formulario
		WebElement radMr = driver.findElement(By.id("id_gender1"));
		radMr.click();
		
		WebElement txtFirstname = driver.findElement(By.name("customer_firstname"));
		txtFirstname.sendKeys("Arturo");
		
		WebElement txtLastname = driver.findElement(By.cssSelector("#customer_lastname"));
		txtLastname.sendKeys("Lopez");
		
		WebElement txtCorreo = driver.findElement(By.id("email"));
		txtCorreo.clear(); // Limpio el valor previo que tenía el campo
		
		// Opcion 1: Generar manualmente un correo con un numero aleatorio
		//String correoAleatorio = "correo" + Math.random() + "@gmail.com";
		
		// Opción 2: Librería para generar datos aleatorios
		Faker faker = new Faker();
		String correoAleatorio = faker.internet().emailAddress();
		
		System.out.println("Valor del Correo: "+ correoAleatorio);
		
		txtCorreo.sendKeys(correoAleatorio);
		
		WebElement txtPassword = driver.findElement(By.xpath("//input[@id='passwd']"));
		txtPassword.sendKeys("1q2w3e4r5t");
		
		Select selDays = new Select(driver.findElement(By.name("days")));
		selDays.selectByValue("18");
		
		Select selMonths = new Select(driver.findElement(By.id("months")));
		selMonths.selectByVisibleText("June ");
		
		Select selYears = new Select(driver.findElement(By.cssSelector("#years")));
		selYears.selectByIndex(34);
		
		WebElement chkNews = driver.findElement(By.xpath("//input[@id='newsletter']"));
		chkNews.click();
		
		WebElement btnRegister = driver.findElement(By.name("submitAccount"));
		btnRegister.click();
	}
}
