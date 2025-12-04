    package e2e;

    import base.BaseTest;
    import components.ProductCard;
    import helpers.ProductHelper;
    import models.products.Product;
    import org.testng.annotations.Test;
    import pages.*;
    import testData.SignupData;

    import static constants.ProductConstants.CATEGORY_DRESS;
    import static constants.ProductConstants.USERTYPE_WOMEN;
    import static org.testng.Assert.assertTrue;

    public class E2EUserJourneyTest extends BaseTest {
        private final SignupData signupData = new SignupData();

        @Test
        public void userCanCompleteE2EJourney() {
            HomePage homePage = new HomePage(page);

            LoginPage loginPage = homePage.nav.navigateToLoginPage();
            SignupPage signupPage = loginPage.startSignupProcess(signupData);

            AccountCreatedPage accCreatedPage = signupPage.registerUser(signupData);
            assertTrue(accCreatedPage.isAccountCreatedSuccessfully(),
                    "Account should be created successfully with all elements visible");

            HomePage homePageForRegisteredUser = accCreatedPage.clickContinue();

            ProductsPage productsPage = homePageForRegisteredUser.nav.navigateToProductsPage();

            productsPage.goToWomenCategory(CATEGORY_DRESS);
            assertTrue(productsPage.isOnCorrectCategory("Women - Dress Products"));

            Product selectedProduct = ProductHelper.findSortedProduct(USERTYPE_WOMEN, CATEGORY_DRESS, 1);
            ProductCard productCard = new ProductCard(page, selectedProduct.getName());
            productCard.addToCart();

            ViewCartPage viewCartPage = productsPage.viewCart();
            assertTrue(viewCartPage.verifyProductInBasket(selectedProduct.getName()));

            CheckoutPage checkoutPage = viewCartPage.proceedToCheckout();

            PaymentPage paymentPage = checkoutPage.placeOrder();

            paymentPage.submitPayment();
            assertTrue(paymentPage.isOrderPlaced());
        }


    }
