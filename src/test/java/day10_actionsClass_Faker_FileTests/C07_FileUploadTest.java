package day10_actionsClass_Faker_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C07_FileUploadTest extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        /*
            Driver ile gittigimiz bir web sayfasinda
            bilgisayarimizdaki bir dosyayi upload etmek istersek

            bilgisayarimizdaki klasorlere erismemiz gerekir
            Selenium webdriver bilgisayardaki dosyalara erisemez

            bunun yerine 3 adimla su islemleri yapariz
            1- choose file butonunu locate edelim
            2- bilgisayarimizdan yuklemek istedigimiz dosyanin dosya yolunu olusturalim
            (mumkunse dinamik dosya yolu olsun)
            3- chooseButonu.sendKeys(dosyaYolu) ile dosya yolunu sisteme tanitalim
         */

        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //3. chooseFile butonunu kullanarak projemizdeki deneme.text i secelim
        WebElement chooseButton = driver.findElement(By.id("file-upload"));

        String herkesinPcFarkliKisim = System.getProperty("user.dir");
        System.out.println(herkesinPcFarkliKisim);
        String herkesinPcAyniKisim = "/src/test/java/day10_actionsClass_Faker_FileTests/deneme.txt";
        String dateiPfad = herkesinPcFarkliKisim + herkesinPcAyniKisim;
        chooseButton.sendKeys(dateiPfad);

        //4. Upload butonuna basalim.

        Thread.sleep(5000);

        driver.findElement(By.id("file-submit")).click();
        //5. “File Uploaded!” textinin goruntulendigini test edelim.

        WebElement fileUploadedElement = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedElement.isDisplayed());

    }
}
