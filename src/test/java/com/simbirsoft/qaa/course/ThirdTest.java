package com.simbirsoft.qaa.course;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ThirdTest {

    private static WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://google.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void sTest() throws IOException, UnsupportedFlavorException {

        String stringInput = "Автоматизация тестирования";

        // Перемещение строки в буфер обмена
        StringSelection stringSelection = new StringSelection(stringInput);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        WebElement searchInputElement = driver.findElement(By.cssSelector("input[title='Поиск']"));
        searchInputElement.sendKeys( Keys.CONTROL+"v");

        // Нахождение поля с нужным текстом, и считывание этого текста в переменную типа String
        WebElement gitTextElement = driver.findElement(By.cssSelector("input[title='Поиск']"));
        String string = gitTextElement.getAttribute("value");

        System.out.println(stringInput.equals(string));
    }

    @AfterMethod
   public void after() {
        driver.quit();
    }
}

