import Pages.bingSearch;
import Pages.googleSearch;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.ListResourceBundle;

public class Tests {

    bingSearch bingSearch_=new bingSearch();
    googleSearch googleSearch_= new googleSearch();


    @Test
    public void compareSearchResults(){
        Assert.assertNotEquals("Result lists do not match",getBingResults(),(getGoogleResults()));
    }


    public HashMap<String,String> getGoogleResults(){
        googleSearch_.goToGoogle();
        googleSearch_.searchWord("test");
        googleSearch_.clickSearch();
        HashMap<String,String> googleList=googleSearch_.parseList();
        return googleList;
    }


    public HashMap<String, String> getBingResults(){
        bingSearch_.goToBing();
        bingSearch_.searchWord("test");
        bingSearch_.clickSearch();
        HashMap<String,String> bingList=bingSearch_.parseList();
        return bingList;
    }

}
