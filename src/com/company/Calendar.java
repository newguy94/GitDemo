package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Calendar {

    public static void main(String[] args) {

        // GRAB COMMON ATTRIBUTE/  PUT IT INTO LIST AND ITERATE
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jaishan\\Desktop\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.path2usa.com/travel-companions//");

        driver.findElement(By.xpath("//input[@name='travel_date']")).click();

            while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("August") // ! while this reaches april it becomes false
        ){
            driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']")).click(); // keeps clicking nexst until it reaches July

        }

       List<WebElement> dates = driver.findElements(By.className("datepicker-cal-date")); //put locator into webelement list
        int count = driver.findElements(By.className("datepicker-cal-date")).size(); // to know h   ow many items present in dates

        for(int i=0; i<count ; i++){

            String text =driver.findElements(By.className("datepicker-cal-date")).get(i).getText();

            if(text.equalsIgnoreCase("21")){
                driver.findElements(By.className("datepicker-cal-date")).get(i).click();
                break; // to come out of for loop

            }
        }




    }
}
