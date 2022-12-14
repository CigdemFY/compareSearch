package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class bingSearch extends driver.driver {

    @FindBy(css = "svg#bLogo")
    WebElement bingLogo;

    @FindBy(id ="sb_form_q")
    WebElement searchBar;

    @FindBy(css = "label#search_icon svg")
    WebElement searchButton;

    @FindBy(css="ol#b_results li.b_algo h2")
    List<WebElement> searchResults_titles;

    @FindBy(css="ol#b_results li.b_algo cite")
    List<WebElement> searchResults_urls;

    public bingSearch() {
        PageFactory.initElements(webDriver, this);
    }

    public void goToBing() {
        goTo("https://www.bing.com");
        webDriverWait.until(ExpectedConditions.visibilityOf(bingLogo));
    }

    public void searchWord(String keyword) {
        sendKeysTo(searchBar, keyword);
    }

    public void clickSearch() {
        clickElement(searchButton);
    }

    public List<String> getTitlesList(){
        List<String> titles= new ArrayList<String>();
        for (WebElement element:searchResults_titles) {
            titles.add(element.getText());
            //System.out.println(titles);
        }
        return titles;
    }

    public List<String> getUrlsList(){
        List<String> urls= new ArrayList<String>();
        for (WebElement element:searchResults_urls) {
            urls.add(element.getText());
            //System.out.println(urls);
        }
        return urls;
    }

    public HashMap<String,String> parseList() {
        HashMap<String, String> bingResultList = new HashMap<String, String>();
        for(int i=0;i<getTitlesList().size();i++){
            bingResultList.put(getTitlesList().get(i), getUrlsList().get(i));
            //System.out.println(bingResultList);
        }
        System.out.println(bingResultList);
        return bingResultList;
    }
}
