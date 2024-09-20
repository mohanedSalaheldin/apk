
package com.example.sharingapp;

import  java.util.UUID;

class Contact {
    private String username;
    private String email;
    private String id;

    public Contact(String username, String email, String id) {
        this.username = username;
        this.email = email;
        if (id == null){
            setId();
        } else {
            updateId(id);
        }
    }

    public void setId() {
        this.id = UUID.randomUUID().toString();
    }

    public  String getId(){
        return id;
    }
    public void updateId(String id){
        this.id = id;
    }

//    TODO I think here there is an error in the value you set it
    public void setUsername(String newUsername){
        this.username=newUsername;
    }

    public String getUsername(){
        return username;
    }

    //    TODO I think here there is an error in the value you set it
    public void setEmail(String userEmail){
        this.email=userEmail;
    }

    public String getEmail(){
        return email;
    }

}
