package day12_webTables_excelAutomation;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    @Test
    public void test01(){
        // 1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //2. Headers da bulunan basliklari yazdirin
        List<WebElement> headersElementList = driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        for (WebElement eachHeadersElement: headersElementList) {
            System.out.println(eachHeadersElement.getText());
        }
        System.out.println("=================");
        //3. 3.sutunun basligini yazdirin
        System.out.println("3. sutun basligi : " +headersElementList.get(3).getText());
        //4. Tablodaki tum datalari yazdirin
        int bosOlmayandataSayisi = 0;
        List<WebElement> allDataElement = driver.findElements(By.xpath("(//div[@role='gridcell'])"));
        for (WebElement eachData: allDataElement             ) {
            if (!eachData.getText().isBlank()){
                System.out.println(eachData.getText());
                bosOlmayandataSayisi++;
            }
        }
        //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        System.out.println("Tabloda bos olmayan hucre sayisi : " + bosOlmayandataSayisi);
        //6. Tablodaki satir sayisini yazdirin
        List<WebElement> tableRowsNr = driver.findElements(By.xpath("(//div[@role='rowgroup'])"));
        System.out.println("Table Rows Number : " + tableRowsNr.size());
        //7. Tablodaki sutun sayisini yazdirin
        List<WebElement> columnNr = driver.findElements(By.xpath("(//div[@role='row'])[2]/div"));
        System.out.println("Column Number: " + columnNr.size());
        //8. Tablodaki 3.kolonu yazdirin
        List<WebElement> thirdColumn = driver.findElements(By.xpath("(//div[@role='row'])/div[3]"));
        System.out.println("==========3.Sutun=======");
        for (WebElement eachThirdColumnElement: thirdColumn
             ) {
            if (!eachThirdColumnElement.getText().isBlank()){
                System.out.println(eachThirdColumnElement.getText());
                bosOlmayandataSayisi++;
            }
        }
        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin

        for (int i = 2; i < tableRowsNr.size() ; i++) {
            WebElement isim = driver.findElement(By.xpath(getDinamikXpath(i,1)));
            if (isim.getText().equalsIgnoreCase("Kierra")){
                WebElement salary = driver.findElement(By.xpath(getDinamikXpath(i,5)));
                System.out.println("kierra'nin maasi : " + salary.getText());
            }
        }

        //10. Page sayfasinda bir method olusturun,
        // Test sayfasindan satir ve sutun
        //sayisini girdigimde bana datayi yazdirsin

        dataYazdir( 3,  3);
    }

    private void dataYazdir(int satirNo, int sutunNo) {
        String dinamikXpath ="(//div[@role='row'])["+satirNo+"]/div["+sutunNo+"]";
        WebElement istenenelement = driver.findElement(By.xpath(dinamikXpath));
        System.out.println("Istenen hucredeki data :" + istenenelement.getText());
    }

    public String getDinamikXpath(int satirNo, int sutunNo){

        return "(//div[@role='row'])["+satirNo+"]/div["+sutunNo+"]";
    }
}
