package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {


    @Test
    public void testContactModification () {
        // Перешли на страницу с контактами
        app.getNavigationHelper().gotoHome();
        // Проверяем предусловие (если ни одного контакта нет, то создаем его)
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoAddNew();
//            app.getContactHelper().createContact(new NewContactData(
//                    "Petr",
//                    "Petrov",
//                    "Moscow",
//                    "8-495-123-45-68",
//                    "8-900-123-45-68",
//                    "mail1@mail.com",
//                    "test1"), true);
            app.getContactHelper().createContact(new NewContactData(
                    "Petr",
                    "Petrov"), true);
            app.getNavigationHelper().gotoHome();
        }

        // получаем список всех контактов на странице
        List<NewContactData> before = app.getContactHelper().getContactList();
        // создаем экземпляр класса NewContactData
        NewContactData contact = new NewContactData("Sidorov","Sidor");
        // открываем контакт
        app.getContactHelper().clickModificationContact(before.size()-1);
        // изменяем его на новый
        app.getContactHelper().fillNewContactForm(contact, false);
        // сохраняем изменения
        app.getContactHelper().submitModificationContact();

        // заново получаем список контактов на странице списка всех контактов
        List<NewContactData> after = app.getContactHelper().getContactList();
        // сравниваем размер 2х списков before и after
        Assert.assertEquals(after.size(), before.size());
        // удаляем модифицированный контакт (старый, который был до модификации)
        before.remove(before.size() - 1);
        // добавляем новый контакт (уже модифицированный)
        before.add(contact);
        Comparator<? super NewContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
