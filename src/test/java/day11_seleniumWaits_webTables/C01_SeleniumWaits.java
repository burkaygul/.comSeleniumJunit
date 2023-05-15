package day11_seleniumWaits_webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_SeleniumWaits {
    /*
        Otomasyon yaparken sayfanin yuklenmesi ve webElementlerin bulunmasi icin gerekli sureyi
        implicitly wait ile ayarlariz

        Implicitly wait sayfanin yuklenmesi ve
        her bir webelementin bulunmasi icin tanimlanan
        max. bekleme suresidir.
        her islem icin sifirdan baslar ve max sure doluncaya kadar
        gorevi tamamlamaya calisir
        max sure icerisinde gorev tamamlanamazsa
        exception verip calismayi durdurur

        Testlerin buyuk cogunlugunda
        implicitly wait suresi
        senkronizasyonu saglamak icin yeterli olur
        ANCAK
        ozel bir gorev icin implicitly wait'de tanimlanan
        max. bekleme suresinden daha fazla beklememiz gerekirse
        O GOREVE OZGU, TEK SEFERLIK bir wait olusturabiliriz
     */

    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //Iki metod icin de asagidaki adimlari test edin.
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Remove butonuna basin.
    //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //6. Add buttonuna basin
    //7. It’s back mesajinin gorundugunu test edin

    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        WebElement itsgoneElement = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsgoneElement.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElement = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsBackElement.isDisplayed());

        driver.close();
    }

    @Test
    public void explicitlyWaitTesti(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        /*
            Burada testi manuel olarak yapip
            bir karar vermemiz gerekiyor
            1- test etmek istedigimiz webElement zaten gorunuyorsa
                webelement'i locate yapip sonra ozel beklmeyi tanimlarim
            2- test etmek istedigimiz elementin ulasilabilir olmasi icin
                beklemek gerekiyorsa
                locatar'i verip, "bu locator ile bir element locate edene kadar
                exception firlatma bekle" diyebiliriz
         */

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        WebElement itsgoneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
        Assert.assertTrue(itsgoneElement.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();
        //7. It’s back mesajinin gorundugunu test edin

        WebElement itsBackElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        Assert.assertTrue(itsBackElement.isDisplayed());

    }
}
