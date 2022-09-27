import exist.AutoPointsPage;
import exist.CheckVINPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class AutoPointsPageTest {

    static BrowserDrivers browserDrivers;
    static HashMap<String, AutoPointsPage> vinPageMap;

    @BeforeAll
    public static void loadPage()  {
        browserDrivers = new BrowserDrivers();
        vinPageMap = new HashMap<String, AutoPointsPage>();
        browserDrivers.drivers.forEach((key, driver) -> driver.get(AutoPointsPage.startUrl));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS));
        browserDrivers.drivers.forEach((key, driver) -> vinPageMap.put(key, new AutoPointsPage(driver)));
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
    @DisplayName("Check Blogs section")
    public void checkBlogsSection() {
        vinPageMap.forEach((key, autoPointsPage) -> autoPointsPage.blogsSection.isDisplayed());
    }

    @Test
    @DisplayName("Check New Addresses section")
    public void newAddressesSection() {
        vinPageMap.forEach((key, autoPointsPage) -> autoPointsPage.newAddressesSection.isDisplayed());
    }

    @Test
    @DisplayName("Check Repair Page")
    public void repairPageExists() {
        vinPageMap.forEach((key, autoPointsPage) -> autoPointsPage.repairPageButton.isDisplayed());
    }

    @Test
    @DisplayName("Check Refuel Page")
    public void refuelPageExists() {
        vinPageMap.forEach((key, autoPointsPage) -> autoPointsPage.refuelPageButton.isDisplayed());
    }
}
