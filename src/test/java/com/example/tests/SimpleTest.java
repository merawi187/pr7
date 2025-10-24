package com.example.tests;

import com.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest extends BaseTest {

    @Test
    public void shouldInitializeDriver() {
        Assert.assertNotNull(driver, "WebDriver должен быть инициализирован");
        Assert.assertNotNull(wait, "WebDriverWait должен быть инициализирован");
        
        driver.get("https://demoqa.com");
        String title = driver.getTitle();
        Assert.assertFalse(title.isEmpty(), "Заголовок страницы не должен быть пустым");
        System.out.println("Тест прошел успешно! Заголовок: " + title);
    }
}
