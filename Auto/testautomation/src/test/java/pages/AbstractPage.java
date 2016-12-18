package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Anton on 18.12.2016.
 */
public abstract class AbstractPage {
    protected WebDriver driver;

    public abstract void openPage();

    public AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }
}
