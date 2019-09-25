package com.simbirsoft.qaa.course;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ManageBrowser {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.get("https://clipboardjs.com");


        WebElement searchInputElement = driver.findElement(By.cssSelector("input[title='Поиск']"));
        searchInputElement.sendKeys("Автоматизация тестирования" + Keys.TAB);

        WebElement searchButtonElement = driver.findElement(By.xpath("//div[not(@jsname)]/center/input[@value='Поиск в Google']"));
        searchButtonElement.click();

        //driver.quit();
    }
}
