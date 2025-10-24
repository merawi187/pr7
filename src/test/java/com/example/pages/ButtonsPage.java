package com.example.pages;

import com.example.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonsPage extends BasePage {
    
    private final By doubleClickButton = By.id("doubleClickBtn");
    private final By rightClickButton = By.id("rightClickBtn");
    private final By clickMeButton = By.xpath("//button[text()='Click Me']");
    
    private final By doubleClickMessage = By.id("doubleClickMessage");
    private final By rightClickMessage = By.id("rightClickMessage");
    private final By dynamicClickMessage = By.id("dynamicClickMessage");

    public ButtonsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void open() {
        driver.get("https://demoqa.com/buttons");
    }

    public void doubleClickButton() {
        WebElement button = waitForElement(doubleClickButton);
        Actions actions = new Actions(driver);
        actions.doubleClick(button).perform();
    }

    public void rightClickButton() {
        WebElement button = waitForElement(rightClickButton);
        Actions actions = new Actions(driver);
        actions.contextClick(button).perform();
    }

    public void clickMeButton() {
        click(clickMeButton);
    }

    public boolean hasDoubleClickMessage() {
        return isDisplayed(doubleClickMessage);
    }

    public boolean hasRightClickMessage() {
        return isDisplayed(rightClickMessage);
    }

    public boolean hasDynamicClickMessage() {
        return isDisplayed(dynamicClickMessage);
    }

    public String getDoubleClickMessageText() {
        return getText(doubleClickMessage);
    }

    public String getRightClickMessageText() {
        return getText(rightClickMessage);
    }

    public String getDynamicClickMessageText() {
        return getText(dynamicClickMessage);
    }
}
