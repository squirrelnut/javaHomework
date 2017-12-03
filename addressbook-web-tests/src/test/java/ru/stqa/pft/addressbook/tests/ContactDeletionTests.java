package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testDeletionTests (){
        app.getNavigationHelper().gotoHome();
        app.getContactHelper().selektChekboxContact();
        app.getContactHelper().deleteContact();
        app.wd.switchTo().alert().accept();
    }
}
