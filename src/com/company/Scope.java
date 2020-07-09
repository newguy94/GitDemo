package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Scope {

    public static void main(String[] args) throws InterruptedException {

        // 1. Give me the links count of this page
        //2. Count of links in the footer section

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jaishan\\Desktop\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size()); // to get a count of links present on webpage

        WebElement footerDriver = driver.findElement(By.id("gf-BIG")); // limiting webdriver scope to footer
        System.out.println(footerDriver.findElements(By.tagName("a")).size()); // to get  count of link present on footer
            //3. Count of the links in the column
        WebElement columnDriver= footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columnDriver.findElements(By.tagName("a")).size());

        //4. click on each link in the column and check if the pages are opening
        for(int i=1; i<columnDriver.findElements(By.tagName("a")).size();i++) {

            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER); // To open on separate tabs
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(5000L);
        }
            Set<String> abc= driver.getWindowHandles();
           Iterator<String> it= abc.iterator(); // To iterate through every windows

            while(it.hasNext()){

                driver.switchTo().window(it.next());
                System.out.println(driver.getTitle());
            }
        }
    }

