package day09_stitchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import utilities.TestBaseBeforeClass;

import java.util.Set;

public class C02_SwitchingWindows extends TestBase {

    /*
        driver.switchTo().newWindow() kullanarak actigimiz
        window'a driver otomatik olarak gecer

        ANCAKKKKK....
        biz newWindow() method'unu kullanmadan
        bir link tikladigimizda yeni window aciliyorsa
        driver eski window'da kalir
        Yeni window'a driver'i gecirebilmek icin
        yeni window'un WindowHandleDegerine ihtiyacimiz vardir.
     */

    @Test
    public void test01() throws InterruptedException {


        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement openingWindowElement = driver.findElement(By.tagName("h3"));
        String expectedOpeningWindow = "Opening a new window";
        String actualOpeningWindow = openingWindowElement.getText();
        Assert.assertEquals(expectedOpeningWindow,actualOpeningWindow);

        String firstPageWHD = driver.getWindowHandle();

        //  Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);


        //  Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        Thread.sleep(3000);
        // Burada yeni window acildi, artik 2 window var
        Set<String> whvalues = driver.getWindowHandles();
        String secondWindowWHD = "";
        for (String eachWhd: whvalues
             ) {
            if (!eachWhd.equals(firstPageWHD)){
                secondWindowWHD = eachWhd;
            }
        }

        //  Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu
        //  dogrulayin.
        driver.switchTo().window(secondWindowWHD);
        Thread.sleep(3000);
         expectedTitle = "New Window";
         actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);


        //  Sayfadaki textin “New Window” olduğunu doğrulayın.


        WebElement secondPageText = driver.findElement(By.tagName("h3"));

        String expectedSecondPageText = "New Window";
        String actualSecondPageText =  secondPageText.getText();

        Assert.assertEquals(expectedSecondPageText,actualSecondPageText);

        //  Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”
        //  olduğunu doğrulayın.

        driver.switchTo().window(firstPageWHD);

        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }
}
