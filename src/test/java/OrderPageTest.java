import exist.OrdersPage;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderPageTest {

    static BrowserDrivers browserDrivers;
    static HashMap<String, OrdersPage> orderMap;
    static String login = "+79213983025";
    static String password = "yjWFkrJ";

    @BeforeAll
    public static void loadPage() throws IOException {
        browserDrivers = new BrowserDrivers();
        orderMap = new HashMap<String, OrdersPage>();
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().window().maximize());
        browserDrivers.drivers.forEach((key, driver) -> driver.get(OrdersPage.startUrl));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS));
        browserDrivers.drivers.forEach((key, driver) -> orderMap.put(key, new OrdersPage(driver)));
        orderMap.forEach((key, order) -> order.auth(login, password));
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
    @DisplayName("Ordering process")
    public void ordering() throws InterruptedException {

        orderMap.forEach((key, order) -> order.clickGarageButton());
        TimeUnit.SECONDS.sleep(1);
        orderMap.forEach((key, order) -> order.clickQashqaiButton());
        TimeUnit.SECONDS.sleep(1);
        orderMap.forEach((key, order) -> order.clickToButtun());
        TimeUnit.SECONDS.sleep(1);
        orderMap.forEach((key, order) -> order.clickPriceButton());
        TimeUnit.SECONDS.sleep(1);
        orderMap.forEach((key, order) -> order.clickAddToCartButton());
        TimeUnit.SECONDS.sleep(1);
        orderMap.forEach((key, order) -> order.clickCartButton());
        TimeUnit.SECONDS.sleep(1);
        orderMap.forEach((key, order) -> order.clickContinueButton());
        TimeUnit.SECONDS.sleep(1);
        orderMap.forEach((key, order) -> order.clickSamovivozButton());
        orderMap.forEach((key, order) -> order.clickSoglasenButton());
    }


}