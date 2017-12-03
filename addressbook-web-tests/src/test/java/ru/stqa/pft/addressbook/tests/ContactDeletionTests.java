package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testDeletionTests (){
        app.getNavigationHelper().gotoHome();
        app.getContactHelper().clickModificationContact();
        app.getContactHelper().clickDeleteContact();
    }
}
