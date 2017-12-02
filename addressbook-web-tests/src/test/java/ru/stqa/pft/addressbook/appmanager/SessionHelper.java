package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase {


    public SessionHelper(FirefoxDriver wd) {

        super(wd);
    }

    public void login(String username, String password) {
        type(By.id("user"), username);
        type(By.id("pass"), password);
        click(By.xpath("//form[@id='LoginForm']/input[3]"));

    }
}
