package exist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class AutoPointsPage {

    public static  String startUrl = "https://exist.ru/AutoPoints/";

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/div[3]/div[1]/div[1]/h2/a")
    public WebElement repairPageButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/div[3]/div[1]/div[2]/h2/a")
    public WebElement refuelPageButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/div[3]/div[3]")
    public WebElement newAddressesSection;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/div[3]/div[4]")
    public WebElement blogsSection;

    public WebDriver webDriver;

    public AutoPointsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
}
