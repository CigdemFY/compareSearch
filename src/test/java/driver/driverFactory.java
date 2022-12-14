package driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.Arrays;

public class driverFactory {

    public static WebDriver getWebDriver(){
        WebDriver webDriver;
        String browser = null;
        browser =(browser == null) ? "CHROME" : browser;

        switch (browser){
            case "FIREFOX" :
                webDriver = new FirefoxDriver();
                return webDriver;

            case "CHROME" :
            default:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.setHeadless(false);
                options.addArguments("--disable-gpu");
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-blink-features");
                options.addArguments("--disable-blink-features=AutomationControlled");
                options.addArguments("--no-sandbox");
                options.addArguments("disable-infobars");
                options.addArguments("disable-plugins");
                options.addArguments("disable-popup-blocking");
                options.addArguments("ignore-certificate-errors");
                options.addArguments("disable-translate");
                options.addArguments("disable-extensions");
                options.addArguments("--start-maximized");
                options.addArguments("--incognito");
                options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));

                webDriver = new ChromeDriver(options);
                return webDriver;

            case "IE" :
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                ieOptions.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
                ieOptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                webDriver = new InternetExplorerDriver(ieOptions);
                return webDriver;
        }
    }
}
