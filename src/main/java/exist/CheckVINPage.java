package exist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CheckVINPage {

    public static String startUrl = "https://exist.ru/Profile/Vin/NewQuery.aspx";
    public static String startQueryUrl = "https://exist.ru/Profile/Car/Create.aspx";

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div[5]/div[2]/form/fieldset/div[1]/input")
    public WebElement loginInput;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div[5]/div[2]/form/fieldset/div[2]/input")
    public WebElement passwordInput;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div[5]/div[2]/form/fieldset/div[4]/button")
    public WebElement loginButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/div[3]/div/a")
    public WebElement addCarButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/div[3]/div[1]/span/div/div[2]/input[1]")
    public WebElement VINField;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/div[3]/div[1]/div[4]/div[2]/input")
    public WebElement continueButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/div[3]/div[1]/span/div/div[2]/div/div[2]")
    public WebElement characteristicsPopUp;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/div[3]/div[1]/span/div/div[2]/div/div[2]/div/ul/li/a[1]/dl/dd[2]")
    public WebElement yearOfProductionSpan;

    public void auth(String login, String pass) {
        this.loginInput.sendKeys(login);
        this.passwordInput.sendKeys(pass);
        this.loginButton.click();
    }

    public void clickAddCar() {
        this.addCarButton.click();
    }

    public void enterVIN(String vin) {
        this.VINField.sendKeys(vin);
    }

    public void getCar() {
        this.continueButton.click();
    }

    public WebDriver webDriver;

    public CheckVINPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
}
