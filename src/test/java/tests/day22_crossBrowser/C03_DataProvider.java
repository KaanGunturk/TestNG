package tests.day22_crossBrowser;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {



    @Test
    public void test01() {
        AmazonPage amazonPage=new AmazonPage();

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        String expectedWord="Nutella";
        String actualWord=amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualWord.contains(expectedWord));

        Driver.closeDriver();

    }
    @DataProvider
    public static Object[][] AranacakKelimeler() {

        Object[][] arananKelimeArray={{"Nutella"}, {"Java"} , {"cigdem"} , {"Netherlands"}};
        return arananKelimeArray;
    }

    @Test(dataProvider = "AranacakKelimeler")
    public void dataProvider(String arananKelime) {
        AmazonPage amazonPage=new AmazonPage();
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        amazonPage.aramaKutusu.sendKeys(arananKelime+ Keys.ENTER);

        String expectedWord=arananKelime;
        String actualWord=amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualWord.contains(expectedWord));

        Driver.closeDriver();

    }

}
