package newProje.tests;

import com.github.javafaker.Faker;
import newProje.pages.HomePage;
import newProje.utilities.ConfigReader;
import newProje.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

import static newProje.utilities.Driver.getDriver;

public class US_002 {
    HomePage homePage = new HomePage();

    @Test
    public void test01() throws InterruptedException {
        // Web sitesine git
        getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));

        // register linkine  tikla
//        WebElement register = getDriver().findElement(By.cssSelector(".register"));
        homePage.register.click();
        // username alanina kayitli olmayan bir veri gir
        Faker faker = new Faker();
        String Email = faker.internet().emailAddress();
        String username = faker.name().firstName();
        String password = faker.internet().password();

        homePage.userName.sendKeys(username);
homePage.userName.clear();
        // username alanina kayitli bir veri gir
homePage.userName.sendKeys("ays");
        // email adress alanina bir veri gir
homePage.email.sendKeys("ayseyttnc@gmail.com");
        //password alanina bir veri gir
        homePage.password.sendKeys("1234.rfdA");
        //I agree to the privacy policy kontrol kutusunu sec
        homePage.policy.click();
        //Sign Up butonuna tikla
        homePage.submit.click();
        //Anasayfa acilmadigini ve "An account is already registered with that username. Please choose another.
        //" uyarisi gorulmus oldugunu dogrula

        Thread.sleep(5000);
   String alertMessage=     homePage.alreadyRegisteredError.getText();

        Assert.assertEquals(alertMessage,"An account is already registered with your email address. Please log in.");
//        Assert.assertEquals(alertMessage,"AnaccountisAlreadyregisteredwiththatusername");

    }
}