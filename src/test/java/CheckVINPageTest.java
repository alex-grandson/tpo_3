import exist.CheckVINPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckVINPageTest {

    static BrowserDrivers browserDrivers;
    static HashMap<String, CheckVINPage> vinPageMap;
    static String login = "+79213983025";
    static String password = "yjWFkrJ";

    @BeforeEach
    public void startAddingCar() {
        vinPageMap.forEach((key, checkVINPage) -> checkVINPage.clickAddCar());
    }

    @AfterEach
    public void dropToNewQuery() {
        browserDrivers.drivers.forEach((key, driver) -> driver.get(CheckVINPage.startUrl));
    }
    @BeforeAll
    public static void loadPage() {
        browserDrivers = new BrowserDrivers();
        vinPageMap = new HashMap<String, CheckVINPage>();
        browserDrivers.drivers.forEach((key, driver) -> driver.get(CheckVINPage.startUrl));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS));
        browserDrivers.drivers.forEach((key, driver) -> vinPageMap.put(key, new CheckVINPage(driver)));

        vinPageMap.forEach((key, checkVINPage) -> checkVINPage.auth(login, password));
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
    @DisplayName("Form is displayed")
    public void formIsDisplayed() {
        vinPageMap.forEach((key, checkVINPage) -> checkVINPage.VINField.isDisplayed());
    }

    @Test
    @DisplayName("Check VAZ 21099 VIN")
    public void checkVINVaz21099(){
        vinPageMap.forEach((key, checkVINPage) -> checkVINPage.enterVIN("XTA210990Y2766389"));
        vinPageMap.forEach((key, checkVINPage) -> checkVINPage.getCar());
        vinPageMap.forEach((key, checkVINPage) -> assertTrue(checkVINPage.characteristicsPopUp.isDisplayed()));
    }

    @Test
    @DisplayName("Check Chrysler Voyager VIN")
    public void checkVINChryslerVoyager() {
        vinPageMap.forEach((key, checkVINPage) -> checkVINPage.enterVIN("2C4GJ453XYR693697"));
        vinPageMap.forEach((key, checkVINPage) -> checkVINPage.getCar());
        vinPageMap.forEach((key, checkVINPage) -> assertTrue(checkVINPage.characteristicsPopUp.isDisplayed()));

    }

    @Test
    @DisplayName("Check Chrysler Voyager Characteristics")
    public void checkCharacteristicsChrysler() {
        vinPageMap.forEach((key, checkVINPage) -> checkVINPage.enterVIN("2C4GJ453XYR693697"));
        vinPageMap.forEach((key, checkVINPage) -> checkVINPage.getCar());
        vinPageMap.forEach((key, checkVINPage) -> assertEquals("2000", checkVINPage.yearOfProductionSpan.getText()));
    }

}
