import exist.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest {

    static BrowserDrivers browserDrivers;
    static HashMap<String, HomePage> homePageMap;
    static String login = "+xxxxxxxxxxx";
    static String password = "yjWFkrJ";

    @BeforeAll
    public static void loadPage() {
        browserDrivers = new BrowserDrivers();
        homePageMap = new HashMap<String, HomePage>();
        browserDrivers.drivers.forEach((key, driver) -> driver.get(HomePage.url));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS));
        browserDrivers.drivers.forEach((key, driver) -> homePageMap.put(key, new HomePage(driver)));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().window().setSize(new Dimension(1024, 1024)));
    }

    @BeforeEach
    @AfterEach
    public void timeOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }

    @AfterAll
    public static void closeUp() {
        browserDrivers.closeBrowser();
    }

    @Test
    @DisplayName("Authentication Test")
    public void loginForm() {
        homePageMap.forEach((key, homePage) -> homePage.loginButtonClick());
        homePageMap.forEach((key, homePage) -> homePage.enterText(homePage.loginInputText, login));
        homePageMap.forEach((key, homePage) -> homePage.enterText(homePage.passwordInputText, password));
        homePageMap.forEach((key, homePage) -> homePage.loginInFormButtonClick());
        homePageMap.forEach((key, homePage) -> assertEquals(homePage.getUsername(), login));
    }

    @Test
    @DisplayName("VIN Request Button Exists")
    public void VINRequestButtonExists() {
        homePageMap.forEach((key, homePage) -> assertTrue(homePage.VINRequestButton.isDisplayed()));
    }

    @Test
    @DisplayName("Sale Car Button Exists")
    public void saleCarButtonButtonExists() {
        homePageMap.forEach((key, homePage) -> assertTrue(homePage.saleCarButton.isDisplayed()));
    }

    @Test
    @DisplayName("Auto Places Button Exists")
    public void autoPlacesButtonButtonExists() {
        homePageMap.forEach((key, homePage) -> assertTrue(homePage.autoPlacesButton.isDisplayed()));
    }

    @Test
    @DisplayName("About Company Button Exists")
    public void aboutCompanyButtonExists() {
        homePageMap.forEach((key, homePage) -> assertTrue(homePage.aboutCompanyButton.isDisplayed()));
    }

}
