package newProje.tests;

import com.github.javafaker.Faker;
import newProje.pages.HomePage;
import newProje.utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static newProje.utilities.Driver.getDriver;

public class US_002_NotRegisterAgain {
    HomePage homePage = new HomePage();
    Faker faker = new Faker();
    @Test
    public void testUS02TC01() throws InterruptedException {
        // Web sitesine git
        getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        // register linkine  tikla
        homePage.register.click();
        // username alanina kayitli bir veri gir
        homePage.userName.sendKeys("gecerliUsername");
        // email adress alanina bir veri gir
        String Email = faker.internet().emailAddress();
        homePage.email.sendKeys(Email);
        //password alanina bir veri gir
        String password = faker.internet().password();
        homePage.password.sendKeys(password);
        //I agree to the privacy policy kontrol kutusunu sec
        homePage.policy.click();
        //Sign Up butonuna tikla
        homePage.submit.click();
        //Anasayfa acilmadigini ve "An account is already registered with that username. Please choose another.
        //" uyarisi gorulmus oldugunu dogrula
        String alertMessage = homePage.alreadyRegisteredError.getText();
        Assert.assertEquals(alertMessage, "An account is already registered with your email address. Please log in.");

    }
    @Test
    public void US02TC02() {
        // Web sitesine git
        getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        // register linkine  tikla
        homePage.register.click();
        //username alanina bir veri gir
        String username = faker.name().firstName();
        homePage.userName.sendKeys(username);
        //your email adres alanina kayitli bir veri gir
        homePage.email.sendKeys(ConfigReader.getProperty("gecerliEmail"));
        //password alanina  bir veri gir
        String password = faker.internet().password();
        homePage.password.sendKeys(password);
        //"I agree to the privacy policy kontrol kutusunu sec
        homePage.policy.click();
        //SIGN UP butonuna tikla
        homePage.submit.click();
        //Anasayfa acilmadigini ve "An account is already registered with that username. Please choose another.
        //" uyarisi gorulmus oldugunu dogrula
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String alertMessage = homePage.alreadyRegisteredError.getText();
        Assert.assertEquals(alertMessage, "An account is already registered with your email address. Please log in.");
    }
    @Test
    public void US02TC03() {
        // Web sitesine git
        getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        // register linkine  tikla
        homePage.register.click();
        //username alani bos birakilmali
        homePage.userName.sendKeys("    ");
        //Your email adress alanina  bir veri gir
        String Email = faker.internet().emailAddress();
        homePage.email.sendKeys(Email);
        //Password alanina bir veri gir
        String password = faker.internet().password();
        homePage.password.sendKeys(password);
        //"I agree to the privacy policy kontrol kutusunu sec
        homePage.policy.click();
        //SIGN UP butonuna tikla
        homePage.submit.click();
        //Anasayfa acilmadigini ve "An account is already registered with that username. Please choose another.
        //" uyarisi gorulmus oldugunu dogrula
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String alertMessage = homePage.alreadyRegisteredError.getText();
        Assert.assertEquals(alertMessage, "Please enter a valid account username.");
    }

}