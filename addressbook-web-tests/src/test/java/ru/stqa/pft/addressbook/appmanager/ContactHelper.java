package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.ArrayList;
import java.util.List;

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

        // закомментирован код так как нет группы у удаленных контактов
//        if (creation) {
//            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(newContactData.getGroup());
//        } else {
//            Assert.assertFalse(isElementPresent(By.name("new_group")));
//        }
    }

    // метод нажатия на кнопку создания нового контакта
    public void submitNewContactCreation() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    // нажать на иконку карандаша в строке первого по спику контакта
    public void clickModificationContact(int index) {
        wd.findElements(By.cssSelector("tr[name='entry'] td:nth-child(8)")).get(index).click();
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
    public void selektChekboxContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    // нажать на кнопку delete из списка контактов
    public void deleteContact() {
        wd.findElement(By.cssSelector("input[value='Delete']")).click();
    }

    public void createContact(NewContactData contact, boolean b) {
        fillNewContactForm(contact, b);
        submitNewContactCreation();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public List<NewContactData> getContactList() {
        List<NewContactData> contacts = new ArrayList<NewContactData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
        for (WebElement element : elements) {
            String lastName = element.findElement(By.cssSelector("td:nth-child(2)")).getAttribute("textContent");
            String name = element.findElement(By.cssSelector("td:nth-child(3)")).getAttribute("textContent");
            NewContactData contact = new NewContactData(lastName, name);
            contacts.add(contact);
        }
        return contacts;
    }
}
