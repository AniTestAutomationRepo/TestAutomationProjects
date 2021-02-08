package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class DriverHelper {

    public WebDriver createDriver() throws Exception {
        WebDriver driver;
        String browser = ConfigHelper.getConfigProperties("browser");
        switch(browser) {
            case "firefox":
                System.getProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-web-security");
                options.addArguments("--allow-running-insecure-content");
                driver = new ChromeDriver(options);
                break;
            default: throw new Exception("browser" +browser+ " is not supported");
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return  driver;
    }

    public void close(WebDriver driver) {
        driver.quit();
    }

}
