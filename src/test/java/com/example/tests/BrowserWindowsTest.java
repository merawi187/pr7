package com.example.tests;

import com.example.pages.BrowserWindowsPage;
import com.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserWindowsTest extends BaseTest {

    @Test
    public void shouldOpenNewTab() {
        BrowserWindowsPage page = new BrowserWindowsPage(driver, wait);

        page.open();
        page.openNewTab();

        Assert.assertTrue(page.isInNewWindow(), "Ожидалось, что мы находимся в новом окне/вкладке");
        Assert.assertTrue(page.hasExpectedWindowCount(2), "Ожидалось наличие 2 окон");
        
        String heading = page.getSampleHeadingText();
        Assert.assertEquals(heading, "This is a sample page", "Ожидалось корректное содержимое новой вкладки");
        
        page.closeCurrentWindowAndReturn();
        Assert.assertTrue(page.hasExpectedWindowCount(1), "Ожидалось наличие 1 окна после закрытия");
    }

    @Test
    public void shouldOpenNewWindow() {
        BrowserWindowsPage page = new BrowserWindowsPage(driver, wait);

        page.open();
        page.openNewWindow();

        Assert.assertTrue(page.isInNewWindow(), "Ожидалось, что мы находимся в новом окне");
        Assert.assertTrue(page.hasExpectedWindowCount(2), "Ожидалось наличие 2 окон");
        
        String heading = page.getSampleHeadingText();
        Assert.assertEquals(heading, "This is a sample page", "Ожидалось корректное содержимое нового окна");
        
        page.closeCurrentWindowAndReturn();
        Assert.assertTrue(page.hasExpectedWindowCount(1), "Ожидалось наличие 1 окна после закрытия");
    }

    @Test
    public void shouldHandleMultipleWindows() {
        BrowserWindowsPage page = new BrowserWindowsPage(driver, wait);

        page.open();
        
        page.openNewTab();
        Assert.assertTrue(page.hasExpectedWindowCount(2), "Ожидалось наличие 2 окон после открытия первой вкладки");
        
        page.closeCurrentWindowAndReturn();
        Assert.assertTrue(page.hasExpectedWindowCount(1), "Ожидалось наличие 1 окна после закрытия первой вкладки");
        
        page.openNewWindow();
        Assert.assertTrue(page.hasExpectedWindowCount(2), "Ожидалось наличие 2 окон после открытия нового окна");
        
        page.closeCurrentWindowAndReturn();
        Assert.assertTrue(page.hasExpectedWindowCount(1), "Ожидалось наличие 1 окна после закрытия всех новых окон");
    }

    @Test
    public void shouldVerifyWindowSwitching() {
        BrowserWindowsPage page = new BrowserWindowsPage(driver, wait);

        page.open();
        String originalUrl = page.getCurrentUrl();
        
        page.openNewTab();
        String newTabUrl = page.getCurrentUrl();
        
        Assert.assertNotEquals(originalUrl, newTabUrl, "Ожидалось, что URL новой вкладки отличается от исходного");
        Assert.assertTrue(newTabUrl.contains("sample"), "Ожидалось, что URL новой вкладки содержит 'sample'");
        
        page.closeCurrentWindowAndReturn();
        String returnedUrl = page.getCurrentUrl();
        Assert.assertEquals(returnedUrl, originalUrl, "Ожидалось, что после возврата URL соответствует исходному");
    }
}
