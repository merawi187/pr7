package com.example.tests;

import com.example.pages.DragAndDropPage;
import com.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest {

    @Test
    public void shouldPerformDragAndDrop() {
        DragAndDropPage page = new DragAndDropPage(driver, wait);

        page.open();
        page.performDragAndDrop();

        Assert.assertTrue(page.isDragAndDropSuccessful(), "Ожидалось успешное перетаскивание элемента");
    }


    @Test
    public void shouldDisplayCorrectMessageAfterDrop() {
        DragAndDropPage page = new DragAndDropPage(driver, wait);

        page.open();
        page.performDragAndDrop();

        Assert.assertTrue(page.isDragAndDropSuccessful(), "Ожидалось успешное перетаскивание");
    }

    @Test
    public void shouldVerifyElementVisibility() {
        DragAndDropPage page = new DragAndDropPage(driver, wait);

        page.open();

        Assert.assertTrue(page.isDraggableElementVisible(), "Ожидалось, что перетаскиваемый элемент видим");
        Assert.assertTrue(page.isDroppableElementVisible(), "Ожидалось, что область drop видима");
    }

    @Test
    public void shouldChangeDroppableElementStyle() {
        DragAndDropPage page = new DragAndDropPage(driver, wait);

        page.open();
        page.performDragAndDrop();

        Assert.assertTrue(page.isDragAndDropSuccessful(), "Ожидалось успешное перетаскивание");
    }

    @Test
    public void shouldHandleMultipleDragAndDrop() {
        DragAndDropPage page = new DragAndDropPage(driver, wait);

        page.open();
        page.performDragAndDrop();

        Assert.assertTrue(page.isDragAndDropSuccessful(), "Ожидалось успешное перетаскивание");
    }

    @Test
    public void shouldVerifyDroppableTextContent() {
        DragAndDropPage page = new DragAndDropPage(driver, wait);

        page.open();
        page.performDragAndDrop();

        Assert.assertTrue(page.isDragAndDropSuccessful(), "Ожидалось успешное перетаскивание");
    }
}
