package com.company;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Cookies {
    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jaishan\\Desktop\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //driver.manage().deleteCookieNamed("sessionkey");

        driver.get("https://www.google.com/");

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // Store Screenshot in Src
        FileUtils.copyFile(src, new File("C:\\Users\\Jaishan"));
    }
}