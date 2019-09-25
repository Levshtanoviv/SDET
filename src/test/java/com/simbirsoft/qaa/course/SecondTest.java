package com.simbirsoft.qaa.course;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SecondTest {

    private static WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://clipboardjs.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void sTest() throws IOException, UnsupportedFlavorException {

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,2000)");

        // Нажатие на кнопку "Скопировать"
        WebElement clipButtonElement = driver.findElement(By.cssSelector(".input-group-button > .btn"));
        clipButtonElement.click();

        // Перемещение в переменную типа String текста из буфера обмена
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String paste = (String) clipboard.getContents(null).getTransferData(DataFlavor.stringFlavor);

        // Нахождение поля с нужным текстом, и считывание этого текста в переменную типа String
        WebElement gitTextElement = driver.findElement(By.cssSelector("input[value='https://github.com/zenorocha/clipboard.js.git']"));
        String string = gitTextElement.getAttribute("value");

        System.out.println(paste.equals(string));
    }

//    @AfterMethod
//   public void after() {
//        driver.quit();
//    }
}


