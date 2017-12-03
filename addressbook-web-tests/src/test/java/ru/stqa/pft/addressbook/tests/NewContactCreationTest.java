package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.NewContactData;

public class NewContactCreationTest extends TestBase {
    
//    @BeforeMethod
//    public void setUp() throws Exception {
//        // По старой схеме (бразуер ESR 52)
//        wd = new FirefoxDriver(new FirefoxOptions()
//                .setLegacy(true)
//                .setBinary("C:/Program Files/Mozilla Firefox ESR/firefox.exe"));
//
//        System.out.println(((HasCapabilities) wd).getCapabilities()); // Печать в консоль настроек.
//        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        wd.get("http://localhost/addressbook/edit.php");
//        login("admin", "secret");
//    }

//    private void login(String username, String password) {
//        wd.findElement(By.name("user")).click();
//        wd.findElement(By.name("user")).clear();
//        wd.findElement(By.name("user")).sendKeys(username);
//        wd.findElement(By.id("LoginForm")).click();
//        wd.findElement(By.name("pass")).click();
//        wd.findElement(By.name("pass")).clear();
//        wd.findElement(By.name("pass")).sendKeys(password);
//        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
//    }

    @Test
    public void testNewContactCreation() {
        app.getNavigationHelper().gotoAddNew();
        app.getContactHelper().fillNewContactForm(new NewContactData(
                "Petr",
                "Petrov",
                "Moscow",
                "8-495-123-45-68",
                "8-900-123-45-68",
                "mail1@mail.com"));
        app.getContactHelper().submitNewContactCreation();
    }


//    @AfterMethod
//    public void tearDown() {
//        wd.quit();
//    }
//
//    public static boolean isAlertPresent(FirefoxDriver wd) {
//        try {
//            wd.switchTo().alert();
//            return true;
//        } catch (NoAlertPresentException e) {
//            return false;
//        }
//    }
}
