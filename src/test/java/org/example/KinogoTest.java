package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class KinogoTest {
    @Test
    public void firstCommentOfNewFilm(){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://kinogo.li/");

        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement itemMenuButton = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class = 'menu']//td[2]//a")));
        itemMenuButton.click();

        WebElement itemZagolovok = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class = 'zagolovki'][1]//a")));
        itemZagolovok.click();

        List<WebElement> listComentarii = waiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class = 'comentarii`']")));
        int size = listComentarii.size();
        System.out.println(size);
        driver.quit();
    }
}
