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
    private final String USERNAME = "dallasstar21";
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
    @Test(description = "Sort by time")
    public void oneCanSortByTime()
    {
        steps.sortByTime();
      Assert.assertTrue(steps.isSortChanged());
   }
    @Test(description = "Open my groups")
    public void oneCanOpenGroups()
    {
        steps.loginPikabu(USERNAME, PASSWORD);
       steps.openGroups();
       Assert.assertTrue(steps.isGroupsOpened());
    }
    @Test(description = "Top 50 comments")
    public void oneCanOpenTopComments()
    {
        steps.openTopComments();
        Assert.assertTrue(steps.isCommentsOpened());
    }
    @Test(description = "Top post with cats")
    public void oneCanOpenBestPosts()
    {
        steps.openTopCats();
        Assert.assertTrue(steps.isCatsChecked());
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}
