import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserDrivers {

    HashMap<String, WebDriver> drivers = new HashMap<>();

    public BrowserDrivers() {
        try {
            JsonReader jsonReader = new JsonReader();
            JSONObject config = jsonReader.readJsonFromUrl("http://localhost:4444/wd/hub/status");
            JSONArray nodes = config.getJSONObject("value").getJSONArray("nodes");

            nodes.forEach((node) -> {
                JSONArray slots = new JSONObject(node.toString()).getJSONArray("slots");
                try {
                    this.drivers.putIfAbsent("Edge", new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new EdgeOptions()));

                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setCapability("se:recordVideo", "true");
                    this.drivers.putIfAbsent("Firefox", new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions));

                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setCapability("se:recordVideo", "true");
                    this.drivers.putIfAbsent("Chrome", new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions));

                } catch (MalformedURLException e) {
                    System.out.println("Failed to add driver");
                }
            });

        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }

    }


    public HashMap getDrivers() {
        return this.drivers;
    }

    public void closeBrowser() {
        for (String key : this.drivers.keySet()) {
            drivers.get(key).quit();
        }
    }

}
