package Page;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.Logger;


public class BexPlusLogin extends AbstractPage
{
    private final String PAGE_URL = "https://www.bexplus.com/ru/login";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//*[@id='login_mail']")
    private WebElement inputLogin;

    @FindBy(xpath = "//*[@id='login_pwd']")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@id='login_btn_sbt']")
    private WebElement buttonSubmit;

    public BexPlusLogin(WebDriver driver) {
        super(driver);

    }

    @Override
    public BexPlusLogin openPage()
    {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public BexPlusHomePage login(User user)
    {

        inputLogin.sendKeys(user.getEmail());
        inputPassword.sendKeys(user.getPassword());
        buttonSubmit.click();
        logger.info("Trying something new");
        return new BexPlusHomePage(driver);

    }
    //new WebDriverWait(driver,10)
    //            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='login_mail']")));
    //WebElement email = driver.findElement(By.xpath("//*[@id='login_mail']"));
      //  email.sendKeys("misha.malchik2000@gmail.com");
    //WebElement password = driver.findElement(By.xpath("//*[@id='login_pwd']"));
        //password.sendKeys("f8g7e6b1f7q");
   // WebElement confirmLogin = driver.findElement(By.xpath("//*[@id='login_btn_sbt']"));
       // confirmLogin.click();
}
