package com.android.agenda.model;

import androidx.annotation.NonNull;

public class CreateDriver {

    private final String name;
    private final String phone;
    private final String email;

    public CreateDriver(String name, String phone, String email) {

        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @NonNull
    @Override
    public String toString() {
        return "Nome: "+getName()+"\n" +"E-mail: "+getEmail()+"\n"+"Telefone: "+getPhone();

    }
}
