package com.example.pages;

import com.example.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Paths;

public class UploadDownloadPage extends BasePage {
    
    private final By downloadButton = By.id("downloadButton");
    private final By uploadFileInput = By.id("uploadFile");
    private final By uploadedFilePath = By.id("uploadedFilePath");

    public UploadDownloadPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void open() {
        driver.get("https://demoqa.com/upload-download");
    }

    public void uploadFile(String filePath) {
        String absolutePath = Paths.get(filePath).toAbsolutePath().toString();
        driver.findElement(uploadFileInput).sendKeys(absolutePath);
    }

    public String createTestFile() {
        try {
            File testFile = File.createTempFile("test", ".txt");
            java.nio.file.Files.write(testFile.toPath(), "Test file content for upload".getBytes());
            return testFile.getAbsolutePath();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create test file", e);
        }
    }

    public boolean isUploadedFilePathVisible() {
        return isDisplayed(uploadedFilePath);
    }

    public String getUploadedFilePath() {
        return getText(uploadedFilePath);
    }

    public void clickDownloadButton() {
        click(downloadButton);
    }

    public boolean isDownloadButtonClickable() {
        try {
            return driver.findElement(downloadButton).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
}
