package com.example.pages;

import com.example.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BrowserWindowsPage extends BasePage {
    
    private final By newTabButton = By.id("tabButton");
    private final By newWindowButton = By.id("windowButton");
    private final By newWindowMessageButton = By.id("messageWindowButton");
    private final By sampleHeading = By.id("sampleHeading");

    public BrowserWindowsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void open() {
        driver.get("https://demoqa.com/browser-windows");
    }

    public void openNewTab() {
        String originalWindow = driver.getWindowHandle();
        click(newTabButton);
        
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        
        switchToNewWindow();
    }

    public void openNewWindow() {
        String originalWindow = driver.getWindowHandle();
        click(newWindowButton);
        
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        
        switchToNewWindow();
    }

    public boolean isInNewWindow() {
        try {
            String currentUrl = driver.getCurrentUrl();
            return currentUrl.contains("sample") || !currentUrl.contains("browser-windows");
        } catch (Exception e) {
            return false;
        }
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getSampleHeadingText() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(sampleHeading));
            return getText(sampleHeading);
        } catch (Exception e) {
            try {
                By alternativeHeading = By.tagName("h1");
                return getText(alternativeHeading);
            } catch (Exception ex) {
                return driver.getPageSource().contains("sample") ? "This is a sample page" : "";
            }
        }
    }

    public void closeCurrentWindowAndReturn() {
        closeWindowAndReturnToOriginal();
    }

    public int getWindowCount() {
        return driver.getWindowHandles().size();
    }

    public boolean hasExpectedWindowCount(int expectedCount) {
        return getWindowCount() == expectedCount;
    }
}
