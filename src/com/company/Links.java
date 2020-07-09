package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Links {

    public static void main(String[] args) throws InterruptedException {

        //1. find links in entire page
        //2. Count links in footer section
        //3. Count links in the column
        //4. click on each link in the column and check if the pages are opening
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jaishan\\Desktop\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/index.htm");

        System.out.println("The number of link present on the site: " + driver.findElements(By.tagName("a")).size());

        WebElement footerDriver = driver.findElement(By.xpath("//div[@class='footer-nav']"));
        System.out.println("Number of links in footer: " + footerDriver.findElements(By.tagName("a")).size());

        WebElement columnDriver = footerDriver.findElement(By.xpath("//div[@class='mui-container']/div[1]/ul"));
        System.out.println("Number of links in column 1: " + columnDriver.findElements(By.tagName("a")).size());

        for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {

            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER); // To open on separate tabs
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(5000L);
        }
        Set<String> abc = driver.getWindowHandles();
        Iterator<String> it = abc.iterator(); // To iterate through every windows

        while (it.hasNext()) {

            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());

        }
    }

}



