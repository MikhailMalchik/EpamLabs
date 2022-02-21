package Test;

import Page.BexPlusHomePage;
import Page.BexPlusLogin;
import Page.BexPlusSimulatorPage;
import com.sun.source.tree.AssertTree;
import model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginAndBuyCryptoTest extends CommonCondititon {

     private BexPlusSimulatorPage bexPlusSimulatorPage;

    @Test(description = "login",priority = 1)
    public void loginTest()  {
        User testUser = UserCreator.withCredentialsFromProperty();
        bexPlusSimulatorPage = new BexPlusHomePage(driver)
                .openPage()
                .login()
                .login(testUser)
                .goToDemoSite();

        String expectedEmail = "misha.malchik2000@gmail.com";


        Assert.assertEquals(expectedEmail, testUser.getEmail());
    }

    @Test(description = "BuySomeCrypto", priority = 2)
    public void buyCryptoTest() throws InterruptedException {
        String testNumbCrypto1 = "3";
        String testNumbCrypto2 = "2";

        int expectedNumbCrypto = bexPlusSimulatorPage
                .buyCrypto(testNumbCrypto1)
                .buyCrypto(testNumbCrypto2)
                .checkNumbBuyCrypto();

        Assert.assertEquals(expectedNumbCrypto,Integer.parseInt(testNumbCrypto1)+Integer.parseInt(testNumbCrypto2));

    }
    @Test(description = "ClosePositionThenISetMore", priority = 3)
    public void closeMoreThenBuyPositionTest()
    {
         boolean CheckAvailabilityOfClosingPosition = bexPlusSimulatorPage

                 .pressCloseButtonPosition()
                 .settingMoreThenIHave()

                 .checkAvailabilityOfClosingPosition();
        Assert.assertTrue(CheckAvailabilityOfClosingPosition);
    }
    @Test(description = "ClosePosition", priority = 4)
    public void closeBuyPositionTest()
    {
        boolean CheckAvailabilityOfClosingPosition = bexPlusSimulatorPage
                .pressCloseButtonPosition()
                .confirmationOfClosingPosition()
                .checkAvailabilityOfClosingPosition();
        Assert.assertTrue(CheckAvailabilityOfClosingPosition);
    }





}
