import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class RelativeLocators {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--remote-allow-origins=*");

        driver=new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get("https://testautomationu.applitools.com/");
        System.out.println("Title: "+ driver.getTitle());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testHeader() {
        String title = driver.getTitle();

        Assert.assertTrue(title.equals("Test Automation University | Applitools"));
    }
}
