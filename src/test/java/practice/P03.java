package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {

     /*    Exercise-1:

        BeforeClass ile driver'i oluşturun ve class icinde static yapin
        Maximize edin ve 10 sn bekletin
        http://www.qooqle.com adresine gidin
        1-arama kutusuna "12 Angry Men” yaz ip, cikan sonuc şayisini yazdinin
        2-arama kutusuna "Vizontele” yaz ip, cikan sonuc şayisini yazdirin
        3-arama kutusuna "Saving Private Ryan” yaz4p, cikan sonuc şayisini yazdirin
        AfterClass ile kapatin.

     */
     static WebDriver driver;
    WebElement searchbox;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//div[text()='Alle akzeptieren']")).click(); // Cookie den kurtulduk

    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }
    @Before
    public void before() {
        searchbox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
    }
    @After
    public void after() {
        WebElement result = driver.findElement(By.id("result-stats"));
        System.out.println(result.getText());
    }


    @Test
    public void test01() {
       //  driver.findElement(By.xpath("//div[text()='Alle Akzeptieren']")).click(); // Cookie den kurtulduk
       searchbox.sendKeys("12 Angry Men");
       searchbox.submit();

    }

    @Test
    public void test02() {
        searchbox.clear();
        searchbox.sendKeys("Vizontele" + Keys.ENTER);


    }

    @Test
    public void test03() {
        searchbox.clear();
        searchbox.sendKeys("Saving Private Ryan" + Keys.ENTER);

    }
}
