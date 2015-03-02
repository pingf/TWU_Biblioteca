package com.twu.biblioteca;

/**
 * Created by fcmeng on 2/28/15.
 */
public class Account {
    private String name;
    private String password;
    private String id;
    private String email;
    private String phone;

    public Account(String name, String password, String email, String phone) {
        this.id=generateID();
        this.name=name;
        this.password=password;
        this.email=email;
        this.phone=phone;

    }

    public String getId(){
        return this.id;
    }

    public String getPassword(){
        return this.password;
    }

    private String generateID() {
        return "123-4567";
    }

    public String[] getInfo() {
        return new String[]{this.id,this.name,this.email,this.phone};
    }
}
