package vn.edu.ntu.nhatduy.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.nhatduy.model.Contact;

public class ContactController extends Application implements IContactController{
    List<Contact> listContacts = new ArrayList<>();

    public ContactController(){
        listContacts.add(new Contact("Thu Cúc","14/2/1990","090123456"));
        listContacts.add(new Contact("Thu Đủ","8/3/1991","090123456"));
        listContacts.add(new Contact("Thu Tiền","30/4/1990","090123456"));
        listContacts.add(new Contact("Nhật Duy","5/8/1999","0123456789"));
        listContacts.add(new Contact("Hoàng Khoa","29/1/1999","012345678"));
    }

    @Override
    public List<Contact> getAllContact() {
        return listContacts;
    }
}
