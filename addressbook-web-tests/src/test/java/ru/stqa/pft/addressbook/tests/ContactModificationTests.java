package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactModificationTests extends TestBase {


    @Test
    public void testContactModification () {
        app.getNavigationHelper().gotoHome();
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoAddNew();
            app.getContactHelper().createContact(new NewContactData(
                    "Petr",
                    "Petrov",
                    "Moscow",
                    "8-495-123-45-68",
                    "8-900-123-45-68",
                    "mail1@mail.com",
                    "test1"), true);
            app.getNavigationHelper().gotoHome();
        }

        app.getContactHelper().clickModificationContact();
        app.getContactHelper().fillNewContactForm(new NewContactData(
                "Alexander",
                "Alexandrov",
                "Moscow",
                "8-495-123-45-68",
                "8-900-123-45-68",
                "mail1@mail.com",
                null), false);
        app.getContactHelper().submitModificationContact();

    }

}
