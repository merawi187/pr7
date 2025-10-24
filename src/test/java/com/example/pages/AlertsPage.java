package com.example.pages;

import com.example.utils.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage extends BasePage {
    
    private final By alertButton = By.id("alertButton");
    private final By timerAlertButton = By.id("timerAlertButton");
    private final By confirmButton = By.id("confirmButton");
    private final By promptButton = By.id("promtButton");
    
    private final By confirmResult = By.id("confirmResult");
    private final By promptResult = By.id("promptResult");

    public AlertsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void open() {
        driver.get("https://demoqa.com/alerts");
    }

    public void openSimpleAlertAndAccept() {
        click(alertButton);
        waitForAlert();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void openTimerAlertAndAccept() {
        click(timerAlertButton);
        waitForAlert();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void openConfirmAlertAndAccept() {
        click(confirmButton);
        waitForAlert();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void openConfirmAlertAndDismiss() {
        click(confirmButton);
        try {
            waitForAlert();
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (Exception e) {
            System.out.println("Алерт не появился: " + e.getMessage());
        }
    }

    public void openPromptAlertAndSendText(String text) {
        click(promptButton);
        waitForAlert();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }

    public void openPromptAlertAndDismiss() {
        click(promptButton);
        waitForAlert();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public String getConfirmResult() {
        return getText(confirmResult);
    }

    public String getPromptResult() {
        return getText(promptResult);
    }

    public boolean isConfirmResultVisible() {
        return isDisplayed(confirmResult);
    }

    public boolean isPromptResultVisible() {
        return isDisplayed(promptResult);
    }

}
