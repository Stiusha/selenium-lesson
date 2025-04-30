package org.example;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AppTest {
    @Test
    public void test() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://good-harvest.ua/");

        List<WebElement> menuElements = driver.findElements(By.className("products-menu__title-link"));
        WebElement menuButton = menuElements.get(2);
        menuButton.click();

        //catalog-grid__item
        List<WebElement> filterBoxes = driver.findElements(By.className("catalog-grid__item"));
        WebElement filterButton = filterBoxes.get(1);
        filterButton.click();

        List<WebElement> catalogBoxes = driver.findElements(By.className("catalog-grid__item"));
        WebElement catalogButton = catalogBoxes.get(9);
        catalogButton.click();

        WebElement counterField = driver.findElement(By.className("counter-field"));
        counterField.clear();
        counterField.sendKeys(Keys.chord("5"));
        Thread.sleep(1000);

        WebElement buyButton = driver.findElement(By.className("j-buy-button-add"));
        buyButton.click();

        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement closeButton = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[contains(@class, '__cart')]//a[contains(@class, 'popup-close')]")));
        closeButton.click();

        WebElement basketValue = driver.findElement(By.className("j-basket-quantity"));
        String basketValueText = basketValue.getText();

        if (!"5".equals(basketValueText)) {
            driver.quit();
            throw new RuntimeException("basketValue not equal expected result");
        }
        driver.quit();
    }
}

