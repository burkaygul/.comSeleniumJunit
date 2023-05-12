package day09_stitchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.time.LocalTime;
import java.util.Set;

public class C03_ActionsClass extends TestBase {

    @Test
    public void test01(){
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapin

        Actions actions = new Actions(driver);
        WebElement ciziliAlanElement = driver.findElement(By.id("hot-spot"));
        actions.contextClick(ciziliAlanElement).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedText = "You selected a context menu";
        String actualAlertText = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedText,actualAlertText);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        //  linki tikladigimizda yeni window acildigindan
        // tiklamadan once ilk window'un WHD almamiz gerekir

        String ilkWindowWHD = driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();

        // ikinci sayfa biz newWindow() demeden acildigindan
        // ikinciWindow'un WHD ini Java kullanarak bulmaliyiz

        Set<String> tümHandles = driver.getWindowHandles();
        String ikinciWindowWHD = "";

        for (String eachWHD : tümHandles
             ) {
            if (!eachWHD.contains(ilkWindowWHD)){
                ikinciWindowWHD = eachWHD;
            }
        }
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        driver.switchTo().window(ikinciWindowWHD);

        WebElement h1Tag = driver.findElement(By.tagName("h1"));

        expectedText = "Elemental Selenium";
        String actualText = h1Tag.getText();

        Assert.assertEquals(expectedText,actualText);

    }
}
