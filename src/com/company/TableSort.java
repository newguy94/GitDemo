package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableSort {

    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jaishan\\Desktop\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector("tr th:nth-child(2)")).click(); // Without this double click Test case will fail
        driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
        //attribute for columnn xpath= //tr/td or //td/td[2] , css= tr td or tr td:nth-child(2)
        List<WebElement> firstColList = driver.findElements(By.cssSelector("tr td:nth-child(2)"));

        //copy list into array

        ArrayList<String> originalList = new ArrayList<String>();
        for (int i = 0; i < firstColList.size(); i++) {
           originalList.add(firstColList.get(i).getText());
        }

        ArrayList<String> copiedList = new ArrayList<String>();
        for(int i=0; i<originalList.size(); i++){
            copiedList.add(originalList.get(i));

        }
        System.out.println("***************************************************");
        Collections.sort(copiedList); // To sort the copied list
        for( String s: copiedList){
            System.out.println(s);
        }
        System.out.println("*********ORIGINAL LIST*******************************");
        for( String s: originalList){
            System.out.println(s);
        }
        Assert.assertTrue(originalList.equals(copiedList)); // returns true if both list are true , if condition its true test case will pass


    }
}
