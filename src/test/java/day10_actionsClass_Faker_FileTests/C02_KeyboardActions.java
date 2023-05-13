package day10_actionsClass_Faker_FileTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C02_KeyboardActions extends TestBase {

    @Test
    public void test01() {
        //1- https://www.facebook.com adresine gidelim cookies kabul edelim
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//*[text()='Alle Cookies erlauben']")).click();
        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement vornameElement = driver.findElement(By.xpath("//input[@name='firstname']"));

        Actions actions = new Actions(driver);
        actions.click(vornameElement)
                .keyDown(Keys.SHIFT)
                .sendKeys("b")
                .keyUp(Keys.SHIFT)
                .sendKeys("urkay")
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .keyDown(Keys.SHIFT)
                .sendKeys("g")
                .keyUp(Keys.SHIFT)
                .sendKeys("ül")
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .sendKeys("017682285995")
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .sendKeys("Burkay9-")
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .sendKeys("15")
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .sendKeys("Aug.")
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .sendKeys("1996")
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB).sendKeys(Keys.ENTER).perform();

    }
}
