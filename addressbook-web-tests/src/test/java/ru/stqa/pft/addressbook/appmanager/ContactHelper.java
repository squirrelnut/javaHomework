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

    public void clickModificationContact() {

        wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")).click();

    }

    public void submitModificationContact() {
        wd.findElement(By.xpath("//div[@id='content']/form[1]/input[22]")).click();


    }

    public void clickDeleteContact() {
        wd.findElement(By.xpath("//div[@id='content']/form[2]/input[2]")).click();
    }
}
