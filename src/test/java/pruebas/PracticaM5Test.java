package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class PracticaM5Test {
	String url = "http://www.automationpractice.pl/";
	WebDriver driver;
	String archivoDatos = "..\\EducacionIT-72609\\Datos\\Datos_Login_30Jul2024.xlsx";
	
	@BeforeSuite
	public void setUp() {
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="Datos Login Excel")
	public void iniciarSesion(String email, String password) {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		//login.ingresarCredenciales("correo@gmail.com", "1q2w3e4r5t");
		
		login.escribirCorreo(email);
		login.escribirPassword(password);
		login.hacerClicEnLogin();
	}
	
	@DataProvider(name="Datos Login Excel")
	public Object[][] obtenerDatosExcel() throws Exception {
		// 2) Leer un excel y que devuelva sus datos en una lista de objetos
		return DatosExcel.leerExcel(archivoDatos, "Hoja1");
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatos() {
		// 1) Elaboremos la lista de datos a usar
		Object[][] datos = new Object[3][2];
		
		// Combinacion de Datos 1
		datos[0][0] = "abc@gmail.com";
		datos[0][1] = "1q2w3e";
		
		// Combinacion de Datos 2
		datos[1][0] = "def@gmail.com";
		datos[1][1] = "3e4r5t";
		
		// Combinacion de Datos 3
		datos[2][0] = "ghi@gmail.com";
		datos[2][1] = "4r5t6y";
		
		return datos;
	}
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
}
