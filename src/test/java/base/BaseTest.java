package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import config.TestConfig;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeClass
    public void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(TestConfig.HEADLESS)
                        .setChannel(TestConfig.BROWSER)
                        .setSlowMo(TestConfig.SLOW_MO)
        );
        page = browser.newContext().newPage();
        page.navigate(TestConfig.APP_URL);
    }

    @AfterClass
    public void closeBrowser() {
        try {
            if (browser != null) browser.close();
        } finally {
            if (playwright != null) playwright.close();
        }
    }
}
