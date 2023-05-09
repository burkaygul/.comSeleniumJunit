package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assert {

    // amazon'a gidip title'in AMAZON icerdigini test edin
    @Test
    public void test01(){

        /*
            Junit calistirilan test method(lar)indan kac tanesinin
            passed, failed veya ignore oldugunu otomatik olarak raporlar

            Eger JUnit'in test sonuclarini test sonuclarini dogru olarak raporlamasini
            istiyorsak Assert class'indan hazir method'lar kullanarak test yapmaliyiz

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        String expectedInhalt = "AMAZON";
        String actualTitle = driver.getTitle();

        /*
           if (actualTitle.contains(expectedInhalt)){
            System.out.println("Title Test PASSED");
        } else {
            System.out.println("actual title : " + actualTitle);
            System.out.println("Title Test FAILED");
        }
         */

        Assert.assertTrue(actualTitle.contains(expectedInhalt));
        driver.close();
    }
}
