package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalendarPractice {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jaishan\\Desktop\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.easyjet.com/en/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // 5 seconds is the maximum time it will wait and its applie globally to each line of this test
        WebDriverWait w = new WebDriverWait(driver,5);


        driver.findElement(By.cssSelector("span[class='checkbox-container']")).click();

        driver.findElement(By.xpath("//div[@class='route-date-picker'] //div[@class='outbound-date-picker']")).click();

       if(driver.findElement(By.xpath("//div[@class='month'] //div[@class='route-date-picker-month']/h3")).getText().contains("July 2020")){
           driver.findElements(By.xpath("//div[@class='month'] //div[@class='route-date-picker-month']/h3"));

       }

        List<WebElement> dates = driver.findElements(By.className("day")); //put locator into webelement list
        int count = driver.findElements(By.className("day")).size(); // to know how many items present in dates

        for(int i = 0; i<count ; i++){

                String text =driver.findElements(By.className("day")).get(i).getText();

                if(text.equalsIgnoreCase("21")){
                    driver.findElements(By.className("day")).get(i).click();
                    break; // to come out of for loop

                }
            }




    }
  }


