package tests.day17_pom;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

import java.security.Key;

public class C02_PageClassKullanimi {

    @Test
    public void test01() {


        AmazonPage amazonPage=new AmazonPage();


        //amazona gidip nutella aratalim sonuc yazisinin nutella icerdigini test edelim

        Driver.getDriver().get("https://www.amazon.com");

        amazonPage.aramaKutusu.sendKeys("nutella" + Keys.ENTER);
        String actualSonuc=amazonPage.aramaSonucElementi.getText();
        String expectedSonuc="nutella";

        Driver.closeDriver();
    }
}
