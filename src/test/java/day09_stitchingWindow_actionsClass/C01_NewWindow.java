package day09_stitchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01_NewWindow extends TestBase {

    // gerekli ayarlamalari yapip
    // amazon anasayfaya gidin
    // title'in amazon kelimesi icerdigini test edin
    // yeni bir tab acarak wisequarter anasayfaya gidin
    // url'in wisequarter icerdigini test edin

    /*
        Eger driver.swichtTo().newWindow() kullanilirsa
        driver otomatik olarak acilan yeni sayfaya gecer

        eger gorevimizde yeni window'a gittikten sonra
        window'lar arasi gecis islemi varsa
        uzerinde calistigimiz windows'larin
        windowHandleDegerlerini alip kaydetmekte fayda var
     */

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        String firstPageWHD = driver.getWindowHandle();
        String expectedTitle = "Amazon";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(3000);
        driver.navigate().to("https://www.wisequarter.com");
        String secondPageWHD = driver.getWindowHandle();
        String expectedUrl = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));

        // tekrar amazon'un acik oldugu sayfaya gecin
        // ve url'in amazon icerdigini test edin

        driver.switchTo().window(firstPageWHD);
    }
}
