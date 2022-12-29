import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCampoTreinamento {
    WebDriver driver;
//    @After
//    public void encerrar(){
//        driver.quit();
//    }

    @Test
    // Acessando uma página HTML diretamente do projeto de automacão
    public void testeInicial() {
        System.setProperty("webdriver.chrome.driver", "/Users/jonathasf/Documents/Automacao/Cursos/driver/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file://" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
        System.out.println(driver.getTitle());
        Assert.assertEquals("Campo de Treinamento", driver.getTitle());
    }

    // Realizando uma iteracão com o site
    @Test
    public void testeTextField() {
        System.setProperty("webdriver.chrome.driver", "/Users/jonathasf/Documents/Automacao/Cursos/driver/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file://" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Jonathas");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Santos");
        Assert.assertEquals("Jonathas", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
        Assert.assertEquals("Santos", driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"));
    }

    @Test
    public void deveInteragirComTextArea(){
        System.setProperty("webdriver.chrome.driver", "/Users/jonathasf/Documents/Automacao/Cursos/driver/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file://" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste de automacão com Selenium WebDriver\nPulando linha\nTeste");
        Assert.assertEquals("Teste de automacão com Selenium WebDriver\nPulando linha\nTeste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
    }
}
