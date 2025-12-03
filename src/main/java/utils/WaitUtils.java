package utils;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

public class WaitUtils {
    public static void waitForVisibility(Locator... locators) {
        for (Locator locator : locators) {
            locator.waitFor(new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.VISIBLE));
        }
    }
}
