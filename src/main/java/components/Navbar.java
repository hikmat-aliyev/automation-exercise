package components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.ViewCartPage;

public class Navbar {
    private final Page page;
    private final Locator homeBtn ;
    private final Locator productsBtn;
    private final Locator cartBtn;
    private final Locator loginBtn;

    public Navbar(Page page) {
        this.page = page;
        this.homeBtn = page.locator("a[href='/']");
        this.productsBtn = page.locator("a[href='/products']");
        this.cartBtn = page.locator("a[href='/view_cart']");
        this.loginBtn = page.locator("a[href='/login']");
    }

    public LoginPage navigateToLoginPage() {
        loginBtn.click();
        return new LoginPage(page);
    }

    public HomePage navigateToHomepage() {
        homeBtn.click();
        return new HomePage(page);
    }

    public ViewCartPage navigateToShoppingCart() {
        cartBtn.click();
        return new ViewCartPage(page);
    }

    public ProductsPage navigateToProductsPage() {
        productsBtn.click();
        return new ProductsPage(page);
    }
}
