package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertion {

    /*
        Bir Assertion failed olursa
        Assertion'in oldugu satirda exception olusur
        ve assertion satirindan sonraki kodlar CALISMAZ
     */

        WebDriver driver;
        @Test
        public void googleTest(){

            // 1- google anasayfaya gidip, url'in google icerdigini test edin

            mahserin4atlisi();
            driver.navigate().to("https://www.google.com");

            String expectedInhalt = "google1";
            String actualUrl = driver.getCurrentUrl();

            Assert.assertTrue(actualUrl.contains(expectedInhalt));

            driver.close();

        }

        @Test
        public  void wiseTest(){

            mahserin4atlisi();
            driver.get("https://www.wisequarter.com");

            String expectedInhalt = "wisequarter1";
            String actualUrl = driver.getCurrentUrl();

            Assert.assertTrue(actualUrl.contains(expectedInhalt));
            driver.close();
        }

        @Test
        public void amazonTest(
        ){

            mahserin4atlisi();
            driver.get("https://www.amazon.com");
            WebElement amazonLogo = driver.findElement(By.id("nav-logo-sprites"));


            Assert.assertTrue(amazonLogo.isDisplayed());
            driver.close();
        }

        public void mahserin4atlisi(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
    }
