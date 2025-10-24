package com.example.tests;

import com.example.pages.UploadDownloadPage;
import com.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class UploadDownloadTest extends BaseTest {

    @Test
    public void shouldUploadFileSuccessfully() {
        UploadDownloadPage page = new UploadDownloadPage(driver, wait);
        String testFilePath = page.createTestFile();

        try {
            page.open();
            page.uploadFile(testFilePath);

            Assert.assertTrue(page.isUploadedFilePathVisible(), "Ожидалось появление пути к загруженному файлу");
            String uploadedPath = page.getUploadedFilePath();
            Assert.assertFalse(uploadedPath.isEmpty(), "Ожидалось, что путь к загруженному файлу не пустой");
            
            File testFile = new File(testFilePath);
            Assert.assertTrue(page.getUploadedFilePath().contains(testFile.getName()), 
                    "Ожидалось, что путь содержит имя загруженного файла");
        } finally {
            new File(testFilePath).delete();
        }
    }

    @Test
    public void shouldDisplayDownloadButton() {
        UploadDownloadPage page = new UploadDownloadPage(driver, wait);

        page.open();

        Assert.assertTrue(page.isDownloadButtonClickable(), "Ожидалось, что кнопка Download доступна");
    }

    @Test
    public void shouldHandleDownloadButtonClick() {
        UploadDownloadPage page = new UploadDownloadPage(driver, wait);

        page.open();
        page.clickDownloadButton();

        Assert.assertTrue(page.isDownloadButtonClickable(), "Ожидалось, что кнопка Download остается доступной");
    }

    @Test
    public void shouldUploadMultipleFiles() {
        UploadDownloadPage page = new UploadDownloadPage(driver, wait);
        String testFile1 = page.createTestFile();
        String testFile2 = page.createTestFile();

        try {
            page.open();
            page.uploadFile(testFile1);

            Assert.assertTrue(page.isUploadedFilePathVisible(), "Ожидалось появление пути к первому загруженному файлу");
            
            page.uploadFile(testFile2);
            Assert.assertTrue(page.isUploadedFilePathVisible(), "Ожидалось появление пути ко второму загруженному файлу");
        } finally {
            new File(testFile1).delete();
            new File(testFile2).delete();
        }
    }

    @Test
    public void shouldValidateUploadedFilePath() {
        UploadDownloadPage page = new UploadDownloadPage(driver, wait);
        String testFilePath = page.createTestFile();

        try {
            page.open();
            page.uploadFile(testFilePath);

            String uploadedPath = page.getUploadedFilePath();
            Assert.assertNotNull(uploadedPath, "Ожидалось, что путь к загруженному файлу не null");
            Assert.assertTrue(uploadedPath.length() > 0, "Ожидалось, что путь к загруженному файлу не пустой");
            
            Assert.assertTrue(uploadedPath.contains("fakepath") || uploadedPath.contains("test"), 
                    "Ожидалось, что путь содержит корректную информацию о файле");
        } finally {
            new File(testFilePath).delete();
        }
    }
}
