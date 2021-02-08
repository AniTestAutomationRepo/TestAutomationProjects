package steps;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import steps.base.BaseTest;
import support.ConfigHelper;
import support.DriverHelper;

public class Hooks extends BaseTest {
    private DriverHelper driverHelper = new DriverHelper();
    @Before()
    public void setUp() throws Exception {
        String url = ConfigHelper.getConfigProperties("url");
        driver = driverHelper.createDriver();
        driver.navigate().to(url);
    }

    @After()
    public void teardown() {
        driverHelper.close(driver);
    }
}
