import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.Steps;

/**
 * Created by Anton on 18.12.2016.
 */
public class TestAutomation {
    private Steps steps;
    private final String USERNAME = "Dallasstar21";
    private final String PASSWORD = "testpass";

    @BeforeMethod(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test(description = "Login on Pikabu")
    public void oneCanLoginPikabu()
    {
        steps.loginPikabu(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(USERNAME));
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}
