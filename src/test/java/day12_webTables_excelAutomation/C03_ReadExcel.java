package day12_webTables_excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void test01() throws IOException {

        // bilgisayarimizda olan bir dosyaya erisebilmek icin FileInputStream class'indan obje olusturalim
        String dosyaYolu = System.getProperty("user.dir") + "/src/test/java/day12_webTables_excelAutomation/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        // projemize ekledigimiz POI kutaphenelerini kullanarak
        // class'imizin icinde istenen excel'in bir kopyasini olusturalim

        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(1); // index from 0
        Cell cell = row.getCell(3); // index from 0

        System.out.println(cell);

        // 5.index'deki satirin, 1.index'indeki datanin "Luanda" oldugunu test edin

        row = sheet.getRow(5);
        cell = row.getCell(1);

        String expectedInhalt = "Luanda";

        // cell objesinin data turu Cell
        // Java'da farkli data turlerindeki variable'lari equals ile KULLANAMAYIZ
        Assert.assertEquals(expectedInhalt,cell.toString());

        // 12.index'deki satirin, 2.index'indeki datanin "Baku" oldugunu test edin
        String actualData = sheet.getRow(11).getCell(1).toString();

        String expectedData = "Baku";

        Assert.assertEquals(expectedData,actualData);





    }
}
