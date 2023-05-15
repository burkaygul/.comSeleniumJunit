package day10_actionsClass_Faker_FileTests;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExistsTest {

    @Test
    public void test01(){

        // com.Team113Junit projesi icerisinde
        // deneme.txt dosyasinin varoldugunu test edin

        String dosyaYolu = "src/test/java/day10_actionsClass_Faker_FileTests/deneme.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
