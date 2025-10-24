package com.example.pages;

import com.example.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDropPage extends BasePage {
    
    private final By draggableElement = By.id("draggable");
    private final By droppableElement = By.id("droppable");
    private final By droppableText = By.xpath("//div[@id='droppable']/p");

    public DragAndDropPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void open() {
        driver.get("https://demoqa.com/droppable");
    }

    public void performDragAndDrop() {
        WebElement source = waitForElement(draggableElement);
        WebElement target = waitForElement(droppableElement);
        
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }


    public String getDroppableText() {
        return getText(droppableText);
    }


    public boolean isDragAndDropSuccessful() {
        try {
            String text = getDroppableText();
            return text.contains("Dropped!") || text.contains("dropped");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDraggableElementVisible() {
        return isDisplayed(draggableElement);
    }

    public boolean isDroppableElementVisible() {
        return isDisplayed(droppableElement);
    }
}
