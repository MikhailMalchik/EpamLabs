package Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BexPlusSimulatorPage extends AbstractPage
{
    private final String BASE_URL = "https://www.bexplus.com/ru//trade/simulate";

    @FindBy(xpath = "//*[@value='Покупка']")
    private WebElement buyBtn;

    @FindBy(xpath = "//*[@id='market_vol']")
    private WebElement numbBuyCrypto;

    @FindBy(xpath = "//*[@id='tc_button']")
    private WebElement submitOfBuyingCrypto;

    @FindBy(id= "volume")
    private WebElement numbOfBoughtCrypto;

    @FindBy(xpath = "//*[@id='pos_1564417']/td[12]")
    private WebElement closePosition;

    @FindBy(id = "HCloseBtn")
    private WebElement closeConfirmationOfClosingPositionPage;

    @FindBy(xpath = "//*[@id='market']/div[3]/div/div/span[1]")
    private WebElement setMoreThenIHave;
    @FindBy(id = "confirm")
    private WebElement confirmationOfClosingPosition;
    @FindBy(xpath = "//*[@id='tab_ETHUSDT']")
    private WebElement etheriumBuy;



    public BexPlusSimulatorPage(WebDriver driver)
    {
        super(driver);

    }

    public BexPlusSimulatorPage buyCrypto(String numberCrypto) throws InterruptedException {
        WebElement linkLoggedIn = new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='market_vol']")));
        

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("document.getElementById('market_vol').value = 1");

        //numbBuyCrypto.sendKeys("33");
        Thread.sleep(10000);
        buyBtn.click();
        Thread.sleep(5000);
        WebElement linkLoggedInUser = new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("tc_button")));
        submitOfBuyingCrypto.click();

        return this;
    }
    @Override
    public BexPlusSimulatorPage openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public int checkNumbBuyCrypto()
    {
        return Integer.parseInt(numbOfBoughtCrypto.getText());
    }

    public boolean checkAvailabilityOfClosingPosition()
    {


        confirmationOfClosingPosition.click();
        if(setMoreThenIHave.isEnabled())
            return false;
        else
            return true;

    }
    public BexPlusSimulatorPage pressCloseButtonPosition()
    {
        closePosition.click();
        return this;
    }

    public BexPlusSimulatorPage settingMoreThenIHave()
    {
        setMoreThenIHave.click();
        return this;
    }
    public BexPlusSimulatorPage confirmationOfClosingPosition()
    {
        submitOfBuyingCrypto.click();
        return this;
    }

   // new WebDriverWait(driver,10)
      //          .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@value='Покупка']")));
   // WebElement numbBuyCrypto = driver.findElement(By.id("market_vol"));
    //    numbBuyCrypto.sendKeys("3");
   // WebElement buyBtn = driver.findElement(By.xpath("//*[@value='Покупка']"));
   //     buyBtn.click();
}
