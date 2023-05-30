package org.automation.core.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.automation.core.base.TestBase.getDriver;

public class BasePage {


    private WebDriverWait wait;

    public BasePage() {

    }

    protected void waitForPageLoad() {
        ExpectedCondition<Boolean> pageLoadCondition;
        pageLoadCondition = driver -> {
            assert driver != null;
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        };
        wait = new WebDriverWait(getDriver(), Duration.ofMillis(3000));
        wait.until(pageLoadCondition);
    }






    protected void click(WebElement webElement) {
        click(webElement, false);
    }

    private void click(WebElement webElement, boolean scroll) {
        if (scroll) scrollDown();
        wait = new WebDriverWait(getDriver(), Duration.ofMillis(3000));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webElement.click();
    }

    protected void waitUntilElementVisible(WebElement webElement) {
        System.out.println("Thread wait 1 " + Thread.currentThread().getId());
        System.out.println("HashcodeebDriver instance wait 1 = " +
                getDriver().hashCode());
        wait = new WebDriverWait(getDriver(), Duration.ofMillis(3000));
        System.out.println("Thread wait 2 " + Thread.currentThread().getId());
        System.out.println("HashcodeebDriver instance wait 2 = " +
                getDriver().hashCode());
        wait.until(ExpectedConditions.visibilityOf(webElement));
        System.out.println("Thread wait 3 " + Thread.currentThread().getId());
        System.out.println("HashcodeebDriver instance wait 3 = " +
                getDriver().hashCode());
    }



    protected void inputText(WebElement webElement, String text) {
        waitUntilElementVisible(webElement);
        webElement.sendKeys(text);
    }

    private boolean isElementPresent(WebElement webElement) {
        try {
            waitUntilElementVisible(webElement);
            webElement.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected String getInnerText(WebElement webElement) {
        return isElementPresent(webElement) ? webElement.getText() : null;
    }

    private void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0, 1000)");
    }

}
