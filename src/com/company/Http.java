package com.company;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Http {
    public static void main(String[] args) {

    //SSL certification -
        DesiredCapabilities ch= DesiredCapabilities.chrome(); // to add desired capabilities to chrome browser
        ch.acceptInsecureCerts();

    ChromeOptions c = new ChromeOptions();// Chrome options to customize chrome browser
        c.merge(ch); // Merge desired capabilities to chrome browser


        System.out.println("Git practice");
    }
}
