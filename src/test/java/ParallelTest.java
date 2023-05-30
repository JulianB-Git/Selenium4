import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--remote-allow-origins=*");

        driver=new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get("https://testautomationu.applitools.com/");
        System.out.println("Second test started");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testAboutPage() {
        driver.findElement(By.xpath("//div[@class='links']//a[text() = 'About Ranks']")).click();

        WebElement header = driver.findElement(By.xpath("//h1[text() = 'About Ranks']"));

        Assert.assertEquals(header.getText(), "About Ranks");
    }

}
