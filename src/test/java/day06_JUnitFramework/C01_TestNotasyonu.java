package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TestNotasyonu {

    /*
    Bu class icerisinde 3 test calistiralim
    1- google anasayfaya gidip, url'in google icerdigini test edin
    2- wisequarter anasayfaya gidip url'in wisequarter icerdigini edin
    3- amazon anasayfaya gidip, amazon logosunun gorundugunu test edin
    */

    /*
        JUnit'in bize sagladigi ilk ve belki de en onemli ozellik
        test method'larinin bagimsiz olarak calistirilmasini
        saglayan @Test notasyonudur


        JUnit ile class level'dan birden fazla test method'u calistirirsak
        hangi siralama ile calistiracagini ongoremeyiz ve yonetemeyiz

        Diyelim ki bir test method'u uzerinde calisiyorsunuz
        ve o method'un toplu calistirilmalarda kullanilmasini istemiyorsunuz
        bu durumda @Ignore kullanabilirsiniz
     */
    WebDriver driver;
    @Test @Ignore
    public void googleTest(){

        // 1- google anasayfaya gidip, url'in google icerdigini test edin

        mahserin4atlisi();
        driver.navigate().to("https://www.google.com");

        String expectedInhalt = "google";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedInhalt)){
            System.out.println("Google Test PASSED");
        } else {
            System.out.println("Google Test FAILED");
        }

        driver.close();

    }

    @Test
    public  void wiseTest(){

        mahserin4atlisi();
        driver.get("https://www.wisequarter.com");

        String expectedInhalt = "wisequarter";
        String actualUrl = driver.getCurrentUrl();


        if (actualUrl.contains(expectedInhalt)){
            System.out.println("Wise Test PASSED");
        } else {
            System.out.println("Wise Test FAILED");
        }

        driver.close();
    }

    @Test
    public void amazonTest(){

        mahserin4atlisi();
        driver.get("https://www.amazon.com");
        WebElement amazonLogo = driver.findElement(By.id("nav-logo-sprites"));

        if (amazonLogo.isDisplayed()){
            System.out.println("Amazon Test PASSED");
        } else {
            System.out.println("Amazon Test FAILED");
        }

        driver.close();
    }

    public void mahserin4atlisi(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
}
