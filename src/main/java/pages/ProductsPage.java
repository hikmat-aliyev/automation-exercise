package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import components.Navbar;
import components.CategoryMenu;
import components.ProductCard;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static constants.ProductConstants.CATEGORY_DRESS;

public class ProductsPage {
    private final Page page;
    public final Navbar navbar;
    public final CategoryMenu categoryMenu;

    private final Locator pageHeader;

    public ProductsPage(Page page) {
        this.page = page;
        this.navbar = new Navbar(page);
        this.categoryMenu = new CategoryMenu(page);

        this.pageHeader = page.getByRole(AriaRole.HEADING,
                new Page.GetByRoleOptions().setName("All Products"));

        verifyOnProductsPage();
    }

    private void verifyOnProductsPage() {
        assertThat(pageHeader).isVisible();
    }

    public ProductsPage goToWomenCategory(String category) {
        categoryMenu.clickWomenSubcategory(category);
        return this;
    }

}