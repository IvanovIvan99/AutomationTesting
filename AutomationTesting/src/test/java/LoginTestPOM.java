import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import factory.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTestPOM {


    EdgeDriver webDriver;

    private boolean userReg = false;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(){

        WebDriverManager.edgedriver().setup();
        webDriver = new EdgeDriver();


        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(){
        if (webDriver != null) {
            webDriver.close();
        }
        if(userReg == true){

        }
    }

    @DataProvider(name="getUser")
    public Object[][] getUsers(){
        return new Object[][]{

                {"p0li0m","TGdd7EDby83jdAC", "5508"},

        };
    }

    @Test(dataProvider = "getUser")
    public void loginTest(String username, String password, String userId){

        HomePage homePage = new HomePage(webDriver);
        Header header = new Header(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        ProfilePage profilePage = new ProfilePage(webDriver);

        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded(), "Home page is not loaded");

        header.clickLogin();

        Assert.assertTrue(loginPage.isUrlLoaded(), "Current page is not Login");

        loginPage.fillInUserName(username);
        loginPage.fillInPassword(password);
        loginPage.checkRememberMe();
        loginPage.homeIcon();

        Assert.assertTrue(loginPage.isCheckedRememberMe(), "Remember me checkbox is not checked.");

        loginPage.clickSignIn();
        header.clickProfile();
        Assert.assertTrue(loginPage.homeIcon(), "HomeIcon is visible");
        Assert.assertTrue(profilePage.isUrlLoaded(userId), "Current page in not profile page for " + userId + " user");
        Assert.assertTrue(profilePage.isUrlLoaded(), "Current page is not profile page");
    }
}