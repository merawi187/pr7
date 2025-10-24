package com.example.tests;

import com.example.pages.ButtonsPage;
import com.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void shouldHandleDoubleClick() {
        ButtonsPage page = new ButtonsPage(driver, wait);

        page.open();
        page.doubleClickButton();

        Assert.assertTrue(page.hasDoubleClickMessage(), "Ожидалось появление сообщения о двойном клике");
        String message = page.getDoubleClickMessageText();
        Assert.assertTrue(message.contains("double click"), "Ожидалось, что сообщение содержит текст о двойном клике");
    }

    @Test
    public void shouldHandleRightClick() {
        ButtonsPage page = new ButtonsPage(driver, wait);

        page.open();
        page.rightClickButton();

        Assert.assertTrue(page.hasRightClickMessage(), "Ожидалось появление сообщения о правом клике");
        String message = page.getRightClickMessageText();
        Assert.assertTrue(message.contains("right click"), "Ожидалось, что сообщение содержит текст о правом клике");
    }

    @Test
    public void shouldHandleDynamicClick() {
        ButtonsPage page = new ButtonsPage(driver, wait);

        page.open();
        page.clickMeButton();

        Assert.assertTrue(page.hasDynamicClickMessage(), "Ожидалось появление сообщения о динамическом клике");
        String message = page.getDynamicClickMessageText();
        Assert.assertTrue(message.contains("dynamic click"), "Ожидалось, что сообщение содержит текст о динамическом клике");
    }

    @Test
    public void shouldHandleAllButtonClicks() {
        ButtonsPage page = new ButtonsPage(driver, wait);

        page.open();
        
        page.doubleClickButton();
        page.rightClickButton();
        page.clickMeButton();

        Assert.assertTrue(page.hasDoubleClickMessage(), "Ожидалось появление сообщения о двойном клике");
        Assert.assertTrue(page.hasRightClickMessage(), "Ожидалось появление сообщения о правом клике");
        Assert.assertTrue(page.hasDynamicClickMessage(), "Ожидалось появление сообщения о динамическом клике");
    }

    @Test
    public void shouldDisplayCorrectMessages() {
        ButtonsPage page = new ButtonsPage(driver, wait);

        page.open();
        page.doubleClickButton();

        String doubleClickMessage = page.getDoubleClickMessageText();
        Assert.assertEquals(doubleClickMessage, "You have done a double click", 
                "Ожидалось точное сообщение о двойном клике");

        page.rightClickButton();
        String rightClickMessage = page.getRightClickMessageText();
        Assert.assertEquals(rightClickMessage, "You have done a right click", 
                "Ожидалось точное сообщение о правом клике");

        page.clickMeButton();
        String dynamicClickMessage = page.getDynamicClickMessageText();
        Assert.assertEquals(dynamicClickMessage, "You have done a dynamic click", 
                "Ожидалось точное сообщение о динамическом клике");
    }
}
