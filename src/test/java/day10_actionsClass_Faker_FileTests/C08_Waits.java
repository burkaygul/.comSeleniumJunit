package day10_actionsClass_Faker_FileTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;
import java.time.Duration;

public class C08_Waits {

    @Test
    public void test01() throws InterruptedException {

        // implicitly wait'in rolunu gorebilmek icin
        // baslangic ayarlarini bu test methodunda yapalim

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

    }
    }
