package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactHelper extends HelperBase {
    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    // метод для заполнения полей нового контакта
    public void fillNewContactForm(NewContactData newContactData) {
        type(By.name("firstname"), newContactData.getName());
        type(By.name("lastname"), newContactData.getLastName());
        type(By.name("address"), newContactData.getAddress());
        type(By.name("home"), newContactData.getHomePhoneNumber());
        type(By.name("mobile"), newContactData.getMobilePhoneNumber());
        type(By.name("email"), newContactData.getEmail());
    }

    // метод нажатия на кнопку создания нового контакта
    public void submitNewContactCreation() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }
}
