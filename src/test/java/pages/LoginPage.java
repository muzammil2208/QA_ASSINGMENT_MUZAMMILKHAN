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
    public static String invalidUsername;

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

    @AndroidFindBy(xpath="//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]")
    public WebElement  errorScreen;

    @AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"Forget-Password\"]")
    public WebElement forgotPassword;

    public void enterValidUsername()
    {
        Assert.assertEquals(username.getText(),"Username");
        username.sendKeys("standard_user");
    }
    public void enterInValidusername()
    {
        Assert.assertEquals(username.getText(),"Username");
        username.sendKeys("standard_users");
        invalidUsername="standard_users";
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
        Assert.assertTrue(loginButton.isEnabled());
        loginButton.click();

    }
    public void verifyErrorMessage()
    {
        Assert.assertEquals(errorScreen.getText(),"Username and password do not match any user in this service.","Error Message not equal");

    }
    public void verifyLoginButtonisDisabled()
    {
        if(loginButton.isEnabled())
        {
            Assert.fail("Login button is enabled even after not entering password and username");
        }
        else
            System.out.println("Login button is disabled");

    }
    public void verifyLoginButtonisEnabled()
    {
        if(!loginButton.isEnabled())
        {
            Assert.fail("Login button is not enabled");
        }
        else
            System.out.println("Login button is is Enabled");
    }

    public void clickForgotPassword()
    {
        Assert.assertTrue(forgotPassword.isDisplayed(),"forgot password link not present");
        forgotPassword.click();
    }

    public void verifyCredentialsAreRetained()
    {
        String userName=username.getText();
        String password=passwordfield.getText();
        Assert.assertEquals(userName,invalidUsername,"not able to retain username");
        if(password.isEmpty()) {
            Assert.fail("not able to retain password field");
        }

    }



}
