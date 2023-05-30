package org.automation.core.pages;

import org.automation.core.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static org.automation.core.base.TestBase.getDriver;
import static org.openqa.selenium.support.PageFactory.initElements;

public class LoginPage extends BasePage {

    @FindBy(xpath="//input[@id='loginEmail']")
    WebElement email;

    @FindBy(xpath="//input[@id='loginPassword']")
    WebElement password;

    @FindBy(css="button[type='submit']")
    WebElement loginWithEmail;

    public LoginPage(){

       initElements(new AjaxElementLocatorFactory(getDriver(), 2000), this);
    }



    public void openUrl(String url) {
        getDriver().get(url);
    }
    public String getTitle(){
        return getDriver().getTitle();
    }

    public String getCurrentUrl(){
        return getDriver().getCurrentUrl();
    }

    public void login(){
          inputText(email,"");
          inputText(password,"");
          loginWithEmail.click();
    }

}
