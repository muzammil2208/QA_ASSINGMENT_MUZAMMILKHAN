package LoginTests;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import pages.LoginPage;
import pages.HomePage;

//import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
public class LoginTest {
    private LoginPage lg;
    private HomePage hg;
    private AndroidDriver driver;
    @BeforeTest
    public void setup()throws MalformedURLException, InterruptedException
    {
        DesiredCapabilities ds=new DesiredCapabilities();
        ds.setCapability("platformName","Android");
        ds.setCapability("platformVersion","13.0");
        ds.setCapability("deviceName","QA_ASSINGMENT_MUZAMMIL");
        ds.setCapability("automationName","UiAutomator2");
        ds.setCapability("app","C:\\Users\\Muzammil\\OneDrive\\Desktop\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        ds.setCapability("appPackage","com.swaglabsmobileapp");
        ds.setCapability("appActivity","com.swaglabsmobileapp.MainActivity");
        AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/"),ds);
        lg=new LoginPage(driver);
        hg=new HomePage(driver);
    }
    @Test
    public void TC_LoginValid()
    {
        lg.enterValidUsername();
        lg.enterValidPassword();
        lg.clickLoginBtn();
        hg.isCartVisibleafterLogin();
    }
    @Test
    public void TC_LoginInvalid()
    {
        lg.enterInValidusername();
        lg.enterInvalidPassword();
        lg.clickLoginBtn();
        lg.verifyErrorMessage();
    }

    @Test
    public void TC_retainInvalid()
    {
        lg.enterInValidusername();
        lg.enterInvalidPassword();
        lg.clickLoginBtn();
        lg.verifyErrorMessage();
        lg.verifyCredentialsAreRetained();

    }

    @Test
    public void TC_LoginButtonisDisabled()
    {
        lg.verifyLoginButtonisDisabled();
    }
    @Test
    public void TC_LoginButtonisEnabled()
    {
        lg.enterValidUsername();
        lg.enterValidPassword();
        lg.verifyLoginButtonisEnabled();
    }

    @Test
    public void TC_forgotPassword()
    {

        lg.clickForgotPassword();
    }



    @AfterTest
    public void tearDown()
    {
        if(driver!=null)
            driver.quit();
    }


}

