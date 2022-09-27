package exist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class OrdersPage {

    public static String startUrl = "https://exist.ru/";

    @FindBy(xpath = "/html/body/div[1]/header/section[1]/div/div[3]/div[2]/div[1]")
    public WebElement mainLoginButton;

    @FindBy(xpath = "/html/body/div[1]/header/section[1]/div/div[3]/div[2]/div[2]/div/div/div/div/form/div[1]/input")
    public WebElement phoneNumber;

    @FindBy(xpath = "/html/body/div[1]/header/section[1]/div/div[3]/div[2]/div[2]/div/div/div/div/form/div[2]/input")
    public WebElement password;

    @FindBy(xpath = "/html/body/div[1]/header/section[1]/div/div[3]/div[2]/div[2]/div/div/div/div/form/div[3]/input")
    public WebElement loginButton;

    public void auth(String login, String pass) {
        this.mainLoginButton.click();
        this.phoneNumber.sendKeys(login);
        this.password.sendKeys(pass);
        this.loginButton.click();
    }

    @FindBy(xpath = "/html/body/div[1]/header/div/div/div[3]/div[1]/span")
    public WebElement garageButton;

    @FindBy(xpath = "/html/body/div[1]/header/div/div/div[3]/div[2]/div/div[3]/div/div[3]/div[1]/ul/li[3]/a")
    public WebElement toButtun;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/div[4]/div[3]/div/div[1]/div[1]/div[2]/a")
    public WebElement priceButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/div[4]/div[3]/div[3]/div[2]/div[2]/div/div[1]/div[2]/a")
    public WebElement addToCartButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/div[3]/div[2]/div/div[4]/a")
    public WebElement continueButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/div[4]/div[1]/div[2]/div[2]/div[1]/ul/div/li[2]/a/i")
    public WebElement samovivozButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/div[4]/div[2]/div[2]/div[4]/input")
    public WebElement soglasenButton;

    @FindBy(xpath = "/html/body/div[1]/header/div/div/div[3]/div[2]/div/div[5]/div[1]/div/div[2]/div[1]")
    public WebElement qashqaiButton;

    @FindBy(xpath = "/html/body/div[1]/header/section[2]/div[3]/noindex[2]/a")
    public WebElement cartButton;


    public WebDriver driver;

    public OrdersPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.driver = webDriver;
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void clickCartButton(){this.cartButton.click();}

    public void clickGarageButton(){this.garageButton.click();}

    public void clickToButtun(){this.toButtun.click();}

    public void clickPriceButton(){this.priceButton.click();}

    public void clickAddToCartButton(){this.addToCartButton.click();}

    public void clickContinueButton(){this.continueButton.click();}

    public void clickSamovivozButton(){this.samovivozButton.click();}

    public void clickSoglasenButton(){this.soglasenButton.click();}

    public void clickQashqaiButton(){this.qashqaiButton.click();}
}