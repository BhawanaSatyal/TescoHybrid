package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserManager extends BasePage{
    LoadProp loadProp = new LoadProp();
//    String browserName = "chrome";
    String browserName=System.getProperty("browser");
    Boolean InCloud = false;

    public static final String AUTOMATE_USERNAME = "bhawanasatyal_wcbJFy";
    public static final String AUTOMATE_ACCESS_KEY = "N5ppFV5AQcwyx8wxYXvG";
    public static final String browserStackURL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public void openBrowser() {
        if (InCloud) {
            DesiredCapabilities caps = new DesiredCapabilities();
            if (browserName.equalsIgnoreCase("safari")) {
                caps.setCapability("os_version", "Big Sur");
                caps.setCapability("resolution", "1920x1080");
                caps.setCapability("browser", "Safari");
                caps.setCapability("browser_version", "14.1");
                caps.setCapability("os", "OS X");
                caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
                caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
            } else if (browserName.equalsIgnoreCase("chrome")) {
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "7");
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.14.0");
            } else if (browserName.equalsIgnoreCase("firefox")) {
            }


            try {
                driver = new RemoteWebDriver(new URL(browserStackURL), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }


        } else {
            if (browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.edge.driver", "src/test/java/drivers/msedgedriver.exe");
                driver = new EdgeDriver();
            } else {
                System.out.println("Incorrect Browser");
            }


            driver.manage().window().maximize();
            driver.get(loadProp.getProperty("url"));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        }
    }
        public void closeBrowser () {
            // driver.close();
        }
    }