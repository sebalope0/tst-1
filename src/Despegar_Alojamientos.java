import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Despegar_Alojamientos {

	  @Test(description = "Verificar que las busquedas de alojamiento funcionan")
	  
	  public void VerificarAlojamientoDespegar() throws Exception {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\gerar\\OneDrive\\Documentos\\__VATES__\\automation\\chromedriver_win32\\chromedriver.exe"); 
		  
		  //incializar / instanciar webdriver
		  WebDriver driver = new ChromeDriver();
		  WebDriverWait wait = new WebDriverWait(driver, 30);
		  
		  String inputCiudad = "span.item-text";
		  
		  String calendar = ".sbox5-floating-tooltip-opened div.calendar-container";
		  
		  String exptdtitle = "Alojamientos - Despegar";
		  
		  //open web site
		  driver.get("https://www.despegar.com.ar");
		  
		  //maximize web browser
		  driver.manage().window().maximize();
		  
		  //click alojamientos
		  driver.findElement(By.cssSelector("a.HOTELS")).click();
		  
		  //click destino
		  driver.findElement(By.cssSelector("#searchbox-sbox-box-hotels .sbox5-box-places-ovr.sbox-places-container--3kBK7  input.input-tag")).click();
		  Thread.sleep(500);
		  
		  //escribir destino
		  driver.findElement(By.cssSelector("#searchbox-sbox-box-hotels .sbox5-box-places-ovr.sbox-places-container--3kBK7  input.input-tag")).sendKeys("Mendoza, Mendoza, Argentina");
		  
		  //Espera a que aparezca la lista deplegable del buscador de destinos
		  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(inputCiudad))).click();

		  //click en fechas
		  driver.findElement(By.cssSelector("#searchbox-sbox-box-hotels .sbox5-dates-input1-container  input.input-tag")).click();
		  
		  //Espera a que aparezca el calendario
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(calendar)));
		  
		  //elegir fecha - in (20 de septiembre)
		  driver.findElement(By.xpath("//*[@class=\"sbox5-floating-tooltip sbox5-floating-tooltip-opened\"]//*[@data-month=\"2022-09\"]//*[text()=20]")).click();
		  
		  //elegir fecha - out (24 de septiembre
		  driver.findElement(By.xpath("//*[@class=\"sbox5-floating-tooltip sbox5-floating-tooltip-opened\"]//*[@data-month=\"2022-09\"]//*[text()=24]")).click();
		 
		  // click btn aplicar
		  driver.findElement(By.cssSelector(".sbox5-floating-tooltip-opened .sbox5-3-btn .btn-text")).click();
		  
		  //seleccionar camas
		  WebElement camas = driver.findElement(By.id("svg-bed-3xwvNFB"));
		  Assert.assertTrue(camas.isDisplayed());
		  camas.click();
		  Thread.sleep(250);
		  
		  //seleccionar cant adultos
		  driver.findElement(By.cssSelector(".stepper__room  button.steppers-icon-right")).click();
		  
		  //seleccionar cant ninos
		  driver.findElement(By.cssSelector(".stepper__room > div.stepper__distribution_container > "
		  		                          + "div:nth-child(2) button.steppers-icon-right")).click();
		  
		  // lista edad
		  Select drpSelect = new Select (driver.findElement(By.className("select") ));
		  drpSelect.selectByValue("2");
		  
		  //Aplicar
		  driver.findElement(By.cssSelector(".sbox5-floating-tooltip-opened a.sbox5-3-btn")).click();
		  
		  //Buscar
		  driver.findElement(By.cssSelector(".sbox5-box-content > button")).click();
		  
		  //obtener titulo actual
		  String title = driver.getTitle();
		  //validar el titulo de la pagina de resultados de la busqueda (comaparar con resultado esperado)
		  
		  Assert.assertTrue( title.equals(exptdtitle), "El titulo deberia ser " + exptdtitle +" y es: " + title);
		  
		  /*Assert.assertEquals(title, "Alojamientos - Despegar" );*/
		  System.out.println("el titulo es: " + title);
		  driver.close();
		  
	  } // end public void VerificarAlojamientoDespegar
	  
} // end class Despegar_Alojamientos
