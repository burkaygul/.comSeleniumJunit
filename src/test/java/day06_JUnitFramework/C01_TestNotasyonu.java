package day06_JUnitFramework;

import org.junit.Test;

public class C01_TestNotasyonu {

    /*
    Bu class icerisinde 3 test calistiralim
    1- google anasayfaya gidip, url'in google icerdigini test edin
    2- wisequarter anasayfaya gidip url'in wisequarter icerdigini edin
    3- amazon anasayfaya gidip, amazon logosunun gorundugunu test edin
    */

    /*
        JUnit'in bize sagladigi ilk ve belki de en onemli ozellik
        test method'larinin bagimsiz olarak calistirilmasini
        saglayan @Test notasyonudur


        JUnit ile class level'dan birden fazla test method'u calistirirsak
        hangi siralama ile calistiracagini ongoremeyiz ve yonetemeyiz
     */

    @Test
    public void googleTest(){
        System.out.println("google test");
    }

    @Test
    public  void wiseTest(){
        System.out.println("wise Test");
    }

    @Test
    public void amazonTest(
    ){
        System.out.println("amazon Test");
    }
}
