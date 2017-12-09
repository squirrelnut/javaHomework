package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    // метод для заполнения полей нового контакта
    public void fillNewContactForm(NewContactData newContactData, boolean creation) {
        type(By.name("firstname"), newContactData.getName());
        type(By.name("lastname"), newContactData.getLastName());
        type(By.name("address"), newContactData.getAddress());
        type(By.name("home"), newContactData.getHomePhoneNumber());
        type(By.name("mobile"), newContactData.getMobilePhoneNumber());
        type(By.name("email"), newContactData.getEmail());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(newContactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    // метод нажатия на кнопку создания нового контакта
    public void submitNewContactCreation() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    // нажать на иконку карандаша в строке первого по спику контакта
    public void clickModificationContact() {
        wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")).click();
    }

    // нажать на кнопку update изменений на экране модификации контакта
    public void submitModificationContact() {
        wd.findElement(By.xpath("//div[@id='content']/form[1]/input[22]")).click();
    }

    // нажатие на кнопку delete в окнце модификации контакта
    public void clickDeleteContact() {
        wd.findElement(By.xpath("//div[@id='content']/form[2]/input[2]")).click();
    }

    // выбор первого чекбокса из списка контактов
    public void selektChekboxContact() {
        click(By.name("selected[]"));
    }

    // нажать на кнопку delete из списка контактов
    public void deleteContact() {
        wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
    }
}
