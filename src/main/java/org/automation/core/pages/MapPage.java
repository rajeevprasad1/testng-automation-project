package org.automation.core.pages;

import org.automation.core.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static org.automation.core.base.TestBase.getDriver;
import static org.openqa.selenium.support.PageFactory.initElements;

public class MapPage extends BasePage {

    @FindBy(css="a[class='mapboxgl-ctrl-logo']")
    WebElement mapLogo;


    public MapPage(){

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



    public void waitForMapLogo(){
        waitUntilElementVisible(mapLogo);
    }

}
