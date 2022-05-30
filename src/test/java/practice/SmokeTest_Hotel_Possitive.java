package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class SmokeTest_Hotel_Possitive {
    @Test
    public void test01() {
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));

        hotelMyCampPage.logInButonuAnasayfa.click();
        hotelMyCampPage.userNameBox.sendKeys(ConfigReader.getProperty("correctUsername"));
        hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("correctPassword"));
        hotelMyCampPage.logInButonuKullanici.click();

        Assert.assertTrue(hotelMyCampPage.listOfusersText.isDisplayed());

        Driver.closeDriver();


    }
}
