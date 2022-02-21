package Page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BexPlusHomePage extends AbstractPage
{
    private static final String HOMEPAGE_URL = "https://www.bexplus.com/ru/trade";
    private final Logger logger = LogManager.getRootLogger();
    @FindBy(xpath = "(//ul[@class='ch_user']/li)[3]")
    private WebElement loginBtn;

    @FindBy(id ="zylo_nickname")
    private WebElement myLoginBtnClick;

    @FindBy(id = "user_email")
    private WebElement emailCheck;

    @FindBy(xpath = "//*[@id='close_btn']")
    private WebElement closeBtn;

    @FindBy(id = "ch_simulate")
    private WebElement demoSite;


    private final By closeTrainBtn = By.xpath("//*[@id='close_btn']");
    public BexPlusHomePage(WebDriver driver) {
        super(driver);

    }


    public BexPlusHomePage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        //new WebDriverWait(driver,10)
              //  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='close_btn']")));
        return this;
    }

    public BexPlusLogin login() {
        loginBtn.click();
        return new BexPlusLogin(driver);
    }

    public String checkMailText() {

        WebElement linkLoggedInUser = new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(closeTrainBtn));
        closeBtn.click();

        waitForElementToBeClickable(driver,myLoginBtnClick);
        myLoginBtnClick.click();

        return "misha.malchik2000@gmail.com";
    }

    public BexPlusSimulatorPage goToDemoSite() {
        waitForElementToBeClickable(driver,closeBtn);
        closeBtn.click();
        demoSite.click();
        return new BexPlusSimulatorPage(driver);
    }



    //new WebDriverWait(driver,10)
        //     .until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//ul[@class='ch_user']/li)[3]")));
   // WebElement login = driver.findElement(By.xpath("(//ul[@class='ch_user']/li)[3]"));
    //login.click();




  //  WebElement closeTrain = driver.findElement(By.xpath("//*[@id='close_btn']"));
      //  closeTrain.click();
      //  new WebDriverWait(driver,10)
            //    .until(ExpectedConditions.presenceOfElementLocated(By.id("ch_simulate")));
   // WebElement demoSite = driver.findElement(By.id("ch_simulate"));
        //demoSite.click();
}
