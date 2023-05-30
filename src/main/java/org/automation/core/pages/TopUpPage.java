package org.automation.core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static org.automation.core.base.TestBase.getDriver;
import static org.openqa.selenium.support.PageFactory.initElements;

public class TopUpPage extends BasePage {


    @FindBy(css="button[data-cy='pump-1']")
    WebElement pumpOne;

    @FindBy(css="div[data-cy='fuel-1']")
    WebElement fuelOne;

    @FindBy(css="div[data-cy='amount-2']")
    WebElement amountTwo;

    @FindBy(css="div[data-cy='amount-5']")
    WebElement amountFive;

    @FindBy(css="button[data-cy='payButton']")
    WebElement payConfirm;

    @FindBy(css="h3[data-cy='paymentCompleted']")
    WebElement payCompleted;

    @FindBy(css="select[id='selectAuthResult']")
    WebElement authenticationResult;

    @FindBy(css="input[id='acssubmit']")
    WebElement authenticationSubmit;


    public TopUpPage(){

       initElements(new AjaxElementLocatorFactory(getDriver(), 2000), this);
    }

    public String getCurrentUrl(){
        return getDriver().getCurrentUrl();
    }



    public void openUrl(String url) {
        getDriver().get(url);
    }
    public String getTitle(){
        return getDriver().getTitle();
    }



    public void clickPumpOne(){
          click(pumpOne);
    }

    public void clickFuelOne(){
        click(fuelOne);
    }

    public void clickAmountTwo(){
        click(amountTwo);
    }

    public void clickAmountFive(){
        click(amountFive);
    }

    public void clickPayConfirm(){
       click(payConfirm);
    }

    public void VerifyPayCompleted(){
        waitUntilElementVisible(payCompleted);
    }

    public void VerifyAuthenticationResult(){
        waitUntilElementVisible(authenticationResult);
    }


    public void clickAuthenticationSubmit(){
       click(authenticationSubmit);
    }

    public String getPayCompletedText(){
        return getInnerText(payCompleted);
    }

    public void waitForPageLoad(){
        super.waitForPageLoad();
    }





}
