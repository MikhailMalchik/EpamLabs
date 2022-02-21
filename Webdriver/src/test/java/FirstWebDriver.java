import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class FirstWebDriver {
    private WebDriver driver;
    @BeforeMethod
    public void browserSetup()
    {
        driver = new ChromeDriver();
    }

    @Test
    public void loginTest() throws InterruptedException {


        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.get("https://www.bexplus.com/ru//trade/simulate");

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//ul[@class='ch_user']/li)[3]")));
        WebElement login = driver.findElement(By.xpath("(//ul[@class='ch_user']/li)[3]"));
        login.click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='login_mail']")));
        WebElement email = driver.findElement(By.xpath("//*[@id='login_mail']"));
        email.sendKeys("misha.malchik2000@gmail.com");
        WebElement password = driver.findElement(By.xpath("//*[@id='login_pwd']"));
        password.sendKeys("f8g7e6b1f7q");
        WebElement confirmLogin = driver.findElement(By.xpath("//*[@id='login_btn_sbt']"));
        confirmLogin.click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='close_btn']")));
        WebElement closeTrain = driver.findElement(By.xpath("//*[@id='close_btn']"));
        closeTrain.click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("ch_simulate")));
        WebElement demoSite = driver.findElement(By.id("ch_simulate"));
        demoSite.click();

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@value='Покупка']")));
        WebElement numbBuyCrypto = driver.findElement(By.id("market_vol"));
        numbBuyCrypto.sendKeys("3");
        WebElement buyBtn = driver.findElement(By.xpath("//*[@value='Покупка']"));
        buyBtn.click();
        driver.getCurrentUrl();

        Thread.sleep(2000);



    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown()
    {
        driver.quit();
        driver = null;
    }
}
