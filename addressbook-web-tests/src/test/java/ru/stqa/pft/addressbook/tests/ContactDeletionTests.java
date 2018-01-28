package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testDeletionTests() {
        app.goTo().gotoHome();
        if (!app.getContactHelper().isThereAContact()) {
            app.goTo().gotoAddNew();
            app.getContactHelper().createContact(new NewContactData(
                    "Petr",
                    "Petrov"), true);
        }
        // получаем список всех контактов на странице
        List<NewContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selektChekboxContact(before.size() - 1);
        app.getContactHelper().deleteContact();
        app.wd.switchTo().alert().accept();
        // возвращаемя на страницу с контактами
        app.goTo().gotoHome();
        // ждем пока таблица с контактами загрузится
        pause(10000);
        // заново получаем список контактов на странице списка всех контактов
        List<NewContactData> after = app.getContactHelper().getContactList();
        // сравниваем размер 2х списков before и after
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1); // удаляем

        Comparator<? super NewContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

    public void pause(Integer milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
