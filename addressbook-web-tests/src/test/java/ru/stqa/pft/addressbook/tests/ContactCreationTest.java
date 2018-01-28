package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

    @Test
    public void testNewContactCreation() {
        // получаем список всех контактов на странице
        List<NewContactData> before = app.getContactHelper().getContactList();
        // перешли на страницу создания нового контакта
        app.goTo().gotoAddNew();
        // создаем экземпляр класса NewContactData
        NewContactData contact = new NewContactData("Sidorov","Sidor");
        // создаем новый контакт с данными см. строчку выше в адресбуке
        app.getContactHelper().createContact(contact, true);
        // заново получаем список контактов на странице списка всех контактов
        List<NewContactData> after = app.getContactHelper().getContactList();
        // сравниваем размер 2х списков before и after
        Assert.assertEquals(after.size(), before.size()+1);

        // добавляем в список before экземпляр класса NewContactData (который только что создали в адресбуке)
        before.add(contact);

        Comparator<? super NewContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
