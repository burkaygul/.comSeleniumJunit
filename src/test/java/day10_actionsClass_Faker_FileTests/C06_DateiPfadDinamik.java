package day10_actionsClass_Faker_FileTests;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_DateiPfadDinamik {

    @Test
    public void test01(){
        // herkesin bilgisayarinda farkli bir dosya hiyerarsisi oldugundan
        // herkesin dosya yolu birbirinden farkli olur
        // dosya yolunu dinamik hale getirmek icin Java'dan yardim alacagiz

        System.out.println(System.getProperty("user.dir"));
        // projenin dosya yolunu verir
        //C:\Users\burka\IdeaProjects\com.Team113Junit
        System.out.println(System.getProperty("user.home"));
        //C:\Users\burka

        /*
         biz downloads'a indirdigim dosyanin dosya yolunu 2'ye bolecegiz
            C:\Users\burka                       \Downloads\USA.png
            herkesin PC farkli                 herkeste ayni
            System.getProperty("user.home")      \Downloads\USA.png
         */

        String dosyaYoluDegisenKisim =System.getProperty("user.home");
        String dosyaYoluherkesteAyni = "\\Downloads\\USA.png";

        String dateiPfad = dosyaYoluDegisenKisim + dosyaYoluherkesteAyni;

        Assert.assertTrue(Files.exists(Paths.get(dateiPfad)));

        // ayni islemi projemizin altindaki deneme.txt icin yapsak

        dosyaYoluDegisenKisim = System.getProperty("user.dir");
        System.out.println(dosyaYoluDegisenKisim); // C:\Users\burka\IdeaProjects\com.Team113Junit
        dosyaYoluherkesteAyni = "/src/test/java/day10_actionsClass_Faker_FileTests/deneme.txt";

        dateiPfad = dosyaYoluDegisenKisim + dosyaYoluherkesteAyni;
        System.out.println(dateiPfad); // C:\Users\burka\IdeaProjects\com.Team113Junit/src/test/java/day10_actionsClass_Faker_FileTests/deneme.txt

        Assert.assertTrue(Files.exists(Paths.get(dateiPfad)));
    }
}
