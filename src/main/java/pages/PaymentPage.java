package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import testData.PaymentData;

public class PaymentPage {
    private final Page page;

    private final Locator nameOnCard;
    private final Locator cardNumber;
    private final Locator cvc;
    private final Locator expiryMonth;
    private final Locator expiryYear;
    private final Locator payBtn;

    private final Locator orderStatus;

    public PaymentPage(Page page) {
        this.page = page;
        this.nameOnCard = page.locator("[data-qa='name-on-card']");
        this.cardNumber= page.locator("[data-qa='card-number']");
        this.cvc = page.locator("[data-qa='cvc']");
        this.expiryMonth = page.locator("[data-qa='expiry-month']");
        this.expiryYear = page.locator("[data-qa='expiry-year']");
        this.payBtn = page.locator("[data-qa='pay-button']");
        this.orderStatus = page.locator("[data-qa='order-placed']");
    }

    public void fillPaymentForm() {
        nameOnCard.fill(PaymentData.nameOnCard);
        cardNumber.fill(PaymentData.cardNumber);
        cvc.fill(PaymentData.cvc);
        expiryMonth.fill(PaymentData.expMonth);
        expiryYear.fill(PaymentData.expYear);
    }

    public void submitPayment() {
        fillPaymentForm();
        payBtn.click();
    }

    public boolean isOrderPlaced() {
        return orderStatus.textContent().trim().equalsIgnoreCase("Order Placed!");
    }

}
