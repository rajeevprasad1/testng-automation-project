package functional;

import org.automation.core.base.TestBase;
import org.automation.core.pages.LoginPage;
import org.automation.core.pages.MapPage;
import org.automation.core.pages.TopUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RydTopUpTests extends TestBase {

    //private WebDriver driver;

    LoginPage loginPage;
    MapPage mapPage;
    TopUpPage topUpPage;

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        //driver = getDriver();

    }


    @Test
    public void topUpWithout3DS() {
        loginPage = new LoginPage();
        loginPage.openUrl(prop.getProperty("loginUrl"));
        loginPage.login();
        mapPage = new MapPage();
        mapPage.waitForMapLogo();
        String url = mapPage.getCurrentUrl();
        String title = mapPage.getTitle();
        Assert.assertEquals("Ryd Pay Map",title);
        Assert.assertEquals(prop.getProperty("mapUrl"),url);
        topUpPage = new TopUpPage();
        topUpPage.openUrl(prop.getProperty("topUpUrl"));
        topUpPage.waitForPageLoad();
        topUpPage.clickPumpOne();
        topUpPage.clickFuelOne();
        topUpPage.clickAmountTwo();
        topUpPage.clickPayConfirm();
        topUpPage.VerifyPayCompleted();
        Assert.assertEquals("Payment successful",topUpPage.getPayCompletedText());
    }

    @Test
    public void topUpWith3DS() {

        loginPage = new LoginPage();
        loginPage.openUrl(prop.getProperty("loginUrl"));
        loginPage.login();
        mapPage = new MapPage();
        mapPage.waitForMapLogo();
        String url = mapPage.getCurrentUrl();
        String title = mapPage.getTitle();
        Assert.assertEquals("Ryd Pay Map",title);
        Assert.assertEquals(prop.getProperty("mapUrl"),url);
        topUpPage = new TopUpPage();
        topUpPage.openUrl(prop.getProperty("topUpUrl"));
        topUpPage.waitForPageLoad();
        topUpPage.clickPumpOne();
        topUpPage.clickFuelOne();
        topUpPage.clickAmountFive();
        topUpPage.clickPayConfirm();
        topUpPage.VerifyAuthenticationResult();
        String authenticationUrl = topUpPage.getCurrentUrl();
        Assert.assertEquals(prop.getProperty("authUrl"),authenticationUrl);
        topUpPage.clickAuthenticationSubmit();
        topUpPage.VerifyPayCompleted();
        Assert.assertEquals("Payment successful",topUpPage.getPayCompletedText());

    }




}
