    package e2e;

    import base.BaseTest;
    import components.ProductCard;
    import helpers.ProductHelper;
    import models.products.Product;
    import org.testng.annotations.Ignore;
    import org.testng.annotations.Test;
    import pages.*;
    import testData.SignupData;

    import static constants.ProductConstants.CATEGORY_DRESS;
    import static constants.ProductConstants.USERTYPE_WOMEN;

    public class E2EUserJourneyTest extends BaseTest {
        private final SignupData signupData = new SignupData();

        @Test
        public void userCanCompleteE2EJourney() {
            HomePage homePage = new HomePage(page);
            LoginPage loginPage = homePage.navigateToLoginPage();
            loginPage.enterSignupEmail(signupData.email);
            loginPage.enterSignupName(signupData.userName);
            SignupPage signupPage = loginPage.clickSignupBtn();
            AccountCreatedPage accCreatedPage = signupPage.registerUser(signupData);
            HomePage homePageAfterSignup = accCreatedPage.clickContinue();
            ProductsPage productsPage = homePageAfterSignup.navigateToProductsPage();
            productsPage.goToWomenCategory(CATEGORY_DRESS);
            Product selectedProduct = ProductHelper.findSortedProduct(USERTYPE_WOMEN, CATEGORY_DRESS, 1);
            ProductCard productCard = new ProductCard(page, selectedProduct.getName());
            productCard.addToCart();
        }


    }
