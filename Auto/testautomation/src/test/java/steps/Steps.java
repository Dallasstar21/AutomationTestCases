package steps;

import driver.DriverWorker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.*;

public class Steps {
    private WebDriver driver;

    private final Logger logger = LogManager.getRootLogger();

    public void initBrowser()
    {   driver = DriverWorker.getDriver(); }

    public void closeDriver()
    {
        DriverWorker.closeDriver();
    }

    public void loginPikabu(String username, String password)
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(username, password);
    }

    public boolean isLoggedIn(String username)
    {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.getLoggedInUserName().trim().toLowerCase().equals("оценки"));
    }


}
