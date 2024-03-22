import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedCondition.*;


public class seleniumTest {

    WebDriver driver = new ChromeDriver();


    @BeforeTest
    void setup(){
        System.setProperty("webdriver.chrome.driver", "D:\\IntelliJ\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    //xPath
    @Test
    void test1(){
        driver.get("https://www.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys("pixel 7");
        driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"x-refine__group_1__0\"]/ul/li[1]/div/a/div/span/input")).click();

    }

    //Navigate
    @Test
    void test2(){
        driver.navigate().to("https://www.google.com/webhp?hl=en&sa=X&ved=0ahUKEwiSrIa6m_uEAxV2RmwGHTerAGMQPAgJ");
        driver.navigate().back();
        //driver.quit();
    }

    //Alert handling
    @Test
    void test3() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.findElement(By.id("promtButton")).click();
        alert.sendKeys("Hello");
        Thread.sleep(4000);
        alert.dismiss();
    }

    //Title check
    @Test
    void test4(){
        String expectedTitle = "Wikipedia";
        driver.get("https://www.wikipedia.org/");
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    //Drag and drop
    @Test
    void test5() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droppable"));
        Actions action = new Actions(driver);
        Thread.sleep(3000);
        action.dragAndDrop(sourceElement, targetElement).build().perform();
        //action.clickAndHold(sourceElement).moveToElement(targetElement).release().build().perform();
        Thread.sleep(3000);
    }
}
