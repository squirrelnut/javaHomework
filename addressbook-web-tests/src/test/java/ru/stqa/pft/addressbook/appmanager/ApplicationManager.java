package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import sun.plugin2.util.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver wd; // обявляем драйвер

    // объявляем делегатов
    private ContactHelper contactHelper;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }



    // инициализируем браузер
    public void init() {
        if (browser == org.openqa.selenium.remote.BrowserType.FIREFOX) {
            wd = new FirefoxDriver();
        } else  if (browser == org.openqa.selenium.remote.BrowserType.CHROME) {
            wd = new ChromeDriver();
        } else if (browser == org.openqa.selenium.remote.BrowserType.IE) {
            wd = new InternetExplorerDriver();
        }

//        wd = new FirefoxDriver(new FirefoxOptions()
//                .setLegacy(true)
//                .setBinary("C:/Program Files/Mozilla Firefox ESR/firefox.exe"));

        System.out.println(((HasCapabilities) wd).getCapabilities()); // Печать в консоль настроек.


        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // Открываем страницу
        wd.get("http://localhost/addressbook/");

        // Инициализируем делегатов
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        contactHelper = new ContactHelper(wd);
        sessionHelper = new SessionHelper(wd);

        // логинимся
        sessionHelper.login("admin", "secret");
    }

    // выход
    public void stop() {
        wd.quit();
    }

    // геттеры делегатов
    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }


    // какая-то функция... (не используется в тестах)
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
