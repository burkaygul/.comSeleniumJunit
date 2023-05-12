package day09_stitchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_ActionsClass extends TestBase {

    @Test
    public void test01(){
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMeElement = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHereElement = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMeElement,dropHereElement).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        WebElement droppedYazi = driver.findElement(By.xpath("//*[text()='Dropped!']"));

        String expectedText = "Dropped!";
        String actualText = droppedYazi.getText();

        Assert.assertEquals(expectedText,actualText);

    }
}
