package exist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage {

    public static String url = "https://exist.ru/";

    @FindBy(xpath = "/html/body/div[1]/header/section[1]/div/div[3]/div[1]/noindex/a")
    public WebElement registrationButton;

    @FindBy(xpath = "/html/body/div[1]/header/section[2]/div[1]/a")
    public WebElement homePageButton;

    @FindBy(xpath = "/html/body/div[1]/header/div/div/div[2]/ul/li[1]/a")
    public WebElement VINRequestButton;

    @FindBy(xpath = "/html/body/div[1]/header/div/div/div[2]/ul/li[2]/noindex/a")
    public WebElement saleCarButton;

    @FindBy(xpath = "/html/body/div[1]/header/div/div/div[2]/ul/li[3]/a")
    public WebElement autoPlacesButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/table/tbody/tr/td[1]/div[2]/div/div[3]/ul/li[10]/a")
    public WebElement nissanButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/table/tbody/tr/td[1]/div[2]/div/div[5]/ul/li[9]/a")
    public WebElement uazButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/table/tbody/tr/td[1]/section/div[5]/div[1]/a")
    public WebElement brakeLiquidsButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/table/tbody/tr/td[1]/section/div[5]/div[3]/a[1]")
    public WebElement oilButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/table/tbody/tr/td[1]/div[4]/div[1]/ul/li[2]/a")
    public WebElement categoryNewsButton;

    @FindBy(xpath = "/html/body/footer/div[1]/div[1]/div[1]/ul/li[1]/a")
    public WebElement aboutCompanyButton;

    @FindBy(xpath = "/html/body/div[1]/header/section[1]/div/div[3]/div[2]")
    public WebElement loginButton;

    @FindBy(xpath = "/html/body/div[1]/header/section[1]/div/div[3]/div/div[1]/span")
    public WebElement loggedUsernameSpan;

    @FindBy(xpath = "/html/body/div[1]/header/section[1]/div/div[3]/div[2]/div[2]/div/div/div/div/form/div[3]/input")
    public WebElement loginInFromButton;

    @FindBy(xpath = "/html/body/div[1]/header/section[1]/div/div[3]/div[2]/div[2]/div/div/div/div/form/div[1]/input")
    public WebElement loginInputText;

    @FindBy(xpath = "/html/body/div[1]/header/section[1]/div/div[3]/div[2]/div[2]/div/div/div/div/form/div[2]/input")
    public WebElement passwordInputText;

    public void loginButtonClick() {
        this.loginButton.click();
    }

    public void loginInFormButtonClick() {
        this.loginInFromButton.click();
    }

    public void enterText(WebElement input, String login) {
        input.sendKeys(login);
    }

    public String getUsername() {
        return loggedUsernameSpan.getText();
    }

    public WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

}
