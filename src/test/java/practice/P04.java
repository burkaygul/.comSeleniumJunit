package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P04 {

    // ilgili kurulumlari tamamlayalim
    // Kullanici https://www.google.com adresine gider
    // Çıkıyorsa Kullanici cookies i kabul eder
    // Arama Kutusuna karşilastirma yapmak istedigi para birimlerini girer
    // Para birimlerinin karsilastirmasini alin
    // Karsilastirilacak olan para biriminin 25 den kUCUk oldygu test edilir

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//*[text()='Alle akzeptieren']")).click();
        driver.findElement(By.id("APjFqb")).sendKeys("Euro to TL");
        driver.findElement(By.id("APjFqb")).submit();
        WebElement resultElement = driver.findElement(By.xpath("//*[@class='DFlfde SwHCTb']"));

        String result = resultElement.getText();
        System.out.println(result); //21,45
        result = result.replace(",", ".");
        System.out.println(result); //21.45
        double resultDouble = Double.parseDouble(result);

        Assert.assertTrue(resultDouble < 25);

        if (resultDouble < 25) {
            System.out.println("Şükür hala 25'in altında");
        } else {
            System.out.println("Euro aldı başını gidiyor");
        }

    }

    @After
    public void tearDown(){
        driver.close();
    }

}

