package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Anton on 18.12.2016.
 */
public class LoginPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "http://pikabu.ru/";

    @FindBy(id = "username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(xpath = "/html/body/div[3]/table/tbody/tr/td[2]/div/div[3]/div/div/div[1]/form/div[3]/button")
    private WebElement buttonSubmit;

    @FindBy(xpath = "/html/body/div[3]/table/tbody/tr/td[2]/div/div[3]/div[1]/ul/li[8]/a")
    private WebElement linkLoggedInUser;

    @FindBy(xpath = "/html/body/div[3]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/div[1]/div/div[1]/a[1]")
    private WebElement sortbyWhat;

    @FindBy(xpath = "/html/body/div[3]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/div[1]/div/div[1]/span[2]")
    private WebElement isChanged;

    @FindBy(xpath = "/html/body/div[7]/div[2]/div/div[2]/input")
    private WebElement byTime;

    @FindBy(xpath = "/html/body/div[2]/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/ul/li[4]/a")
    private WebElement groups;

    @FindBy(xpath = "/html/body/div[3]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/div/div[1]/div[1]/span[3]/a")
    private WebElement mygroups;

    @FindBy(xpath = "/html/body/div[3]/table/tbody/tr/td[2]/div/div[5]/table/tbody/tr[1]/td/div/span/a")
    private WebElement comments;

    @FindBy(xpath = "/html/body/div[3]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/div[2]/div[2]/div/div[1]/div[1]/div[2]/span")
    private WebElement isOpened;

    @FindBy(xpath = "/html/body/div[3]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/div/div[2]/section")
    private WebElement checkGroups;

    @FindBy(xpath = "/html/body/div[3]/table/tbody/tr/td[2]/div/div[8]/table/tbody/tr[3]/td/div/a[1]")
    private WebElement alltags;

    @FindBy(xpath = "/html/body/div[3]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/div[3]/div[4]/a")
    private WebElement cats;

    @FindBy(xpath = "/html/body/div[3]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/div[3]/div[4]/a")
    private WebElement checkCats;


    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("Login page opened");
    }

    public void login(String username, String password)
    {
        inputLogin.sendKeys(username);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        logger.info("Login performed");
    }
    public void sortByTime()
    {
        sortbyWhat.click();
        byTime.click();
        logger.info("Sort changed");
    }
    public void openGroups()
    {
        groups.click();
        mygroups.click();
        logger.info("My groups opened");
    }
    public void openComments()
    {
        comments.click();
        logger.info("Top comments opened");
    }
    public void openCats()
    {
        alltags.click();
        logger.info("Tags opened");
    }
    public String getSortChanged() { return isChanged.getText(); }
    public String getTopComments() { return isOpened.getText(); }
    public String getCheckCats() { return checkCats.getText(); }
    public String getMyGroups() { return checkGroups.getText(); }
    public String getLoggedInUserName() { return linkLoggedInUser.getText(); }

}
