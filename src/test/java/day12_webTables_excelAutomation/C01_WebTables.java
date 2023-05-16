package day12_webTables_excelAutomation;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.util.List;

public class C01_WebTables extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");
        //2.Sayfanin en altina inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        //3.Web table tum body’sini yazdirin
        Thread.sleep(3000);
        WebElement allBodyElement = driver.findElement(By.tagName("tbody"));
        System.out.println(allBodyElement.getText());
        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement> allRowsNr = driver.findElements(By.xpath("//tbody/tr"));
        int expectedRowsNr = 9;
        int actualRowsNr = allRowsNr.size();
        Assert.assertEquals(expectedRowsNr,actualRowsNr);
        System.out.println("==========================");
        //5.Tum satirlari yazdirin
        for (WebElement eachElement:allRowsNr) {
            System.out.println(eachElement.getText());
            System.out.println("==========================");
        }
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> firstColumnData = driver.findElements(By.xpath("//tbody/tr[1]/td"));
        int expectedFirstColumnDataNr = 13;
        int actualFirstColumnDataNr = firstColumnData.size();

        Assert.assertEquals(expectedFirstColumnDataNr,actualFirstColumnDataNr);

        //7. 5.sutunu yazdirin
        List<WebElement> fifthColumn = driver.findElements(By.xpath("//tbody/tr/td[5]"));
            System.out.println("=================");
        for (WebElement eachWebElement: fifthColumn) {
            System.out.println(eachWebElement.getText());
            System.out.println("=================");
        }
        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi
        //döndüren bir method olusturun
        System.out.println(dataGetir(3,5));
    }

    private String dataGetir(int rowNr, int columnNr) {

        //tbody/tr[3]/td[5]
        String dinamikXpath = "//tbody/tr["+rowNr+"]/td["+columnNr+"]";
        WebElement istenenDataElement = driver.findElement(By.xpath(dinamikXpath));
        return istenenDataElement.getText();
    }
}
