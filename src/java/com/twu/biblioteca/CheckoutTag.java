package com.twu.biblioteca;

/**
 * Created by fcmeng on 2/27/15.
 */
public class CheckoutTag {
    private String user, name;

    public CheckoutTag(String user, String name) {
        this.user = user;
        this.name = name;
    }

    public String[] getInfo() {
        return new String[]{this.user, this.name};
    }
}
