package e2e;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTest extends BaseTest {

    @Test
    void validUserCanLogin() {
        HomePage homePage = new HomePage(page);
        homePage.consentToUseData();
        homePage.navbar.navigateToLoginPage();
    }
}
