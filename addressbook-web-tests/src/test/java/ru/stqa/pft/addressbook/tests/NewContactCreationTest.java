package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

public class NewContactCreationTest extends TestBase {

    @Test
    public void testNewContactCreation() {
        app.getNavigationHelper().gotoAddNew();
        app.getContactHelper().fillNewContactForm(new NewContactData(
                "Petr",
                "Petrov",
                "Moscow",
                "8-495-123-45-68",
                "8-900-123-45-68",
                "mail1@mail.com"));
        app.getContactHelper().submitNewContactCreation();
    }
}
