import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class DefaultSettings {
    static WebDriver driver;

    @Before
    public void setBrowser() throws Exception {
        setUp("chrome");
    }

    public static void setUp(String browser) throws Exception {
        switch (browser.toLowerCase()) {
            case "chrome":
//                driver = new RemoteWebDriver(server, capabilities);
                System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
            case "opera":
                System.setProperty("webdriver.opera.driver", "Drivers/operadriver.exe");
                driver = new OperaDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "Drivers/MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
            default:
                throw new Exception("Browser is not correct");
        }
    }

    @After
    public void close () {
        driver.close();
    }
}

