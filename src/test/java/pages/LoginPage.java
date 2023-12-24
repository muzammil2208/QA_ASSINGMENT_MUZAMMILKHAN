package pages;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
    public AndroidDriver driver;
    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    public WebElement username;

    @AndroidFindBy(xpath="//android.widget.EditText[@content-desc=\"test-Password\"]")
    public WebElement passwordfield;

    @AndroidFindBy(accessibility = "test-LOGIN")
    public WebElement loginButton;

    public void enterValidUsername()
    {
        Assert.assertEquals(username.getText(),"Username");
        username.sendKeys("standard_user");
    }
    public void enterInValidusername()
    {
        Assert.assertEquals(username.getText(),"Username");
        username.sendKeys("standard_userss");
    }
    public void enterValidPassword()
    {
        Assert.assertEquals(passwordfield.getText(),"Password");
        passwordfield.sendKeys("secret_sauce");
    }
    public void enterInvalidPassword()
    {
        Assert.assertEquals(passwordfield.getText(),"Password");
        passwordfield.sendKeys("secretsauce");
    }

    public void clickLoginBtn()
    {
        Assert.assertEquals(loginButton.getText(),"");
        if(loginButton.isEnabled())
        {
            loginButton.click();
        }
        else
        {
            System.out.println("Login button is not enabled");
        }
    }

}
