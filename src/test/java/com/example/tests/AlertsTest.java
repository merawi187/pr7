package com.example.tests;

import com.example.pages.AlertsPage;
import com.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {

    @Test
    public void shouldHandleSimpleAlert() {
        AlertsPage page = new AlertsPage(driver, wait);

        page.open();
        page.openSimpleAlertAndAccept();

        Assert.assertTrue(true, "Простой алерт должен быть успешно принят");
    }

    @Test
    public void shouldHandleTimerAlert() {
        AlertsPage page = new AlertsPage(driver, wait);

        page.open();
        page.openTimerAlertAndAccept();

        Assert.assertTrue(true, "Таймер алерт должен быть успешно принят");
    }

    @Test
    public void shouldHandleConfirmAlertAccept() {
        AlertsPage page = new AlertsPage(driver, wait);

        page.open();
        page.openConfirmAlertAndAccept();

        Assert.assertTrue(page.isConfirmResultVisible(), "Ожидалось появление результата подтверждения");
        String result = page.getConfirmResult();
        Assert.assertTrue(result.contains("Ok"), "Ожидалось, что результат содержит 'Ok'");
    }

    @Test
    public void shouldHandleConfirmAlertDismiss() {
        AlertsPage page = new AlertsPage(driver, wait);

        page.open();
        page.openConfirmAlertAndDismiss();

        Assert.assertTrue(page.isConfirmResultVisible(), "Ожидалось появление результата подтверждения");
        String result = page.getConfirmResult();
        Assert.assertTrue(result.contains("Cancel"), "Ожидалось, что результат содержит 'Cancel'");
    }

    @Test(dataProvider = "promptTexts")
    public void shouldHandlePromptAlertWithText(String inputText) {
        AlertsPage page = new AlertsPage(driver, wait);

        page.open();
        page.openPromptAlertAndSendText(inputText);

        Assert.assertTrue(page.isPromptResultVisible(), "Ожидалось появление результата промпта");
        String result = page.getPromptResult();
        Assert.assertTrue(result.contains(inputText), "Ожидалось, что результат содержит введенный текст: " + inputText);
    }

    @Test
    public void shouldHandlePromptAlertDismiss() {
        AlertsPage page = new AlertsPage(driver, wait);

        page.open();
        page.openPromptAlertAndDismiss();

        Assert.assertTrue(true, "Промпт алерт должен быть успешно закрыт");
    }

    @Test
    public void shouldDisplayCorrectConfirmMessages() {
        AlertsPage page = new AlertsPage(driver, wait);

        page.open();
        page.openConfirmAlertAndAccept();

        String result = page.getConfirmResult();
        Assert.assertEquals(result, "You selected Ok", "Ожидалось точное сообщение о принятии подтверждения");
    }

    @Test
    public void shouldDisplayCorrectPromptMessages() {
        AlertsPage page = new AlertsPage(driver, wait);
        String testText = "Test Prompt Input";

        page.open();
        page.openPromptAlertAndSendText(testText);

        String result = page.getPromptResult();
        Assert.assertEquals(result, "You entered " + testText, "Ожидалось точное сообщение о введенном тексте");
    }

    @DataProvider(name = "promptTexts")
    public Object[][] promptTexts() {
        return new Object[][]{
                {"Hello World"},
                {"Test123"},
                {"Special chars: !@#$%"},
                {"Numbers: 123456"},
                {"Unicode: Привет мир"}
        };
    }
}
