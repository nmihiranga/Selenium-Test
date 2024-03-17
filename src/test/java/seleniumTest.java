import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class seleniumTest {

    WebDriver driver = new ChromeDriver();

    @BeforeTest
    void setup(){
        System.setProperty("webdriver.chrome.driver", "D:\\IntelliJ\\chromedriver.exe");

        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
    }

    @Test
    void test1(){
        driver.findElement(By.id("gh-ac")).sendKeys("pixel 7");
        driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"x-refine__group_1__0\"]/ul/li[1]/div/a/div/span/input")).click();

    }
    @Test
    void test2(){
        driver.navigate().to("https://www.google.com/webhp?hl=en&sa=X&ved=0ahUKEwiSrIa6m_uEAxV2RmwGHTerAGMQPAgJ");
        driver.navigate().back();
        driver.quit();
    }
}
