package com.example.tests;

import com.example.pages.TextBoxPage;
import com.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void shouldSubmitValidData() {
        Assert.assertNotNull(driver, "WebDriver не инициализирован");
        Assert.assertNotNull(wait, "WebDriverWait не инициализирован");
        
        TextBoxPage page = new TextBoxPage(driver, wait);
        String fullName = "Ivan Petrov";
        String email = "ivan.petrov@example.com";
        String currentAddress = "Moscow, Red Square, 1";
        String permanentAddress = "Saint Petersburg, Nevsky Prospect, 100";

        page.open();
        page.fillForm(fullName, email, currentAddress, permanentAddress);

        Assert.assertTrue(page.isOutputVisible(), "Ожидалось появление блока вывода после отправки формы");
        Assert.assertTrue(page.containsOutputData(fullName, email, currentAddress, permanentAddress),
                "Ожидалось, что блок вывода содержит введенные данные");
    }
}
