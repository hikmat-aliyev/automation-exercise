# E2E Automation Project

## Overview

This project contains end-to-end (E2E) automation tests for the Automation Exercise website.
Tests are written in **Java** using **Playwright** for browser automation and **TestNG** as the test framework.

## Project Structure

```
src/
 ├─ main/java/       # Page objects and components
 ├─ test/java/       # Test classes (E2E)
 ├─ testData/        # Test data classes
 ├─ helpers/         # Helper classes for reusable logic
```

## Tools & Technologies

* Java 17+
* Playwright
* TestNG
* Maven
* Allure (for reporting)

## Running Tests

Run all tests:

```bash
mvn clean test
```

## Generating Allure Reports

After running tests, generate the Allure report:

```bash
allure serve target/allure-results
```

> Note: Make sure `allure` is installed on your machine and added to PATH.

## Test Data

* `SignupData.java` contains random user information for sign-up tests.
* `PaymentData.java` contains dummy credit card details for checkout tests.

## Page Objects & Components

* `Pages/` contains Page Object classes for each page.
* `Components/` contains reusable UI components (e.g., Navbar, CategoryMenu, ProductCard).

## Notes

* Locators are mostly based on **ARIA roles** and **CSS selectors**.
* Tests include filtering products, adding to cart, and completing checkout.
* Allure results and generated reports are **not pushed to GitHub**.
