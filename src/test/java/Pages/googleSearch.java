package Pages;

import com.beust.ah.A;
import jdk.internal.org.objectweb.asm.tree.InsnList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.stream.IntStream;


public class googleSearch extends driver.driver {

    @FindBy(css="img[alt='Google']")
    WebElement googleLogo;

    @FindBy(css="input[name='q']")
    WebElement searchBar;

    @FindBy(css="div[jsname='VlcLAe'] input[name='btnK']")
    WebElement searchButton;

    @FindBy(css="div#rso div[data-ved][data-hveid] a h3")
    List<WebElement> searchResults_Titles;

    @FindBy(css="div#rso div[data-ved][data-hveid] a cite")
    List<WebElement> searchResults_urls;
    public googleSearch(){
        PageFactory.initElements(webDriver,this);
    }

    public void goToGoogle(){
        goTo("https://www.google.com");
        webDriverWait.until(ExpectedConditions.visibilityOf(googleLogo));
    }

    public void searchWord(String keyword){
        sendKeysTo(searchBar,keyword);
    }

    public void clickSearch(){
        clickElement(searchButton);
    }

    public List<String> getTitleList(){
        List<String> titles = new ArrayList<String>();
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(searchResults_Titles));
        for (WebElement element:searchResults_Titles) {
            titles.add(element.getText());

        }
        //System.out.println(titles);
        return  titles;
    }

    public List<String> getUrlList(){
        List<String> urls = new ArrayList<String>();
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(searchResults_urls));
        for (WebElement element:searchResults_urls) {
            urls.add(element.getText());

        }
        //System.out.println(urls);
        return urls;
    }
    public HashMap<String,String> parseList(){
       HashMap<String,String> googleResultList = new HashMap<String,String>();
        for (int i=0; i<getUrlList().size(); i++) {
            googleResultList.put(getUrlList().get(i),getTitleList().get(i));
        }
        System.out.println(googleResultList);
        System.out.println(googleResultList.size());
        return googleResultList;
    }

}

