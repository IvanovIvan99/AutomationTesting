package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public static final String PAGE_URL = "http://training.skillo-bg.com:4200/users/login";
    private final WebDriver webDriver;

    public LoginPage(WebDriver driver){
        this.webDriver = driver;
    }

    public boolean isUrlLoaded(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlToBe(PAGE_URL));
    }

    public void fillInUserName(String username){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement usernameTextField = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.id("defaultLoginFormUsername"))));
        usernameTextField.sendKeys(username);
    }

    public void fillInPassword(String password){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement usernameTextField = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//form/input[@id='defaultLoginFormPassword']"))));
        usernameTextField.sendKeys(password);
    }

    public void checkRememberMe(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement rememberMeCheckbox = webDriver.findElement(By.xpath("//*[@class='remember-me']/input[@type='checkbox']"));
        wait.until(ExpectedConditions.elementToBeClickable(rememberMeCheckbox));
        rememberMeCheckbox.click();
    }

    public boolean isCheckedRememberMe(){
        WebElement rememberMeCheckbox = webDriver.findElement(By.xpath("//*[@class='remember-me']/input[@type='checkbox']"));
        return rememberMeCheckbox.isSelected();
    }
    public boolean homeIcon(){
        WebElement homeIcon = webDriver.findElement(By.id("homeIcon"));
        return homeIcon.isDisplayed();
    }

    public void clickSignIn(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("sign-in-button"))));
        signInButton.click();
    }
}