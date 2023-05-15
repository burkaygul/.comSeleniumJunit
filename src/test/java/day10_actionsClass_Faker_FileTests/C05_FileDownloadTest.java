package day10_actionsClass_Faker_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileDownloadTest extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //USA.png
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
         driver.get("https://the-internet.herokuapp.com/download");
        //3. USA.png dosyasını indirelim
        WebElement USAElement = driver.findElement(By.xpath("//a[text()='USA.png']"));
        USAElement.click();
        Thread.sleep(4000);
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dateiPfad = "C:\\Users\\burka\\Downloads\\USA.png";

        Assert.assertTrue(Files.exists(Paths.get(dateiPfad)));

        // herkesin bilgisayarinda farkli bir dosya hiyerarsisi oldugundan
        // herkesin dosya yolu birbirinden farkli olur
        // dosya yolunu dinamik hale getirmek icin Java'dan yardim alacagiz

        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));

    }
}
