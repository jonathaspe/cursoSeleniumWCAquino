import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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

    @Test
    public void deveInteragirComRadioButton(){
        System.setProperty("webdriver.chrome.driver", "/Users/jonathasf/Documents/Automacao/Cursos/driver/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file://" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
    }

    @Test
    public void deveInteragirComCheckBox(){
        System.setProperty("webdriver.chrome.driver", "/Users/jonathasf/Documents/Automacao/Cursos/driver/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file://" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
        driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:1")).isSelected());
    }

    @Test
    public void deveInteragirComCombo(){
        System.setProperty("webdriver.chrome.driver", "/Users/jonathasf/Documents/Automacao/Cursos/driver/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file://" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade")).click();
        Select combo = new Select(element);
        combo.selectByIndex(2);
        combo.selectByValue();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:escolaridade")).isSelected());
    }
}
