package day09_stitchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_Actions extends TestBase {

    @Test
    public void test01(){
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //mouse’u bu menunun ustune getirin
        WebElement acoountListsElement = driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(acoountListsElement).perform();
        //3- “Create a list” butonuna basin
        WebElement createListElement = driver.findElement(By.xpath("//*[text()='Neue Liste anlegen ']"));
        createListElement.click();
        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin

        WebElement meineListenElement = driver.findElement(By.xpath("//*[@role='heading']"));

        String expectedText = "Meine Listen";
        String actualText = meineListenElement.getText();

        Assert.assertEquals(expectedText,actualText);
    }
}
