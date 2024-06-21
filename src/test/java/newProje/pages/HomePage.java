package newProje.pages;

import newProje.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".register")
 public    WebElement register;

    @FindBy(css = "#reg_username")
    public WebElement userName;

    @FindBy(css = "#reg_email")
    public WebElement email;
    @FindBy(css = "#reg_password")
    public WebElement password;

    @FindBy(css ="#register-policy")
    public WebElement  policy;

    @FindBy(xpath = "//div[@class='account']//span")
//    @FindBy(xpath = "//div[.='Sign Out']")
    public WebElement signOutButton;


    @FindBy (css = ".woocommerce-form-register__submit")
    public  WebElement submit;

    @FindBy(css = "#signup .submit-status")
//    @FindBy(xpath = "//p[@class='submit-status' and contains(text(),\"An account is already registered with your email address. ')]")
public  WebElement   alreadyRegisteredError;

}
