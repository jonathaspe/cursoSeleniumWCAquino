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
    public void testeInicial() {
        System.setProperty("webdriver.chrome.driver", "/Users/jonathasf/Documents/Automacao/Cursos/driver/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file://" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
        System.out.println(driver.getTitle());
        Assert.assertEquals("Campo de Treinamento", driver.getTitle());
    }

    @Test
    public void testeTextField() {
        System.setProperty("webdriver.chrome.driver", "/Users/jonathasf/Documents/Automacao/Cursos/driver/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file://" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Jonathas");
        Assert.assertEquals("Jonathas", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
    }
}
