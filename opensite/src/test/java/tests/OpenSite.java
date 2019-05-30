package tests;

import static org.junit.Assert.*;



import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenSite {
    private WebDriver driver;
    
	@Test
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\libs\\chromedriver_win32\\chromedriver.exe");
		WebDriver drive = new ChromeDriver();
		drive.get("http://www.google.com");

		// Pesquisa Empresa
		WebElement busca = drive.findElement(By.name("q"));
		busca.sendKeys("Samaia It");
		busca.submit();

		// Formulario contato
		drive.get("https://samaiait.com.br/");
		drive.get("https://www.portalinvestigativo.com.br/");
		WebElement saibamais = drive.findElement(By.linkText("Contato"));
		saibamais.click();

		// preencer formulário
		WebElement nome = drive.findElement(By.id("nome"));
		nome.sendKeys("teste");
		WebElement email = drive.findElement(By.id("email"));
		email.sendKeys("teste");
		WebElement telefone = drive.findElement(By.id("telefone"));
		telefone.sendKeys("999999999");
		WebElement mensagem = drive.findElement(By.id("mensagem"));
		mensagem.sendKeys("Teste Automatizado");
		WebElement submeter = drive.findElement(By.id("enviar"));

		submeter.submit();

		WebElement resultado = drive.findElement(By.id("contato_lvl01"));
		String formulario = resultado.getText();
		System.out.println(formulario);

	}

}
