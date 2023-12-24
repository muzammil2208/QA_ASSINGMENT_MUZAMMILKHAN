import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import pages.LoginPage;

//import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
public class LoginTest {
    static AndroidDriver driver;
    static LoginPage lg;
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
    }
    @Test
    public void LoginValid()
    {
        lg.enterValidUsername();
        lg.enterValidPassword();
        lg.clickLoginBtn();
    }
    @Test
    public void LoginInvalid()
    {
        lg.enterInValidusername();
        lg.enterInvalidPassword();
        lg.clickLoginBtn();
    }


}

