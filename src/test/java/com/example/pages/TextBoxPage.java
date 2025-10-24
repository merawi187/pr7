package com.example.pages;

import com.example.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBoxPage extends BasePage {
    
    private final By userNameField = By.id("userName");
    private final By userEmailField = By.id("userEmail");
    private final By currentAddressField = By.id("currentAddress");
    private final By permanentAddressField = By.id("permanentAddress");
    private final By submitButton = By.id("submit");
    private final By outputDiv = By.id("output");

    public TextBoxPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void open() {
        driver.get("https://demoqa.com/text-box");
    }

    public void fillForm(String fullName, String email, String currentAddress, String permanentAddress) {
        sendKeys(userNameField, fullName);
        sendKeys(userEmailField, email);
        sendKeys(currentAddressField, currentAddress);
        sendKeys(permanentAddressField, permanentAddress);
        click(submitButton);
    }

    public boolean isOutputVisible() {
        return isDisplayed(outputDiv);
    }

    public String getOutputText() {
        return getText(outputDiv);
    }

    public boolean containsOutputData(String fullName, String email, String currentAddress, String permanentAddress) {
        String outputText = getOutputText();
        return outputText.contains(fullName) && 
               outputText.contains(email) && 
               outputText.contains(currentAddress) && 
               outputText.contains(permanentAddress);
    }

}
