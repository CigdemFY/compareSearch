package driver;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.sql.Driver;
import java.time.Duration;

public class driver extends driverFactory{


    public WebDriver webDriver= driverFactory.getWebDriver();
    public WebDriverWait webDriverWait = new WebDriverWait(webDriver,Duration.ofSeconds(30));
    public void sendKeysTo(WebElement webElement,String text){
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement)).sendKeys(text);
    }

    public void clickElement(WebElement webElement){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public void deleteCookies(){
        webDriver.manage().deleteAllCookies();
    }

    public boolean elementIsVisible(WebElement element){
        return webDriverWait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    public void goTo(String url ){
        webDriver.get(url);
    }

    public WebDriver getNewTab(){
        WebDriver newTab = webDriver.switchTo().newWindow(WindowType.TAB);
        return newTab;
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

}

