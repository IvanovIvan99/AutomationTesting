package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {
    private final WebDriver webDriver;
    @FindBy(id = "nav-link-login")
    private WebElement loginLink;
    @FindBy(id = "nav-link-profile")
    private WebElement profilePageLink;

    public Header(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickLogin(){
        loginLink.click();
    }
    /*
    public boolean isEnabledLoginLink(){
        return loginLink.isEnabled();
    }
    */

    public  void clickProfile(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(profilePageLink));
        profilePageLink.click();
    }
}