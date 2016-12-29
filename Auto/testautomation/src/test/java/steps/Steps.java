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
    public boolean isGroupsOpened()
    {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.getMyGroups().trim().toLowerCase().equals("подписаться можно на странице понравившегося вам сообщества"));
    }
    public boolean isLoggedIn(String username)
    {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.getLoggedInUserName().trim().toLowerCase().equals("оценки"));
    }

    public void sortByTime() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.sortByTime();
    }
    public void openGroups() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.openGroups();
    }
    public void openTopComments() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.openComments();
    }
    public boolean isCatsChecked()
    {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.getCheckCats().trim().toLowerCase().equals("кот"));
    }
    public void openTopCats() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.openCats();
    }
    public boolean isCommentsOpened()
    {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.getTopComments().trim().toLowerCase().equals("отправлено"));
    }
    public boolean isSortChanged()
    {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.getSortChanged().trim().toLowerCase().equals("за"));
    }
}
