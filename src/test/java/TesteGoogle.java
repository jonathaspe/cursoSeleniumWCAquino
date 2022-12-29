import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {
    WebDriver driver;
    @After
    public void encerrar(){
        driver.quit();
    }
    @Test
    public void acessoInicial() {
        System.setProperty("webdriver.chrome.driver", "/Users/jonathasf/Documents/Automacao/Cursos/driver/chromedriver/chromedriver");
        driver = new ChromeDriver();
//        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        Assert.assertEquals("Google", driver.getTitle());
    }
}
