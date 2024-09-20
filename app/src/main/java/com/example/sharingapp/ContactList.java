package com.example.sharingapp;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

class ContactList {
    private ArrayList<Contact> contacts;
    private String FILENAME= "contacts.sav";

    public ContactList(){
        contacts=new ArrayList<Contact>();
    }
    public void setContacts(ArrayList<Contact> contact_list){
        contacts=contact_list;
    }

    public ArrayList<Contact> getContacts(){
        return contacts;
    }

    //Todo
    public ArrayList<String> getAllUsernames(){
        ArrayList<String> allUserNames = new ArrayList<String>();
        for (Contact x:contacts
        ) {

            allUserNames.add(x.getUsername());
        }
        return allUserNames;
    }

    public void addContact(Contact contact){
        contacts.add(contact);
    }

    public void deleteContact(Contact contact){
        contacts.remove(contact);
    }

    public Contact getContact(int index){
        return contacts.get(index);

    }

    public int getSize(){
        return contacts.size();
    }

    public int getIndex(Contact contact){
        int pos = 0;
        for (Contact i : contacts) {
            if (contact.getId().equals(i.getId())) {
                return pos;
            }
            pos = pos+1;
        }
        return -1;
    }
    //todo
    public boolean hasContact(Contact contact){
        if(contacts.contains(contact)){
            return true;
        }else {
            return false;
        }
    }
    //todo
    public Contact getContactByUsername(String username) {
        for (Contact x : contacts) {
            if (x.getUsername().equals(username)) {
                return x;
            }
        }
        return null;
    }



    public void loadContacts(Context context){
//        Todo loadcontacts
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Contact>>() {}.getType();
            contacts = gson.fromJson(isr, listType); // temporary
            fis.close();
        } catch (FileNotFoundException e) {
            contacts = new ArrayList<Contact>();
        } catch (IOException e) {
            contacts = new ArrayList<Contact>();
        }

    }

    public void saveContacts (Context context){
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, 0);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(contacts, osw);
            osw.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //todo
    public boolean isUsernameAvailable(String username){
        boolean usernameAvailable=true;
        for (Contact x:contacts
        ) {
            if(x.getUsername()==username)
            {return false;
            }
        }
        return usernameAvailable;
//        ToDo return true or false dependes on the username is available or not

    }

}
