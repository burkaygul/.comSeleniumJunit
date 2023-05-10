package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Assertions {

    WebDriver driver;
    public void mahserin4Atlisi(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }

    // https://www.bestbuy.com/ adresine gidin farkli test methodlari olusturararak asagidaki testleri yapin



    @Test
    public void test01(){

        // Sayfa Url nin https://www.bestbuy.com/ 'a esit oldugunu test edin

        mahserin4Atlisi();

        String expectedUrl ="https://www.bestbuy.com/";
        String actualUrl  =driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);

        driver.close();
    }

    @Test
    public void test02(){

        mahserin4Atlisi();


        //Sayfa basliginin "Rest" icermedigini(contains) test edin


        String unExpectedTitle = "Rest";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains(unExpectedTitle));

        driver.close();
    }

    @Test
    public void test03(){
        //BestBuy logosunun goruntulendigini test edin

        mahserin4Atlisi();


        WebElement BestBuyLogo  = driver.findElement(By.xpath("(//*[@class='logo'])[1]"));

        Assert.assertTrue(BestBuyLogo.isDisplayed());

        driver.close();
    }

    @Test
    public void test04(){
        //Fransizca Linkin goruntulendigini test edin

        mahserin4Atlisi();


        WebElement FrLink = driver.findElement(By.xpath("//*[text()='Français']"));

        Assert.assertTrue(FrLink.isDisplayed());

        driver.close();
    }



}
